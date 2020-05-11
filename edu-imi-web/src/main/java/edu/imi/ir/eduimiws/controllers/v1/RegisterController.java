package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.assemblers.edu.RegisterResponseAssembler;
import edu.imi.ir.eduimiws.domain.edu.RegisterApiEntity;
import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.mapper.edu.RegisterFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import edu.imi.ir.eduimiws.models.request.RequestOperationName;
import edu.imi.ir.eduimiws.models.request.RequestOperationStatus;
import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import edu.imi.ir.eduimiws.models.response.OperationStatus;
import edu.imi.ir.eduimiws.services.edu.RegisterApiService;
import edu.imi.ir.eduimiws.services.edu.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/registers")
@RequiredArgsConstructor
@Tag(name = "Registers", description = "The register API")
public class RegisterController {

    private final RegisterService registerService;
    private final RegisterApiService registerApiService;
    private final RegisterFastDtoMapper registerFastDtoMapper;
    private final RegisterResponseAssembler registerResponseAssembler;
    private final PagedResourcesAssembler<RegisterFastDto> registerFastDtoPagedResourcesAssembler;


    @Operation(
            summary = "Generate Register Public Id",
            description = "generate public id for new registers",
            tags = "registers",
            security = @SecurityRequirement(name = "imi-security-key")
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
    @PostMapping(path = "/new/publicId",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> createRegisterApiPublicId() {

        OperationStatus returnValue = new OperationStatus();
        Long registerApiCount;
        RegisterApiEntity registerApiLastRecord;
        RegisterEntity registerLastRecord;
        List<RegisterEntity> newRegisters = new ArrayList<>();
        List<RegisterApiEntity> newRegisterApi = new ArrayList<>();

        registerApiCount = registerApiService.registerApiCount();

        if (0 != registerApiCount) {
            Long registerSequenceNumber = registerService.selectRegisterLastSequenceNumber();
            registerApiLastRecord = registerApiService.selectLastRecord();
            registerLastRecord = registerService.findFirstByIdLessThanOrderByIdDesc(registerSequenceNumber);
            if (registerLastRecord.getId() > registerApiLastRecord.getRegisterId()) {
                newRegisters = registerService.findAllRegisterOnlyByIdBetween(registerApiLastRecord.getRegisterId(),registerLastRecord.getId());
            } else {
                returnValue.setOperationResult(RequestOperationStatus.INFORMATIONAL.name());
                returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
                returnValue.setDescription("New Record Not Found.");
                return ResponseEntity.ok(returnValue);
            }
        } else {
            newRegisters = registerService.selectAllRegisterOnly();
        }

        newRegisterApi = registerApiService.generateRegisterApiPublicId(newRegisters);

        returnValue.setOperationResult(RequestOperationStatus.SUCCESSFUL.name());
        returnValue.setOperationName(RequestOperationName.CREATE_NEW_ENTITIES.name());
        returnValue.setDescription(newRegisterApi.size() + " New Public Id Generated");
        return ResponseEntity.ok(returnValue);
    }
}
