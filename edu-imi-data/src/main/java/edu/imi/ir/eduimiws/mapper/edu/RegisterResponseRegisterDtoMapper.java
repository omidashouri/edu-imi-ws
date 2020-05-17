package edu.imi.ir.eduimiws.mapper.edu;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterDto;
import edu.imi.ir.eduimiws.models.response.edu.RegisterResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegisterResponseRegisterDtoMapper {

    RegisterResponseRegisterDtoMapper INSTANCE = Mappers.getMapper(RegisterResponseRegisterDtoMapper.class);

    @Mappings({
            @Mapping(source = "registerPublicId", target = "registerPublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "studentPublicId", target = "studentPublicId"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "periodName", target = "periodName"),
            @Mapping(source = "studentFirstName", target = "studentFirstName"),
            @Mapping(source = "studentLastName", target = "studentLastName"),
            @Mapping(source = "studentFullName", target = "studentFullName"),
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
            @Mapping(source = "totalPaid", target = "totalPaid")


    })
    @BeanMapping(ignoreByDefault = true)
    RegisterResponse toRegisterResponse(RegisterDto registerDto , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    RegisterDto toRegisterDto(RegisterResponse registerResponse, @Context CycleAvoidingMappingContext context);

    List<RegisterResponse> toRegisterResponses(List<RegisterDto> registerDtos, @Context CycleAvoidingMappingContext context);

    List<RegisterDto> toRegisterDtos(List<RegisterResponse> registerResponses, @Context CycleAvoidingMappingContext context);

}
