package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * For Generating EduCategory Api Public Id
 */
@Mapper
public interface EduCategoryApiEduCategoryEntityHandlePublicIdMapper {

    EduCategoryApiEduCategoryEntityHandlePublicIdMapper INSTANCE = Mappers.getMapper(EduCategoryApiEduCategoryEntityHandlePublicIdMapper.class);

//

    @Mappings({
            @Mapping(source = "id", target = "eduCategoryId")
    })
    @BeanMapping(ignoreByDefault = true)
    EduCategoryApiEntity toEduCategoryApi(EduCategoryEntity eduCategory, @Context CycleAvoidingMappingContext context);

    List<EduCategoryApiEntity> toEduCategoryApis(List<EduCategoryEntity> eduCategories, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePublicIds(EduCategoryEntity eduCategory, @MappingTarget EduCategoryApiEntity eduCategoryApi) {

        eduCategoryApi.setEduCategory(eduCategory);

        eduCategoryApi.setCreateDateTs(new Timestamp(new Date().getTime()));

        eduCategoryApi.setEduCategoryPublicId(new PublicIdUtil().generateUniquePublicId());
    }
}
