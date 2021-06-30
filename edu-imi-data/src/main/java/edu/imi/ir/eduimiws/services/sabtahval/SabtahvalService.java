package edu.imi.ir.eduimiws.services.sabtahval;

import edu.imi.ir.eduimiws.models.dto.sabtahval.GetEstelam3ResponseDto;
import edu.imi.ir.eduimiws.models.dto.sabtahval.PersonInfoDto;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamResultResponse;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamVersionResponse;

public interface SabtahvalService {

    EstelamVersionResponse getVersion() throws Exception;

    GetEstelam3ResponseDto getEstelam3DtoFromPersonInfoDto(PersonInfoDto personInfoDto) throws Exception;

    EstelamResultResponse getEstelamResultResponse(PersonInfoDto personInfoDto) throws Exception;

}
