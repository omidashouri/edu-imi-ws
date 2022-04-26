package edu.imi.ir.eduimiws.services.hamkaran;


import edu.imi.ir.eduimiws.mapper.hamkaran.HamkaranAuthenticationTokenResponseMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.hamkaran.HamkaranDeletedFinancialResponseMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.hamkaran.HamkaranFinancialResponseMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.hamkaran.HamkaranHumanResourceResponseMapper;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranAuthenticationTokenDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranDeletedFinancialResponseDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranFinancialResponseDto;
import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranHumanResourceResponseDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranAuthenticationTokenResponse;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranDeletedFinancialResponse;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranFinancialResponse;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranHumanResourceResponse;
import edu.imi.ir.eduimiws.security.HamkaranCredential;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class HamkaranServiceImpl implements HamkaranService {

    private final HamkaranAuthenticationTokenResponseMapper hamkaranAuthenticationTokenResponseMapper;
    private final HamkaranFinancialResponseMapper hamkaranFinancialResponseMapper;
    private final HamkaranHumanResourceResponseMapper hamkaranHumanResourceResponseMapper;
    private final HamkaranDeletedFinancialResponseMapper hamkaranDeletedFinancialResponseMapper;
    private final HamkaranCredential hamkaranCredential;
    private final RestTemplate restTemplate;

    @Override
    public HamkaranAuthenticationTokenDto getToken(HamkaranAuthenticationTokenDto hamkaranAuthenticationTokenDto) {

        String completeGetTokenUri = String.format(hamkaranCredential.getApiUriGetToken(),
                hamkaranAuthenticationTokenDto.getCode());

        ResponseEntity<HamkaranAuthenticationTokenResponse> hamkaranAuthenticationTokenResponseResponseEntity =
                restTemplate.exchange(this.uriComponentsBuilderToString(completeGetTokenUri),
                        HttpMethod.GET, this.requestHttpEntity(false, hamkaranCredential),
                        HamkaranAuthenticationTokenResponse.class);

        HamkaranAuthenticationTokenResponse hamkaranAuthenticationTokenResponse =
                hamkaranAuthenticationTokenResponseResponseEntity.getBody();

        hamkaranAuthenticationTokenResponseMapper
                .updateHamkaranAuthenticationTokenDtoByHamkaranAuthenticationTokenResponse(hamkaranAuthenticationTokenDto, hamkaranAuthenticationTokenResponse);

        return hamkaranAuthenticationTokenDto;
    }

    @Override
    public HamkaranFinancialResponseDto searchHamkaranFinancialResponseBySearchQuery(HamkaranFinancialResponseDto hamkaranFinancialResponseDto) {

        HamkaranFinancialResponse hamkaranFinancialResponse;

        String searchQuery = hamkaranFinancialResponseDto.getSearchQuery();
        String completeFinancialUri = String.format(hamkaranCredential.getApiUriGetFinancial(), searchQuery);

        ResponseEntity<HamkaranFinancialResponse> hamkaranFinancialResponseEntity =
                restTemplate.exchange(this.uriComponentsBuilderToString(completeFinancialUri),
                        HttpMethod.GET, this.requestHttpEntity(true, hamkaranCredential),
                        HamkaranFinancialResponse.class);

        hamkaranFinancialResponse = hamkaranFinancialResponseEntity.getBody();
//todo: later handle it
        if (hamkaranFinancialResponse == null) {

        }

        hamkaranFinancialResponseDto = hamkaranFinancialResponseMapper
                .hamkaranFinancialResponseToHamkaranFinancialResponseDto(hamkaranFinancialResponse);

        hamkaranFinancialResponseDto.setSearchQuery(searchQuery);

        return hamkaranFinancialResponseDto;
    }

    @Override
    public HamkaranHumanResourceResponseDto searchHamkaranHumanResourceResponseBySearchQuery(HamkaranHumanResourceResponseDto hamkaranHumanResourceResponseDto) {

        HamkaranHumanResourceResponse hamkaranHumanResourceResponse;
        String searchQuery = hamkaranHumanResourceResponseDto.getSearchQuery();
        String completeHumanResourceUri = String.format(hamkaranCredential.getApiUriGetHumanResource(), searchQuery);

        ResponseEntity<HamkaranHumanResourceResponse> hamkaranFinancialResponseEntity =
                restTemplate.exchange(this.uriComponentsBuilderToString(completeHumanResourceUri),
                        HttpMethod.GET, this.requestHttpEntity(true, hamkaranCredential),
                        HamkaranHumanResourceResponse.class);

        hamkaranHumanResourceResponse = hamkaranFinancialResponseEntity.getBody();
        //todo: later handle it
        if (hamkaranHumanResourceResponse == null) {

        }

        hamkaranHumanResourceResponseDto = hamkaranHumanResourceResponseMapper
                .toHamkaranHumanResourceResponseDto(hamkaranHumanResourceResponse);

        hamkaranHumanResourceResponseDto.setSearchQuery(searchQuery);

        return hamkaranHumanResourceResponseDto;
    }

    @Override
    public HamkaranDeletedFinancialResponseDto searchHamkaranDeletedFinancialResponseBySearchQuery(HamkaranDeletedFinancialResponseDto hamkaranDeletedFinancialResponseDto) {

        HamkaranDeletedFinancialResponse hamkaranDeletedFinancialResponse;

        String searchQuery = hamkaranDeletedFinancialResponseDto.getSearchQuery();
        String completeDeletedFinancialUri = String.format(hamkaranCredential.getApiUriGetDeletedFinancial(), searchQuery);

        ResponseEntity<HamkaranDeletedFinancialResponse> hamkaranDeletedFinancialResponseEntity =
                restTemplate.exchange(this.uriComponentsBuilderToString(completeDeletedFinancialUri),
                        HttpMethod.GET, this.requestHttpEntity(true, hamkaranCredential),
                        HamkaranDeletedFinancialResponse.class);

        hamkaranDeletedFinancialResponse = hamkaranDeletedFinancialResponseEntity.getBody();
//todo: later handle it
        if (hamkaranDeletedFinancialResponse == null) {

        }

        hamkaranDeletedFinancialResponseDto = hamkaranDeletedFinancialResponseMapper
                .hamkaranDeletedFinancialResponseToHamkaranDeletedFinancialResponseDto(hamkaranDeletedFinancialResponse);

        hamkaranDeletedFinancialResponseDto.setSearchQuery(searchQuery);

        return hamkaranDeletedFinancialResponseDto;
    }

/*    @Override
    public void getFinancial() {
        HamkaranFinancialResponse hamkaranFinancialResponse = new HamkaranFinancialResponse();

        String completeFinancialUri = hamkaranCredential.getApiUriGetFinancial();

        ResponseEntity<HamkaranFinancialResponse> hamkaranAuthenticationTokenResponseResponseEntity =
                restTemplate.exchange(this.uriComponentsBuilderToString(completeFinancialUri),
                        HttpMethod.GET, this.requestHttpEntity(true, hamkaranCredential),
                        HamkaranFinancialResponse.class);

        hamkaranFinancialResponse = hamkaranAuthenticationTokenResponseResponseEntity.getBody();
    }*/

    protected String uriComponentsBuilderToString(String stringUri) {
        return UriComponentsBuilder.fromUriString(stringUri).toUriString();
    }

    protected HttpEntity<?> requestHttpEntity(boolean needToken, HamkaranCredential hamkaranCredential) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        if (needToken)
            headers.set("api-key", hamkaranCredential.getToken());

        HttpEntity<?> requestHttpEntity = new HttpEntity<>(null, headers);
        return requestHttpEntity;
    }
}
