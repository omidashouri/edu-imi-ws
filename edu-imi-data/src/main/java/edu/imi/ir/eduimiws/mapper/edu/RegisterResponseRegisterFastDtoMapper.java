package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import edu.imi.ir.eduimiws.models.response.edu.RegisterResponse;
import edu.imi.ir.eduimiws.services.crm.ContactPublicIdzService;
import edu.imi.ir.eduimiws.utilities.DateConvertor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {DateConvertor.class},
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RegisterResponseRegisterFastDtoMapper {

    RegisterResponseRegisterFastDtoMapper INSTANCE = Mappers.getMapper(RegisterResponseRegisterFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "registerPublicId", target = "registerPublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "studentPublicId", target = "studentPublicId"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "attachDate", target = "attachDate"),
            @Mapping(source = "cardNo", target = "cardNo"),
            @Mapping(source = "contractId", target = "contractId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editorPublicId", target = "editorPublicId"),
            @Mapping(source = "educationType", target = "educationType"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "fileNewName", target = "fileNewName"),
            @Mapping(source = "fileOldName", target = "fileOldName"),
            @Mapping(source = "finalScore", target = "finalScore"),
            @Mapping(source = "finalStatus", target = "finalStatus"),
            @Mapping(source = "financialDesc", target = "financialDesc"),
            @Mapping(source = "financialPersonPublicId", target = "financialPersonPublicId"),
            @Mapping(source = "financialStatus", target = "financialStatus"),
            @Mapping(source = "financialStatusDate", target = "financialStatusDate"),
            @Mapping(source = "fromRegisterPublicId", target = "fromRegisterPublicId"),
            @Mapping(source = "hasSanad", target = "hasSanad"),
            @Mapping(source = "paidFee", target = "paidFee"),
            @Mapping(source = "periodContractId", target = "periodContractId"),
            @Mapping(source = "registerDate", target = "registerDate"),
            @Mapping(source = "registerFrom", target = "registerFrom"),
            @Mapping(source = "registerType", target = "registerType"),
            @Mapping(source = "statusDate", target = "statusDate"),
            @Mapping(source = "tempDate", target = "tempDate"),
            @Mapping(source = "tempScore", target = "tempScore"),
            @Mapping(source = "tempTime", target = "tempTime"),
            @Mapping(source = "termFee", target = "termFee"),
            @Mapping(source = "totalPaid", target = "totalPaid"),
            @Mapping(target = "registerDateGregorian",
                    expression = "java(new DateConvertor().convertKhToGeorgianDate(registerFastDto.getRegisterDate()))")


    })
    @BeanMapping(ignoreByDefault = true)
    RegisterResponse toRegisterResponse(RegisterFastDto registerFastDto , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    RegisterFastDto toRegisterFastDto(RegisterResponse registerResponse, @Context CycleAvoidingMappingContext context);

    List<RegisterResponse> toRegisterResponses(List<RegisterFastDto> registerFastDtos, @Context CycleAvoidingMappingContext context);

    List<RegisterFastDto> toRegisterFastDtos(List<RegisterResponse> registerResponses, @Context CycleAvoidingMappingContext context);

}
