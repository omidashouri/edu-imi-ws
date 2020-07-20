package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.projections.edu.FieldOnly;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FieldOnlyMapper {

    FieldOnlyMapper INSTANCE = Mappers.getMapper(FieldOnlyMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "eduCategoryId", target = "eduCategoryId"),
            @Mapping(source = "levelId", target = "levelId"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "editDate", target = "editDate")
    })
    FieldEntity toFieldEntity(FieldOnly fieldOnly, @Context CycleAvoidingMappingContext context);

    List<FieldEntity> toFieldEntities(List<FieldOnly> fieldOnlies, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleEduCategoryLevelEntity(FieldOnly fieldOnly, @MappingTarget FieldEntity fieldEntity) {

        if (fieldOnly.getEduCategoryId() != null) {
            EduCategoryEntity eduCategory = new EduCategoryEntity();
            eduCategory.setId(fieldOnly.getEduCategoryId());
            fieldEntity.setEduCategory(eduCategory);
        }

        if (fieldOnly.getLevelId() != null) {
            LevelEntity level = new LevelEntity();
            level.setId(fieldOnly.getLevelId());
            fieldEntity.setLevel(level);
        }
    }
}
