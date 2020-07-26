package edu.imi.ir.eduimiws.mapper.edu;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduCategoryDtoMapper {

    EduCategoryDtoMapper INSTANCE = Mappers.getMapper(EduCategoryDtoMapper.class);

    @Mappings({
//          @Mapping(source = "eduCategoryApi.eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "companyId", target = "companyId"),
            @Mapping(source = "title", target = "title")
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

    @AfterMapping
    default void handleEntityEduCategoryPublicId(EduCategoryDto eduCategoryDto,
                                           @MappingTarget EduCategoryEntity eduCategoryEntity) {

        if (!Hibernate.isInitialized(eduCategoryEntity.getEduCategoryApi())) {
            eduCategoryEntity.setEduCategoryApi(null);
        }

        if(eduCategoryDto.getEduCategoryPublicId()!=null){
            if (eduCategoryEntity.getEduCategoryApi()!=null) {
                eduCategoryEntity.getEduCategoryApi().setEduCategoryPublicId(eduCategoryDto.getEduCategoryPublicId());
            }
        }
    }

    @AfterMapping
    default void handleDtoEduCategoryPublicId(EduCategoryEntity eduCategoryEntity,
                                        @MappingTarget EduCategoryDto eduCategoryDto) {

        if (!Hibernate.isInitialized(eduCategoryEntity.getEduCategoryApi())) {
            eduCategoryEntity.setEduCategoryApi(null);
        }

        if(eduCategoryEntity.getEduCategoryApi()!=null){
            if(eduCategoryEntity.getEduCategoryApi().getEduCategoryPublicId()!=null){
                eduCategoryDto.setEduCategoryPublicId(eduCategoryEntity.getEduCategoryApi().getEduCategoryPublicId());
            }
        }
    }
}
