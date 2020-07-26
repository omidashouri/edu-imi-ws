package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * For Generating Level Api Public Id
 */
@Mapper
public interface LevelApiLevelEntityHandlePublicIdMapper {

    LevelApiLevelEntityHandlePublicIdMapper INSTANCE = Mappers.
            getMapper(LevelApiLevelEntityHandlePublicIdMapper.class);

//

    @Mappings({
            @Mapping(source = "id", target = "levelId"),
            @Mapping(source = "editDate", target = "levelEditDate")
    })
    @BeanMapping(ignoreByDefault = true)
    LevelApiEntity toLevelApi(LevelEntity level, @Context CycleAvoidingMappingContext context);

    List<LevelApiEntity> toLevelApis(List<LevelEntity> levelEntities, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handlePublicIds(LevelEntity level, @MappingTarget LevelApiEntity levelApi) {

        levelApi.setLevel(level);
        levelApi.setCreateDateTs(new Timestamp(new Date().getTime()));
        levelApi.setLevelPublicId(new PublicIdUtil().generateUniquePublicId());
    }
}
