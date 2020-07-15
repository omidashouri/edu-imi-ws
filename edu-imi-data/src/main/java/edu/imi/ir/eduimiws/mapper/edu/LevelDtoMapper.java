package edu.imi.ir.eduimiws.mapper.edu;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LevelDtoMapper {
    LevelDtoMapper INSTANCE = Mappers.getMapper(LevelDtoMapper.class);

    @Mappings({
            @Mapping(source = "levelApi.levelPublicId", target = "levelPublicId"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "certTitle", target = "certTitle"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "paymentType", target = "paymentType"),
            @Mapping(source = "termicStatus", target = "termicStatus")
    })
    @BeanMapping(ignoreByDefault = true)
    LevelDto toLevelDto(LevelEntity levelEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    LevelEntity toLevelEntity(LevelDto levelDto
            , @Context CycleAvoidingMappingContext context);

    List<LevelEntity> toLevelEntities(List<LevelDto> levelDtos,
                                                  @Context CycleAvoidingMappingContext context);

    List<LevelDto> toLevelDtos(List<LevelEntity> levelEntities,
                                           @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handlePeriodNameStudentFullName(RegisterEntity registerEntity,
                                                 @MappingTarget RegisterDto registerDto) {


        if (!Hibernate.isInitialized(registerEntity.getRegisterApi().getStudent())) {
            registerEntity.setStudent(null);
            registerEntity.getRegisterApi().setStudent(null);
        }

        if (!Hibernate.isInitialized(registerEntity.getRegisterApi().getPeriod())) {
            registerEntity.setPeriod(null);
            registerEntity.getRegisterApi().setPeriod(null);
        }


        if (registerEntity.getRegisterApi().getStudent() != null) {
            registerDto.setStudentFirstName(registerEntity.getRegisterApi().getStudent().getFirstName());
            registerDto.setStudentLastName(registerEntity.getRegisterApi().getStudent().getLastName());
            registerDto
                    .setStudentFullName(
                            registerEntity.getRegisterApi().getStudent().getFirstName()
                                    + ' ' +
                                    registerEntity.getRegisterApi().getStudent().getLastName());
        }


        if (registerEntity.getRegisterApi().getPeriod() != null) {
            registerDto.setPeriodName(registerEntity.getRegisterApi().getPeriod().getName());
        }
    }*/
}
