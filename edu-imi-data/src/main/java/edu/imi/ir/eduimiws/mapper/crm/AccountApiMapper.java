package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.AccountApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.AccountApiDto;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {AccountMapper.class, CompanyMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountApiMapper {

    AccountApiMapper INSTANCE = Mappers.getMapper(AccountApiMapper.class);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "account", target = "account"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "companyPublicId", target = "companyPublicId"),
            @Mapping(source = "company", target = "company"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deletedAccountId", target = "deletedAccountId"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountApiDto toAccountApiDto(AccountApiEntity accountApiEntity
            , @Context CycleAvoidingMappingContext context);


    @InheritInverseConfiguration
    AccountApiEntity toAccountApi(AccountApiDto AccountApiDto, @Context CycleAvoidingMappingContext context);

    List<AccountApiEntity> toAccountApiEntities(List<AccountApiDto> AccountApiDtos, @Context CycleAvoidingMappingContext context);

    List<AccountApiDto> toAccountApiDtos(List<AccountApiEntity> AccountApiEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleLazyInitialization(AccountApiEntity accountApi, @MappingTarget AccountApiDto accountApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(accountApi);
    }

}
