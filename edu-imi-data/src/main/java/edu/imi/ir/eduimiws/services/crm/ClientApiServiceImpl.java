package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.ClientApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.crm.ClientApiMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ClientApiDto;
import edu.imi.ir.eduimiws.models.request.ClientApiCreateRequest;
import edu.imi.ir.eduimiws.models.request.ClientApiUpdateRequest;
import edu.imi.ir.eduimiws.repositories.crm.ClientApiRepository;
import edu.imi.ir.eduimiws.repositories.crm.PersonApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientApiServiceImpl implements ClientApiService {

    private static final Long ENABLED_YES = 1L;
    private static final String ACTIVE_PERSON_STATUS = "1";

    private final ClientApiRepository clientApiRepository;
    private final PersonApiRepository personApiRepository;
    private final ClientApiMapper clientApiMapper;
    private final PublicIdUtil publicIdUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ClientApiDto create(ClientApiCreateRequest request) {
        validateCreateRequest(request);

        if (clientApiRepository.existsByClientIdAndDeleteDateTsIsNull(request.getClientId().trim())) {
            throw new BadRequestException("clientId already exists");
        }

        PersonApiEntity personApi = resolvePersonApi(request.getPersonPublicId().trim());
        if (clientApiRepository.existsByPersonApi_IdAndDeleteDateTsIsNull(personApi.getId())) {
            throw new BadRequestException("a client already exists for this personPublicId");
        }

        String plaintextSecret = request.getClientSecret().trim();
        String clientId = request.getClientId().trim();

        ClientApiEntity entity = new ClientApiEntity();
        entity.setClientPublicId(publicIdUtil.generateUniquePublicId());
        entity.setClientId(clientId);
        entity.setClientSecretHash(bCryptPasswordEncoder.encode(plaintextSecret));
        entity.setPersonApi(personApi);
        entity.setCompanyName(trimToNull(request.getCompanyName()));
        entity.setDescription(trimToNull(request.getDescription()));
        entity.setEnabled(request.getEnabled() != null ? request.getEnabled() : ENABLED_YES);
        entity.setCreateDateTs(now());

        ClientApiEntity saved = clientApiRepository.save(entity);
        ClientApiDto dto = clientApiMapper.toClientApiDto(saved);
        dto.setPersonPublicId(personApi.getPersonPublicId());
        dto.setClientSecret(plaintextSecret);
        dto.setClientCredentialsBase64(encodeCredentials(clientId, plaintextSecret));
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClientApiDto> findAllActive(Pageable pageable) {
        return clientApiRepository.findAllByDeleteDateTsIsNull(pageable)
                .map(clientApiMapper::toClientApiDto);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientApiDto findByClientPublicId(String clientPublicId) {
        return clientApiMapper.toClientApiDto(requireActiveClient(clientPublicId));
    }

    @Override
    public ClientApiDto update(String clientPublicId, ClientApiUpdateRequest request) {
        if (request == null) {
            throw new BadRequestException("request body is required");
        }

        ClientApiEntity entity = requireActiveClient(clientPublicId);
        boolean changed = false;

        if (hasText(request.getClientId())) {
            String newClientId = request.getClientId().trim();
            if (!newClientId.equals(entity.getClientId())
                    && clientApiRepository.existsByClientIdAndDeleteDateTsIsNullAndIdNot(newClientId, entity.getId())) {
                throw new BadRequestException("clientId already exists");
            }
            entity.setClientId(newClientId);
            changed = true;
        }

        if (hasText(request.getClientSecret())) {
            entity.setClientSecretHash(bCryptPasswordEncoder.encode(request.getClientSecret().trim()));
            changed = true;
        }

        if (hasText(request.getPersonPublicId())) {
            PersonApiEntity personApi = resolvePersonApi(request.getPersonPublicId().trim());
            if (!personApi.getId().equals(entity.getPersonApiId())
                    && clientApiRepository.existsByPersonApi_IdAndDeleteDateTsIsNullAndIdNot(personApi.getId(), entity.getId())) {
                throw new BadRequestException("a client already exists for this personPublicId");
            }
            entity.setPersonApi(personApi);
            changed = true;
        }

        if (hasText(request.getCompanyName())) {
            entity.setCompanyName(request.getCompanyName().trim());
            changed = true;
        }

        if (hasText(request.getDescription())) {
            entity.setDescription(request.getDescription().trim());
            changed = true;
        }

        if (request.getEnabled() != null) {
            entity.setEnabled(request.getEnabled());
            changed = true;
        }

        if (changed) {
            entity.setEditDateTs(now());
            entity = clientApiRepository.save(entity);
        }

        return clientApiMapper.toClientApiDto(entity);
    }

    @Override
    public ClientApiDto softDelete(String clientPublicId) {
        ClientApiEntity entity = requireActiveClient(clientPublicId);
        entity.setDeleteDateTs(now());
        entity.setEditDateTs(now());
        return clientApiMapper.toClientApiDto(clientApiRepository.save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public PersonApiEntity authenticateByCredentialsBase64(String credentialsBase64) {
        if (!hasText(credentialsBase64)) {
            throw new BadRequestException("credentials are required");
        }

        String[] parts = decodeCredentials(credentialsBase64.trim());
        String clientId = parts[0];
        String clientSecret = parts[1];

        ClientApiEntity client = clientApiRepository.findActiveByClientIdWithPerson(clientId)
                .orElseThrow(() -> new BadRequestException("invalid client credentials"));

        if (!ENABLED_YES.equals(client.getEnabled())) {
            throw new BadRequestException("client is disabled");
        }

        if (!bCryptPasswordEncoder.matches(clientSecret, client.getClientSecretHash())) {
            throw new BadRequestException("invalid client credentials");
        }

        PersonApiEntity personApi = client.getPersonApi();
        if (personApi == null) {
            throw new BadRequestException("client person is not configured");
        }

        PersonEntity person = personApi.getPerson();
        if (person == null || !ACTIVE_PERSON_STATUS.equals(person.getActivityStatus())) {
            throw new BadRequestException("linked person is not active");
        }

        return personApi;
    }

    private ClientApiEntity requireActiveClient(String clientPublicId) {
        if (!hasText(clientPublicId)) {
            throw new BadRequestException("clientPublicId is required");
        }
        return clientApiRepository.findByClientPublicIdAndDeleteDateTsIsNull(clientPublicId.trim())
                .orElseThrow(() -> new NotFoundException("requested client not found"));
    }

    private PersonApiEntity resolvePersonApi(String personPublicId) {
        PersonApiEntity personApi = personApiRepository.findByPersonPublicId(personPublicId);
        if (personApi == null) {
            throw new NotFoundException("requested personPublicId not found");
        }
        return personApi;
    }

    private void validateCreateRequest(ClientApiCreateRequest request) {
        if (request == null) {
            throw new BadRequestException("request body is required");
        }
        if (!hasText(request.getClientId())) {
            throw new BadRequestException("clientId is required");
        }
        if (!hasText(request.getClientSecret())) {
            throw new BadRequestException("clientSecret is required");
        }
        if (!hasText(request.getPersonPublicId())) {
            throw new BadRequestException("personPublicId is required");
        }
    }

    private String[] decodeCredentials(String credentialsBase64) {
        String decoded;
        try {
            decoded = new String(Base64.getDecoder().decode(credentialsBase64), StandardCharsets.UTF_8);
        } catch (IllegalArgumentException exception) {
            throw new BadRequestException("credentials must be valid Base64 of clientId:clientSecret");
        }

        int separator = decoded.indexOf(':');
        if (separator <= 0 || separator == decoded.length() - 1) {
            throw new BadRequestException("credentials must be Base64 of clientId:clientSecret");
        }
        return new String[]{decoded.substring(0, separator), decoded.substring(separator + 1)};
    }

    private String encodeCredentials(String clientId, String clientSecret) {
        String raw = clientId + ":" + clientSecret;
        return Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    private boolean hasText(String value) {
        return value != null && !value.isBlank();
    }

    private String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    private Timestamp now() {
        return new Timestamp(new Date().getTime());
    }
}
