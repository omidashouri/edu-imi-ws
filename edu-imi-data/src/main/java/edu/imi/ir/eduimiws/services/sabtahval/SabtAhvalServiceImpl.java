package edu.imi.ir.eduimiws.services.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.sabtahval.*;
import edu.imi.ir.eduimiws.models.dto.sabtahval.*;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamResultResponse;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamVersionResponse;
import edu.imi.ir.eduimiws.models.sabtahval.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class SabtAhvalServiceImpl implements SabtahvalService{

//  read configuration from 'edu.imi.ir.eduimiws.configurations.CommonWebServiceClientConfig', Qualifier by Name
    private final WebServiceTemplate webServiceTemplateSabtAhval;
    private final SabtahvalCredential sabtahvalCredential;
    private final PersonInfoMapper personInfoMapper;
    private final GetEstelam3ResponseMapper getEstelam3ResponseMapper;
    private final GetVersionResponseMapper getVersionResponseMapper;
    private final EstelamVersionResponseMapper estelamVersionResponseMapper;
    private final EstelamResultResponseMapper estelamResultResponseMapper;

    @Override
    public EstelamVersionResponse getVersion() throws Exception {

        GetVersion getVersion = new GetVersion();
        EstelamVersionResponse estelamVersionResponse = new EstelamVersionResponse();
        GetVersionResponseDto getVersionResponseDto = new GetVersionResponseDto();

        Object response  = this.sabtAhvalMarshalSendAndReceive(getVersion);

        GetVersionResponse getVersionResponse = (GetVersionResponse) response;

         getVersionResponseDto = getVersionResponseMapper
                 .toGetVersionResponseDto(getVersionResponse,new CycleAvoidingMappingContext());

         estelamVersionResponse = estelamVersionResponseMapper
                 .toEstelamVersionResponse(getVersionResponseDto, new CycleAvoidingMappingContext());

        return estelamVersionResponse;
    }

    @Override
    public GetEstelam3ResponseDto getEstelam3DtoFromPersonInfoDto(PersonInfoDto personInfoDto) throws Exception {

        PersonInfo personInfo = personInfoMapper.toPersonInfo(personInfoDto, new CycleAvoidingMappingContext());

        GetEstelam3 getEstelam3 = sabtahvalCredential.getGetEstelam3();
        getEstelam3.setArg4(personInfo);

        Object response = this.sabtAhvalMarshalSendAndReceive(getEstelam3);

        GetEstelam3Response getEstelam3Response = (GetEstelam3Response) response;

        GetEstelam3ResponseDto getEstelam3ResponseDto =  getEstelam3ResponseMapper
                .toGetEstelam3ResponseDto(getEstelam3Response, new CycleAvoidingMappingContext());

        return getEstelam3ResponseDto;
    }

    @Override
    public EstelamResultResponse getEstelamResultResponse(PersonInfoDto personInfoDto) throws Exception {

        GetEstelam3ResponseDto getEstelam3ResponseDto = this.getEstelam3DtoFromPersonInfoDto(personInfoDto);

        EstelamResult3Dto estelamResult3Dto =  getEstelam3ResponseDto.getReturns().get(0);

        EstelamResultResponse estelamResultResponse =  estelamResultResponseMapper
                .toEstelamResultResponse(estelamResult3Dto, new CycleAvoidingMappingContext());

        return estelamResultResponse;
    }

    private Object sabtAhvalMarshalSendAndReceive(Object requestPayload){
        return webServiceTemplateSabtAhval.marshalSendAndReceive(requestPayload);
    }

}
