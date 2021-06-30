package edu.imi.ir.eduimiws.mapper.sabtahval;


import edu.imi.ir.eduimiws.models.dto.sabtahval.PersonInfoDto;
import edu.imi.ir.eduimiws.models.request.sabtahval.EstelamPersonInfoRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {Long.class, Integer.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EstelamPersonInfoRequestMapper {

    @Named("toPersonInfoDto")
    @Mappings({
            @Mapping(source="birthDate", target = "birthDate", qualifiedByName = "stringToLong"),
            @Mapping(source = "gender", target = "gender", qualifiedByName = "stringToInteger"),
            @Mapping(source = "nin", target = "nin", qualifiedByName = "stringToLong")
    })
    @BeanMapping(ignoreByDefault = true)
    PersonInfoDto toPersonInfoDto(EstelamPersonInfoRequest source);

    @IterableMapping(qualifiedByName = "toPersonInfoDto")
    List<PersonInfoDto> toPersonInfoDtos(List<EstelamPersonInfoRequest> sources);

    @Named("stringToInteger")
    default Integer stringToInteger(String source) {
        return Integer.valueOf(source);
    }

    @Named("stringToLong")
    default Long stringToLong(String source) {
        return Long.valueOf(source);
    }
}
