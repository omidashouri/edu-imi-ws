package edu.imi.ir.eduimiws.services.crm.v2;

import edu.imi.ir.eduimiws.domain.crm.ClientApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.BadRequestException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.crm.v2.ClientApiMapper;
import edu.imi.ir.eduimiws.models.dto.crm.v2.ClientApiDto;
import edu.imi.ir.eduimiws.models.request.crm.v2.ClientApiCreateRequest;
import edu.imi.ir.eduimiws.models.request.crm.v2.ClientApiUpdateRequest;
import edu.imi.ir.eduimiws.repositories.crm.ClientApiRepository;
import edu.imi.ir.eduimiws.repositories.crm.PersonApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        log.info("ClientApiService.create - clientId: {}, personPublicId: {}, companyName: {}, description: {}, enabled: {}, clientSecret: [REDACTED]",
                request != null ? request.getClientId() : null,
                request != null ? request.getPersonPublicId() : null,
                request != null ? request.getCompanyName() : null,
                request != null ? request.getDescription() : null,
                request != null ? request.getEnabled() : null);
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
        log.info("ClientApiService.create - result: [REDACTED], clientPublicId: {}, clientId: {}, personPublicId: {}",
                dto.getClientPublicId(), dto.getClientId(), dto.getPersonPublicId());
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClientApiDto> findAllActive(Pageable pageable) {
        log.info("ClientApiService.findAllActive - pageable: {}", pageable);
        Page<ClientApiDto> result = clientApiRepository.findAllByDeleteDateTsIsNull(pageable)
                .map(clientApiMapper::toClientApiDto);
        log.info("ClientApiService.findAllActive - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public ClientApiDto findByClientPublicId(String clientPublicId) {
        log.info("ClientApiService.findByClientPublicId - clientPublicId: {}", clientPublicId);
        ClientApiDto result = clientApiMapper.toClientApiDto(requireActiveClient(clientPublicId));
        log.info("ClientApiService.findByClientPublicId - result: {}", result);
        return result;
    }

    @Override
    public ClientApiDto update(String clientPublicId, ClientApiUpdateRequest request) {
        logUpdateRequest(clientPublicId, request);
        if (request == null) {
            throw new BadRequestException("request body is required");
        }

        ClientApiEntity entity = requireActiveClient(clientPublicId);
        boolean changed = applyClientIdUpdate(entity, request);
        changed |= applyClientSecretUpdate(entity, request);
        changed |= applyPersonPublicIdUpdate(entity, request);
        changed |= applyCompanyNameUpdate(entity, request);
        changed |= applyDescriptionUpdate(entity, request);
        changed |= applyEnabledUpdate(entity, request);

        if (changed) {
            entity.setEditDateTs(now());
            entity = clientApiRepository.save(entity);
        }

        ClientApiDto result = clientApiMapper.toClientApiDto(entity);
        log.info("ClientApiService.update - result: {}", result);
        return result;
    }

    @Override
    public ClientApiDto softDelete(String clientPublicId) {
        log.info("ClientApiService.softDelete - clientPublicId: {}", clientPublicId);
        ClientApiEntity entity = requireActiveClient(clientPublicId);
        entity.setDeleteDateTs(now());
        entity.setEditDateTs(now());
        ClientApiDto result = clientApiMapper.toClientApiDto(clientApiRepository.save(entity));
        log.info("ClientApiService.softDelete - result: {}", result);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonApiEntity authenticateByCredentialsBase64(String credentialsBase64) {
        log.info("ClientApiService.authenticateByCredentialsBase64 - credentialsBase64: [REDACTED]");
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

        log.info("ClientApiService.authenticateByCredentialsBase64 - result: {}, clientId: {}", personApi, clientId);
        return personApi;
    }

    private void logUpdateRequest(String clientPublicId, ClientApiUpdateRequest request) {
        if (request == null) {
            log.info("ClientApiService.update - clientPublicId: {}, request: null, clientSecret: [REDACTED]", clientPublicId);
            return;
        }
        log.info("ClientApiService.update - clientPublicId: {}, clientId: {}, personPublicId: {}, companyName: {}, description: {}, enabled: {}, clientSecret: [REDACTED]",
                clientPublicId,
                request.getClientId(),
                request.getPersonPublicId(),
                request.getCompanyName(),
                request.getDescription(),
                request.getEnabled());
    }

    private boolean applyClientIdUpdate(ClientApiEntity entity, ClientApiUpdateRequest request) {
        if (!hasText(request.getClientId())) {
            return false;
        }
        String newClientId = request.getClientId().trim();
        if (!newClientId.equals(entity.getClientId())
                && clientApiRepository.existsByClientIdAndDeleteDateTsIsNullAndIdNot(newClientId, entity.getId())) {
            throw new BadRequestException("clientId already exists");
        }
        entity.setClientId(newClientId);
        return true;
    }

    private boolean applyClientSecretUpdate(ClientApiEntity entity, ClientApiUpdateRequest request) {
        if (!hasText(request.getClientSecret())) {
            return false;
        }
        entity.setClientSecretHash(bCryptPasswordEncoder.encode(request.getClientSecret().trim()));
        return true;
    }

    private boolean applyPersonPublicIdUpdate(ClientApiEntity entity, ClientApiUpdateRequest request) {
        if (!hasText(request.getPersonPublicId())) {
            return false;
        }
        PersonApiEntity personApi = resolvePersonApi(request.getPersonPublicId().trim());
        if (!personApi.getId().equals(entity.getPersonApiId())
                && clientApiRepository.existsByPersonApi_IdAndDeleteDateTsIsNullAndIdNot(personApi.getId(), entity.getId())) {
            throw new BadRequestException("a client already exists for this personPublicId");
        }
        entity.setPersonApi(personApi);
        return true;
    }

    private boolean applyCompanyNameUpdate(ClientApiEntity entity, ClientApiUpdateRequest request) {
        if (!hasText(request.getCompanyName())) {
            return false;
        }
        entity.setCompanyName(request.getCompanyName().trim());
        return true;
    }

    private boolean applyDescriptionUpdate(ClientApiEntity entity, ClientApiUpdateRequest request) {
        if (!hasText(request.getDescription())) {
            return false;
        }
        entity.setDescription(request.getDescription().trim());
        return true;
    }

    private boolean applyEnabledUpdate(ClientApiEntity entity, ClientApiUpdateRequest request) {
        if (request.getEnabled() == null) {
            return false;
        }
        entity.setEnabled(request.getEnabled());
        return true;
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
        } catch (IllegalArgumentException _) {
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
