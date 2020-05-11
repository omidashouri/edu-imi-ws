package edu.imi.ir.eduimiws.mapper.edu;


import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RegisterFastDtoMapper {

    RegisterFastDtoMapper INSTANCE = Mappers.getMapper(RegisterFastDtoMapper.class);

//    accountPublicId, creatorPublicId, editorPublicId, financialPersonPublicId

    @Mappings({
            @Mapping(source = "registerApi.registerPublicId", target = "registerPublicId"),
            @Mapping(source = "registerApi.studentPublicId", target = "studentPublicId"),
            @Mapping(source = "registerApi.periodPublicId", target = "periodPublicId"),
            @Mapping(source = "registerDate", target = "registerDate"),
            @Mapping(source = "registerFrom", target = "registerFrom"),
            @Mapping(source = "registerType", target = "registerType"),
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
            @Mapping(source = "fromRegister.registerApi.registerPublicId", target = "fromRegisterPublicId"),
            @Mapping(source = "hasSanad", target = "hasSanad"),
            @Mapping(source = "paidFee", target = "paidFee"),
            @Mapping(source = "periodContractId", target = "periodContractId")

    })
    @BeanMapping(ignoreByDefault = true)
    RegisterFastDto toRegisterFastDto(RegisterEntity registerEntity, @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    RegisterEntity toRegisterEntity(RegisterFastDto registerFastDto, @Context CycleAvoidingMappingContext context);

    List<RegisterEntity> toRegisterEntities(List<RegisterFastDto> registerFastDtos, @Context CycleAvoidingMappingContext context);

    List<RegisterFastDto> toRegisterFastDtos(List<RegisterEntity> registerEntities, @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handleRegisterResponsePersonFullName(RegisterEntity registerEntity, @MappingTarget RegisterFastDto registerFastDto) {

        if(!Hibernate.isInitialized(registerEntity.getPerson())) {
            registerEntity.setPerson(null);
        }

        if(registerEntity.getPerson()!=null) {
            registerFastDto
                    .setPersonFullName(
                            registerEntity.getPerson().getFirstName()
                                    + ' ' +
                                    registerEntity.getPerson().getLastName());
        }
    }*/
}
