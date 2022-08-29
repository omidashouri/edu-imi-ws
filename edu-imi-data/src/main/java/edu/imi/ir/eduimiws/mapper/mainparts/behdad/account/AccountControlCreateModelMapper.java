package edu.imi.ir.eduimiws.mapper.mainparts.behdad.account;


/*import edu.imi.ir.eduimiws.models.behdad.account.AccountControlCreateModel;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.AccountControlCreateModelDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountControlCreateModelMapper {
/*

    @Named("toAccountControlCreateModelDto")
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "controlType", target = "controlType"),
            @Mapping(source = "identifierType", target = "identifierType"),
            @Mapping(source = "toDate", target = "toDate")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountControlCreateModelDto toAccountControlCreateModelDto(AccountControlCreateModel accountControlCreateModel);


    @Named("toAccountControlCreateModel")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "controlType", target = "controlType"),
            @Mapping(source = "identifierType", target = "identifierType"),
            @Mapping(source = "toDate", target = "toDate")

    })
    AccountControlCreateModel toAccountControlCreateModel(AccountControlCreateModelDto accountControlCreateModelDto);

    @IterableMapping(qualifiedByName = "toAccountControlCreateModel")
    List<AccountControlCreateModel> toAccountControlCreateModels(List<AccountControlCreateModelDto> accountControlCreateModelDtos);

    @IterableMapping(qualifiedByName = "toAccountControlCreateModelDto")
    List<AccountControlCreateModelDto> toAccountControlCreateModelDtos(List<AccountControlCreateModel> accountControlCreateModels);
*/

}
