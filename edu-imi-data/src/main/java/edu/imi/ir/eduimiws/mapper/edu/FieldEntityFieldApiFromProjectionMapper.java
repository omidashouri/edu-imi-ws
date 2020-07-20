package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldApiEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * For Generating Field Api Public Id
 */
@Mapper
public interface FieldEntityFieldApiFromProjectionMapper {

    FieldEntityFieldApiFromProjectionMapper INSTANCE = Mappers.
            getMapper(FieldEntityFieldApiFromProjectionMapper.class);

//

    @Mappings({
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "levelId", target = "levelId"),
            @Mapping(source = "eduCategory", target = "eduCategory"),
            @Mapping(source = "eduCategoryId", target = "eduCategoryId"),
            @Mapping(source = "editDate", target = "fieldEditDate"),
            @Mapping(source = "id", target = "fieldId"),
            @Mapping(source = "activityStatus", target = "fieldActivityStatus")
    })
    @BeanMapping(ignoreByDefault = true)
    FieldApiEntity toFieldApi(FieldEntity field, @Context CycleAvoidingMappingContext context);

    List<FieldApiEntity> toFieldApis(List<FieldEntity> fields, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePublicIds(FieldEntity field, @MappingTarget FieldApiEntity fieldApi) {

        fieldApi.setField(field);

        fieldApi.setCreateDateTs(new Timestamp(new Date().getTime()));

        fieldApi.setFieldPublicId(new PublicIdUtil().generateUniquePublicId());

        if (null != field.getActivityStatus()) {
            fieldApi.setFieldActivityStatus(field.getActivityStatus());
        }

        if (field.getLevel() != null) {
            if (!Hibernate.isInitialized(field.getLevel().getLevelApi())) {
                field.getLevel().setLevelApi(null);
            }
            if (field.getLevel().getLevelApi() != null) {
                fieldApi.setLevelPublicId(
                        field.getLevel().getLevelApi().getLevelPublicId());
            }
        }

        if (field.getLevel() == null && field.getLevelId() != null) {
            LevelEntity level = new LevelEntity();
            level.setId(field.getLevelId());
            fieldApi.setLevel(level);
        }

        if (field.getEduCategory() != null) {
            if (!Hibernate.isInitialized(field.getEduCategory().getEduCategoryApi())) {
                field.getEduCategory().setEduCategoryApi(null);
            }
            if (field.getEduCategory().getEduCategoryApi() != null) {
                fieldApi
                        .setEduCategoryPublicId(field.getEduCategory().getEduCategoryApi().getEduCategoryPublicId());
            }
        }

        if (field.getEduCategory() == null && field.getEduCategoryId() != null) {
            EduCategoryEntity eduCategory = new EduCategoryEntity();
            eduCategory.setId(field.getEduCategoryId());
            fieldApi.setEduCategory(eduCategory);
        }

    }

}
