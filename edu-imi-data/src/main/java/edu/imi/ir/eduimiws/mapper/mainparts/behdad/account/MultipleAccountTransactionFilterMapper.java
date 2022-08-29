package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

/*import edu.imi.ir.eduimiws.models.behdad.account.MultipleAccountTransactionFilter;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.MultipleAccountTransactionFilterDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MultipleAccountTransactionFilterMapper {
/*

    @Named("toMultipleAccountTransactionFilterDto")
    @Mappings({
            @Mapping(source = "accountNumbers", target = "accountNumbers"),
            @Mapping(source = "fromDateTime", target = "fromDateTime"),
            @Mapping(source = "paymentIdentifier", target = "paymentIdentifier"),
            @Mapping(source = "toDateTime", target = "toDateTime")
    })
    @BeanMapping(ignoreByDefault = true)
    MultipleAccountTransactionFilterDto toMultipleAccountTransactionFilterDto(MultipleAccountTransactionFilter multipleAccountTransactionFilter);


    @Named("toMultipleAccountTransactionFilter")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumbers", target = "accountNumbers"),
            @Mapping(source = "fromDateTime", target = "fromDateTime"),
            @Mapping(source = "paymentIdentifier", target = "paymentIdentifier"),
            @Mapping(source = "toDateTime", target = "toDateTime")

    })
    MultipleAccountTransactionFilter toMultipleAccountTransactionFilter(MultipleAccountTransactionFilterDto multipleAccountTransactionFilterDto);

    @IterableMapping(qualifiedByName = "toMultipleAccountTransactionFilter")
    List<MultipleAccountTransactionFilter> toMultipleAccountTransactionFilters(List<MultipleAccountTransactionFilterDto> multipleAccountTransactionFilterDtos);

    @IterableMapping(qualifiedByName = "toMultipleAccountTransactionFilterDto")
    List<MultipleAccountTransactionFilterDto> toMultipleAccountTransactionFilterDtos(List<MultipleAccountTransactionFilter> multipleAccountTransactionFilters);
*/

}
