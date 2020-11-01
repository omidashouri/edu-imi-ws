package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import edu.imi.ir.eduimiws.models.request.edu.v1.RegisterForm;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RegisterFormRegisterFastDtoMapper {

    RegisterFormRegisterFastDtoMapper INSTANCE = Mappers.getMapper(RegisterFormRegisterFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "studentPublicId", target = "studentPublicId"),
            @Mapping(source = "periodPublicId", target = "periodPublicId"),
            @Mapping(source = "registerType", target = "registerType"),
            @Mapping(source = "accountPublicId", target = "accountPublicId")
/*            @Mapping(source = "registerDate", target = "registerDate"),
            @Mapping(source = "statusDate", target = "statusDate"),
            @Mapping(source = "tempDate", target = "tempDate"),
            @Mapping(source = "tempScore", target = "tempScore"),
            @Mapping(source = "tempTime", target = "tempTime"),
            @Mapping(source = "termFee", target = "termFee"),
            @Mapping(source = "totalPaid", target = "totalPaid"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "attachDate", target = "attachDate"),
            @Mapping(source = "cardNo", target = "cardNo"),
            @Mapping(source = "contractId", target = "contractId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "deleteStatus", target = "deleteStatus"),
            @Mapping(source = "discount", target = "discount"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "educationType", target = "educationType"),
            @Mapping(source = "fee", target = "fee"),
            @Mapping(source = "fileNewName", target = "fileNewName"),
            @Mapping(source = "fileOldName", target = "fileOldName"),
            @Mapping(source = "finalScore", target = "finalScore"),
            @Mapping(source = "finalStatus", target = "finalStatus"),
            @Mapping(source = "financialDesc", target = "financialDesc"),
            @Mapping(source = "financialStatus", target = "financialStatus"),
            @Mapping(source = "financialStatusDate", target = "financialStatusDate"),
            @Mapping(source = "hasSanad", target = "hasSanad"),
            @Mapping(source = "paidFee", target = "paidFee"),
            @Mapping(source = "periodContractId", target = "periodContractId")*/

    })
    @BeanMapping(ignoreByDefault = true)
    RegisterFastDto toRegisterFastDto(RegisterForm registerForm, @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    RegisterForm toRegisterForm(RegisterFastDto registerFastDto, @Context CycleAvoidingMappingContext context);

    List<RegisterForm> toRegisterForms(List<RegisterFastDto> registerFastDtos, @Context CycleAvoidingMappingContext context);

    List<RegisterFastDto> toRegisterFastDtos(List<RegisterForm> registerForms, @Context CycleAvoidingMappingContext context);


    @AfterMapping
    default void handleRegisterType(RegisterForm registerForm, @MappingTarget RegisterFastDto registerFastDto) {
        if (registerForm != null && registerForm.getRegisterType() != null) {
            switch (registerForm.getRegisterType()) {
                case "0":
                    registerFastDto.setRegisterType("0");
                    break;
                case "2":
                    registerFastDto.setRegisterType("2");
                    break;
                default:
                    registerFastDto.setRegisterType(null);
            }
        } else {
            registerFastDto.setRegisterType(null);
        }
    }
}
