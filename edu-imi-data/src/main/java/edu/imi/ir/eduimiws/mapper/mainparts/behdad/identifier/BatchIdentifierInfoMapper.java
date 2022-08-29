package edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier;

/*import edu.imi.ir.eduimiws.models.behdad.identifier.BatchIdentifierInfo;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.BatchIdentifierInfoDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {IdentifierAmountPairMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BatchIdentifierInfoMapper {

/*
    @Named("toBatchIdentifierInfoDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "identifierAmountPairList", target = "identifierAmountPairDtos",
                    qualifiedByName = "toIdentifierAmountPairDtos"),
            @Mapping(source = "toDate", target = "toDate")
    })
    @BeanMapping(ignoreByDefault = true)
    BatchIdentifierInfoDto toBatchIdentifierInfoDto(BatchIdentifierInfo source);


    @Named("toBatchIdentifierInfo")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
//            todo: checkError → identifierAmountPairList is not = new ArrayList()
            @Mapping(source = "identifierAmountPairDtos", target = "identifierAmountPairList",
                    qualifiedByName = "toIdentifierAmountPairs"),
            @Mapping(source = "toDate", target = "toDate")

    })
    BatchIdentifierInfo toBatchIdentifierInfo(BatchIdentifierInfoDto source);

    @IterableMapping(qualifiedByName = "toBatchIdentifierInfo")
    List<BatchIdentifierInfo> toBatchIdentifierInfos(List<BatchIdentifierInfoDto> sources);

    @IterableMapping(qualifiedByName = "toBatchIdentifierInfoDto")
    List<BatchIdentifierInfoDto> toBatchIdentifierInfoDtos(List<BatchIdentifierInfo> sources);
*/

}
