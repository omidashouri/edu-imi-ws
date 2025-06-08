package edu.imi.ir.eduimiws.mapper.mainparts.behdad;

/*import edu.imi.ir.eduimiws.models.behdad.account.BalanceInfo;
import edu.imi.ir.eduimiws.models.behdad.account.PagedData;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagedDataDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;*/

import edu.imi.ir.eduimiws.mapper.mainparts.behdad.account.BankTransactionMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.PagedDataDto;
import edu.imi.ir.eduimiws.models.wsdl.behdad.BankTransaction;
import edu.imi.ir.eduimiws.models.wsdl.behdad.PagedData;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PagedDataMapper {


    @Named("toPagedDataDto")
    @Mappings({
            @Mapping(source = "currentPageData", target = "currentPageData"),
            @Mapping(source = "pageNumber", target = "pageNumber"),
            @Mapping(source = "pageSize", target = "pageSize"),
            @Mapping(source = "totalCount", target = "totalCount")
    })
    @BeanMapping(ignoreByDefault = true)
    PagedDataDto toPagedDataDto(PagedData pagedData,
                                @Context BankTransactionMapper bankTransactionMapper);

    @IterableMapping(qualifiedByName = "toPagedDataDto")
    List<PagedDataDto> toPagedDataDtos(List<PagedData> pagedDataes,
                                       @Context BankTransactionMapper bankTransactionMapper);

    @AfterMapping
    default void convertListObjects(PagedData source,
                                          @MappingTarget PagedDataDto target,
                                          @Context BankTransactionMapper bankTransactionMapper) {
        if(target.isBankTransactionWsdlsNull()){
            if (!target.isCurrentPageDataNull()) {
                source.getCurrentPageData().stream()
                        .map(p -> (BankTransaction) p)
                        .collect(Collectors.toList())
                        .forEach(target.getBankTransactionWsdls()::add);
            }
        }

        if(target.isBankTransactionDtosNull()){
            if (!target.isBankTransactionWsdlsNull()) {
               target.setBankTransactionDtos(bankTransactionMapper
                       .toBankTransactionDtos(target.getBankTransactionWsdls()));
            }
        }
    }



}
