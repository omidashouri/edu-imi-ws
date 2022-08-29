package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.BatchIdentifierRemoveInfo;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.BatchIdentifierRemoveInfoDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BatchIdentifierRemoveInfoMapper {

/*

    @Named("toBatchIdentifierRemoveInfoDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "identifierCodeList", target = "identifierCodeListDto")
    })
    @BeanMapping(ignoreByDefault = true)
    BatchIdentifierRemoveInfoDto toBatchIdentifierRemoveInfoDto(BatchIdentifierRemoveInfo source);


    @Named("toBatchIdentifierRemoveInfo")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "identifierCodeListDto", target = "identifierCodeList")

    })
    BatchIdentifierRemoveInfo toBatchIdentifierRemoveInfo(BatchIdentifierRemoveInfoDto source);

    @IterableMapping(qualifiedByName = "toBatchIdentifierRemoveInfo")
    List<BatchIdentifierRemoveInfo> toBatchIdentifierRemoveInfos(List<BatchIdentifierRemoveInfoDto> sources);

    @IterableMapping(qualifiedByName = "toBatchIdentifierRemoveInfoDto")
    List<BatchIdentifierRemoveInfoDto> toBatchIdentifierRemoveInfoDtos(List<BatchIdentifierRemoveInfo> sources);
*/

}
