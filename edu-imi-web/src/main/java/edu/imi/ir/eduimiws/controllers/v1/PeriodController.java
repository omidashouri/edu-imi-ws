package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodWebServiceMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import edu.imi.ir.eduimiws.services.edu.PeriodService;
import edu.imi.ir.eduimiws.services.edu.PeriodWebServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/periods")
@RequiredArgsConstructor
public class PeriodController {

    private final PeriodWebServiceService periodWebServiceService;
    private final PeriodService periodService;
    private final PeriodWebServiceMapper periodWebServiceMapper;
    private final PeriodFastDtoMapper periodFastDtoMapper;


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PeriodResponse> getPeriods(@RequestParam(value = "page", defaultValue = "1") int pageValue
            , @RequestParam(value = "limit", defaultValue = "25") int limitValue) {

 /*        List<PeriodWebServiceEntity> periodWebServices =
                periodWebServiceService
                        .findAllListByPageAndSize(pageValue,limitValue);

       List<UserContactFastDto> userContactFastDtos =
                personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDtoes(users,new CycleAvoidingMappingContext());

        List<UserContactResponse> userContactResponses =
                userContactResponseUserContactFastDtoMapper
                        .UserContactFastDtoToUserContactResponses(userContactFastDtos,new CycleAvoidingMappingContext());

        return userContactResponses;*/
        return null;
    }


    @PostMapping(path = "/update-periodWebService",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public OperationStatus updatePeriodWebService() {

        OperationStatus returnValue = new OperationStatus();
        boolean operationResult = false;


        if (operationResult) {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        }

        return returnValue;
    }


    @GetMapping(path = "/newPeriods",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PeriodResponse> getNewPeriods(@RequestParam(value = "page", defaultValue = "1") int pageValue
            , @RequestParam(value = "limit", defaultValue = "25") int limitValue
            , @RequestParam(value = "rtype", defaultValue = "page") String returnTypeValue) {

        List<PeriodWebServiceEntity> periodWebServiceEntities = new ArrayList<>();
        List<PeriodWebServiceDto> periodWebServiceDtos = new ArrayList<>();
        List<PeriodFastDto> periodFastDtos = new ArrayList<>();

        periodWebServiceDtos = this.getPeriodWebServices(0, 0, "list");

        periodWebServiceEntities = periodWebServiceMapper
                .PeriodWebServiceDtosToPeriodWebServiceEntities(periodWebServiceDtos, new CycleAvoidingMappingContext());

//        omiddo: check if it want list or pageable
//        if(returnTypeValue=='list')
        List<PeriodEntity> newPeriods =
                periodService
                        .findNewPeriodNotInPeriodWebService(periodWebServiceEntities);

        periodFastDtos = periodFastDtoMapper
                .PeriodEntitiesToPeriodFastDtoes(newPeriods, new CycleAvoidingMappingContext());

 /*       List<UserContactFastDto> userContactFastDtos =
                personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDtoes(users,new CycleAvoidingMappingContext());

        List<UserContactResponse> userContactResponses =
                userContactResponseUserContactFastDtoMapper
                        .UserContactFastDtoToUserContactResponses(userContactFastDtos,new CycleAvoidingMappingContext());

        return userContactResponses;*/
        return null;
    }


    @GetMapping(path = "/periodServices",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PeriodWebServiceDto> getPeriodWebServices(@RequestParam(value = "page", defaultValue = "1") int pageValue
            , @RequestParam(value = "limit", defaultValue = "25") int limitValue
            , @RequestParam(value = "rtype", defaultValue = "page") String returnTypeValue) {

        List<PeriodWebServiceEntity> periodWebServiceEntities = new ArrayList<>();
        List<PeriodWebServiceDto> periodWebServiceDtos = new ArrayList<>();

//        omiddo: check if it want list or pageable
//        if(returnTypeValue=='list')
        periodWebServiceEntities =
                periodWebServiceService
                        .findAllEntities();

        periodWebServiceDtos =
                periodWebServiceMapper
                        .PeriodWebServiceEntitiesToPeriodWebServiceDtos(periodWebServiceEntities,
                                new CycleAvoidingMappingContext());

        return periodWebServiceDtos;
    }


}
