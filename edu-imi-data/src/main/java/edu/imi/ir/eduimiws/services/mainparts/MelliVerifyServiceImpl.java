package edu.imi.ir.eduimiws.services.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.MelliVerifyEntity;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.MelliVerifyMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.VerifyRequestBankMapper;
import edu.imi.ir.eduimiws.mapper.mainparts.melli.VerifyResultDataBankMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
import edu.imi.ir.eduimiws.models.request.melli.v1.VerifyRequestBank;
import edu.imi.ir.eduimiws.models.response.melli.v1.VerifyResultDataBank;
import edu.imi.ir.eduimiws.repositories.mainparts.MelliVerifyRepository;
import edu.imi.ir.eduimiws.security.MelliCredential;
import edu.imi.ir.eduimiws.utilities.MelliTripleDes;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MelliVerifyServiceImpl implements MelliVerifyService{

    private final VerifyRequestBankMapper verifyRequestBankMapper;
    private final VerifyResultDataBankMapper verifyResultDataBankMapper;
    private final MelliVerifyMapper melliVerifyMapper;
    private final MelliVerifyRepository melliVerifyRepository;
    private final MelliCredential melliCredential;
    private final MelliTripleDes melliTripleDes;
    private final RestTemplate restTemplate;
    private final PublicIdUtil publicIdUtil;
    private final SecurityUtil securityUtil;

    @Override
    public MelliVerifyDto verify(MelliVerifyDto melliVerifyDto) {

        VerifyRequestBank verifyRequestBank = verifyRequestBankMapper
                .melliVerifyDtoToVerifyRequestBank(melliVerifyDto, melliTripleDes);

        VerifyResultDataBank verifyResultDataBank = restTemplate
                .postForObject(this.uriComponentsBuilderToString(melliCredential.getIpgUriVerifyTransaction()),
                        this.verifyRequestHttpEntity(verifyRequestBank, melliCredential),
                        VerifyResultDataBank.class);

        verifyResultDataBankMapper
                .updateMelliVerifyDtoByVerifyResultDataBank(melliVerifyDto, verifyResultDataBank);

        MelliVerifyEntity melliVerify = melliVerifyMapper
                .toMelliVerifyEntity(melliVerifyDto,publicIdUtil, securityUtil);

        MelliVerifyEntity melliVerifySaved = melliVerifyRepository.save(melliVerify);

        melliVerifyMapper.updateMelliVerifyDtoByMelliVerifyEntityAfterSave(melliVerifyDto, melliVerifySaved);

        return melliVerifyDto;
    }

    @Override
    public MelliVerifyDto findByMelliDigitalPaymentPublicId(String melliDigitalPaymentPublicId) {

        MelliVerifyEntity melliVerify = melliVerifyRepository
                .findByMelliDigitalPaymentPublicId(melliDigitalPaymentPublicId);

        MelliVerifyDto melliVerifyDto = melliVerifyMapper
                .toMelliVerifyDto(melliVerify);

        return melliVerifyDto;
    }

    protected String uriComponentsBuilderToString(String stringUri){
        return UriComponentsBuilder.fromUriString(stringUri).toUriString();
    }

    protected HttpEntity<VerifyRequestBank> verifyRequestHttpEntity(VerifyRequestBank verifyRequestBank, MelliCredential melliCredential){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Referer",melliCredential.getApiRefererUrl());

        HttpEntity<VerifyRequestBank> verifyRequestHttpEntity = new HttpEntity<>(verifyRequestBank, headers);
        return verifyRequestHttpEntity;
    }
}
