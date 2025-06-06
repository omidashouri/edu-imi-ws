package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;

/*import edu.imi.ir.eduimiws.models.behdad.account.MultipleAccountTransactionFilter;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.MultipleAccountTransactionFilterDto;*/

import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.MultipleAccountTransactionFilterDto;
import edu.imi.ir.eduimiws.models.request.behdad.MultipleAccountTransactionFilterRequest;
import edu.imi.ir.eduimiws.models.wsdl.behdad.MultipleAccountTransactionFilter;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MultipleAccountTransactionFilterMapper {

    @Named("toMultipleAccountTransactionFilterDtoFromRequest")
    @Mappings({
            @Mapping(source = "accountNumbers", target = "accountNumbers"),
            @Mapping(source = "fromDateTime", target = "fromDateTime"),
            @Mapping(source = "paymentIdentifier", target = "paymentIdentifier"),
            @Mapping(source = "toDateTime", target = "toDateTime")
    })
    @BeanMapping(ignoreByDefault = true)
    MultipleAccountTransactionFilterDto toMultipleAccountTransactionFilterDtoFromRequest(MultipleAccountTransactionFilterRequest multipleAccountTransactionFilter);

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
}
