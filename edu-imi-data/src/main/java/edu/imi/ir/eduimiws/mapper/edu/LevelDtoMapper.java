package edu.imi.ir.eduimiws.mapper.edu;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LevelDtoMapper {
    LevelDtoMapper INSTANCE = Mappers.getMapper(LevelDtoMapper.class);

    @Mappings({
//            @Mapping(source = "levelApi.levelPublicId", target = "levelPublicId"),
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

    @AfterMapping
    default void handleEntityLevelPublicId(LevelDto levelDto,
                                                 @MappingTarget LevelEntity levelEntity) {

        if (!Hibernate.isInitialized(levelEntity.getLevelApi())) {
            levelEntity.setLevelApi(null);
        }

        if(levelDto.getLevelPublicId()!=null){
            if (levelEntity.getLevelApi()!=null) {
                levelEntity.getLevelApi().setLevelPublicId(levelDto.getLevelPublicId());
            }
        }
    }

    @AfterMapping
    default void handleDtoLevelPublicId(LevelEntity levelEntity,
                                     @MappingTarget LevelDto levelDto) {

        if (!Hibernate.isInitialized(levelEntity.getLevelApi())) {
            levelEntity.setLevelApi(null);
        }

        if(levelEntity.getLevelApi()!=null){
            if(levelEntity.getLevelApi().getLevelPublicId()!=null){
                levelDto.setLevelPublicId(levelEntity.getLevelApi().getLevelPublicId());
            }
        }
    }
}
