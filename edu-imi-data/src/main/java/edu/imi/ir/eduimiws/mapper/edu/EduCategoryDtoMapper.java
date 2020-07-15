package edu.imi.ir.eduimiws.mapper.edu;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduCategoryDtoMapper {

    EduCategoryDtoMapper INSTANCE = Mappers.getMapper(EduCategoryDtoMapper.class);

    @Mappings({
            @Mapping(source = "companyId", target = "companyId"),
            @Mapping(source = "eduCategoryApi.eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "parent.eduCategoryApi.eduCategoryPublicId", target = "eduCategoryParentPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    EduCategoryDto toEduCategoryDto(EduCategoryEntity eduCategoryEntity
            ,@Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    EduCategoryEntity toEduCategoryEntity(EduCategoryDto eduCategoryDto
            , @Context CycleAvoidingMappingContext context);

    List<EduCategoryEntity> toEduCategoryEntities(List<EduCategoryDto> eduCategoryDtos,
                                            @Context CycleAvoidingMappingContext context);

    List<EduCategoryDto> toEduCategoryDtos(List<EduCategoryEntity> eduCategoryEntities,
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
