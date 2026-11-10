package edu.imi.ir.eduimiws.services.crm.v2;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.models.dto.crm.v2.ClientApiDto;
import edu.imi.ir.eduimiws.models.request.crm.v2.ClientApiCreateRequest;
import edu.imi.ir.eduimiws.models.request.crm.v2.ClientApiUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientApiService {

    ClientApiDto create(ClientApiCreateRequest request);

    Page<ClientApiDto> findAllActive(Pageable pageable);

    ClientApiDto findByClientPublicId(String clientPublicId);

    ClientApiDto update(String clientPublicId, ClientApiUpdateRequest request);

    ClientApiDto softDelete(String clientPublicId);

    /**
     * Validates Base64(clientId:clientSecret), client enabled, and linked person activityStatus == "1".
     * @return authenticated PersonApi for token issuance
     */
    PersonApiEntity authenticateByCredentialsBase64(String credentialsBase64);
}
