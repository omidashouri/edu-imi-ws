package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodResponseMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodWebServiceDtoPeriodResponseOldMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodWebServiceMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponseOld;
import edu.imi.ir.eduimiws.services.edu.PeriodService;
import edu.imi.ir.eduimiws.services.edu.PeriodWebServiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/periods")
@RequiredArgsConstructor
@Tag(name = "Periods", description = "The period API")
public class PeriodController {

    private final PeriodWebServiceService periodWebServiceService;
    private final PeriodService periodService;
    private final PeriodWebServiceMapper periodWebServiceMapper;
    private final PeriodFastDtoMapper periodFastDtoMapper;
    private final PeriodResponseMapper periodResponseMapper;
    private final PeriodWebServiceDtoPeriodResponseOldMapper periodWebServiceDtoPeriodResponseOldMapper;


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Page<PeriodResponse> getPeriods(@RequestParam(value = "page", defaultValue = "1") int pageValue
            , @RequestParam(value = "limit", defaultValue = "25") int limitValue
            , @RequestParam(value = "sort", defaultValue = "createDate") String sortValue
            , @RequestParam(value = "dir", defaultValue = "DESC") String directionValue ){

//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Pageable periodPageable = PageRequest.of(pageValue,limitValue, Sort.Direction.fromString(directionValue),sortValue);

        Page<PeriodEntity> periodPages =
                periodService.findAllPeriodEntityPagesOrderByCreateDateDesc(periodPageable);

        List<PeriodEntity> periodEntities = StreamSupport
                .stream(periodPages.spliterator(),false)
                .collect(Collectors.toList());

        Page<PeriodResponse> periodResponsesPages = PageableExecutionUtils
                .getPage(periodResponseMapper
                                .PeriodEntitiesToPeriodResponses(periodEntities,
                                        new CycleAvoidingMappingContext()),
                        periodPageable,
                        periodPages::getTotalElements);

        return periodResponsesPages;
    }

    @GetMapping(path = "/oldPeriods",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Page<PeriodResponseOld> getOldPeriods(@RequestParam(value = "page", defaultValue = "1") int pageValue
            , @RequestParam(value = "limit", defaultValue = "25") int limitValue) {

//        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Pageable paperiodPageable = PageRequest.of(pageValue,limitValue);

         Page<PeriodWebServiceFastDto> periodWebServiceFastDtoPages =
                periodWebServiceService.findAllPeriodWebServiceFastDtoPageable(paperiodPageable);

         List<Long> periodWebServiceIds = StreamSupport
                 .stream(periodWebServiceFastDtoPages.spliterator(),false)
                 .map(PeriodWebServiceFastDto::getId).collect(Collectors.toList());

         List<PeriodWebServiceDto> periodWebServiceDtos = periodWebServiceService
                 .findAllPeriodWebServiceDtoById(periodWebServiceIds);

        Page<PeriodResponseOld> periodResponsesPages = PageableExecutionUtils
                .getPage(periodWebServiceDtoPeriodResponseOldMapper
                        .PeriodWebServiceDtosToPeriodResponses(periodWebServiceDtos,
                                new CycleAvoidingMappingContext()),
                        paperiodPageable,
                        periodWebServiceFastDtoPages::getTotalElements);

        return periodResponsesPages;
    }

    @Operation(
            summary = "Find new period numbers",
            description = "search for new periods that do not have period public id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )
    @GetMapping(path = "/count-new-periods",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getNewPeriodCount() {

        OperationStatus returnValue = new OperationStatus();
        Long periodWebserviceCount;
        Long periodCount;
        Long newPeriodCount;

        periodWebserviceCount = periodWebServiceService.periodWebServiceCount();
        periodCount = periodService.PeriodCount();

        if (periodCount == null || periodCount == 0) {
            conflictPeriodCount();
        }

        if (periodWebserviceCount != null) {
            newPeriodCount = periodCount - periodWebserviceCount;
        } else {
            newPeriodCount = periodCount;
        }

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.COUNT_NEW_RECORDS.name());

        if (newPeriodCount > 0) {
            returnValue.setDescription(newPeriodCount + " New Record Found. use 'generate-public-id' link");

            Link link = WebMvcLinkBuilder.linkTo(PeriodController.class)
                    .slash("PeriodWebService")
                    .slash("generate-public-id")
                    .withRel("generate-public-id");

            returnValue.add(link);
        } else {

            returnValue.setDescription("New Record Not Found.");
        }
        return ResponseEntity.ok(returnValue);
    }


    @Operation(
            summary = "Generate Period Public Id",
            description = "generate public id for new periods"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "successful operation",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = OperationStatus.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Internal Server Error",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
                    ,
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorMessage.class)
                            )
                    )
            }
    )
    @PostMapping(path = "/PeriodWebService/generate-public-id",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createPeriodWebServicePublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long periodWebserviceCount;
        PeriodWebServiceEntity periodWebServiceLastRecord;
        PeriodEntity periodLastRecord;
        List<PeriodEntity> newPeriods = new ArrayList<>();
        List<PeriodWebServiceEntity> newPeriodWebService = new ArrayList<>();

        periodWebserviceCount = periodWebServiceService.periodWebServiceCount();

        if (0 != periodWebserviceCount) {
            periodWebServiceLastRecord = periodWebServiceService.selectLastRecord();
            periodLastRecord = periodService.selectLastRecord();
            if (periodLastRecord.getId() > periodWebServiceLastRecord.getPeriodId()) {
                newPeriods = periodService.findAllPeriodOnlyByIdGreaterThan(periodWebServiceLastRecord.getPeriodId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_RECORDS.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newPeriods = periodService.findAllPeriodOnly();
        }

        newPeriodWebService = periodWebServiceService.generatePeriodWebServicePublicId(newPeriods);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_RECORDS.name());
        returnValue.setDescription(newPeriodWebService.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }

//not working
    @GetMapping(path = "/newPeriods", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<PeriodResponseOld> getNewPeriods(@RequestParam(value = "page", defaultValue = "1") int pageValue
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

//not working
    @GetMapping(path = "/periodServices", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
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

    private ResponseEntity<?> conflictPeriodCount() {
        return new ResponseEntity<>(
                new ErrorMessage(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , "period count is null or zero")
                , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
