package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.AccountEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.hibernate.Hibernate;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "accountApi", target = "accountApiDto"),
            @Mapping(source = "accessType", target = "accessType"),
            @Mapping(source = "accountAdditionalInfo", target = "accountAdditionalInfoId"),
            @Mapping(source = "accountEnName", target = "accountEnName"),
            @Mapping(source = "accountLogo", target = "accountLogo"),
            @Mapping(source = "accountName", target = "accountName"),
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "accountType", target = "accountType"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "address2", target = "address2"),
            @Mapping(source = "address3", target = "address3"),
            @Mapping(source = "addressPhone", target = "addressPhone"),
            @Mapping(source = "annualRevenue", target = "annualRevenue"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "detailedCode", target = "detailedCode"),
            @Mapping(source = "economicalCode", target = "economicalCode"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "employees", target = "employees"),
            @Mapping(source = "faxNumber", target = "faxNumber"),
            @Mapping(source = "generalCode", target = "generalCode"),
            @Mapping(source = "ibmcAdditionalInfo", target = "ibmcAdditionalInfo"),
            @Mapping(source = "industryId", target = "industryId"),
            @Mapping(source = "inpeaAdditionalInfo", target = "inpeaAdditionalInfo"),
            @Mapping(source = "isHolding", target = "isHolding"),
            @Mapping(source = "isInStock", target = "isInStock"),
            @Mapping(source = "lastEditDate", target = "lastEditDate"),
            @Mapping(source = "mainPhone", target = "mainPhone"),
            @Mapping(source = "orgNationalCode", target = "orgNationalCode"),
            @Mapping(source = "orgTypeId", target = "orgTypeId"),
            @Mapping(source = "otherPhone", target = "otherPhone"),
            @Mapping(source = "ownership", target = "ownership"),
            @Mapping(source = "pathId", target = "pathId"),
            @Mapping(source = "postCode", target = "postCode"),
            @Mapping(source = "prePhone", target = "prePhone"),
            @Mapping(source = "primarySalesManId", target = "primarySalesManId"),
            @Mapping(source = "printAddressTitle", target = "printAddressTitle"),
            @Mapping(source = "printLogo", target = "printLogo"),
            @Mapping(source = "printTitle1", target = "printTitle1"),
            @Mapping(source = "printTitle2", target = "printTitle2"),
            @Mapping(source = "printTitle3", target = "printTitle3"),
            @Mapping(source = "relationTypeId", target = "relationTypeId"),
            @Mapping(source = "secondarySalesManId", target = "secondarySalesManId"),
            @Mapping(source = "siteAddress", target = "siteAddress"),
            @Mapping(source = "siteFax", target = "siteFax"),
            @Mapping(source = "sitePhone", target = "sitePhone"),
            @Mapping(source = "siteStateId", target = "siteStateId"),
            @Mapping(source = "specificCode", target = "specificCode"),
            @Mapping(source = "stockHolders", target = "stockHolders"),
            @Mapping(source = "stockOtherType", target = "stockOtherType"),
            @Mapping(source = "stockType", target = "stockType"),
            @Mapping(source = "subSys", target = "subSys"),
            @Mapping(source = "tickerSymbol", target = "tickerSymbol"),
            @Mapping(source = "typeOfActivity", target = "typeOfActivity"),
            @Mapping(source = "utilizationYear", target = "utilizationYear"),
            @Mapping(source = "verified", target = "verified"),
            @Mapping(source = "webSite", target = "webSite")
    })
    @BeanMapping(ignoreByDefault = true)
    AccountDto toAccountDto(AccountEntity accountEntity
            , @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    AccountEntity toAccountEntity(AccountDto accountDto
            , @Context CycleAvoidingMappingContext context);

    List<AccountEntity> toAccountEntities(List<AccountDto> accountDtos,
                                          @Context CycleAvoidingMappingContext context);

    List<AccountDto> toAccountDtos(List<AccountEntity> accountEntities,
                                   @Context CycleAvoidingMappingContext context);


    @BeforeMapping
    default void handleLazyFetchExceptionEntity(AccountEntity account) {
        if (account != null) {
            //        Account Public Id
            if (!Hibernate.isInitialized(account.getAccountApi())) {
                account.setAccountApi(null);
            }
        }
    }

    @BeforeMapping
    default void handleLazyFetchExceptionDto(AccountDto accountDto) {

        if (accountDto != null) {
            //        Account Public Id\
            PersistenceUtils.cleanFromProxyByNull(accountDto);
            if (!Hibernate.isInitialized(accountDto.getAccountApiDto())) {
                accountDto.setAccountApiDto(null);
            }
        }
    }

    @AfterMapping
    default void handleDtoAccountPublicId(AccountEntity accountEntity,
                                          @MappingTarget AccountDto accountDto) {


//        Account Public Id
        if (accountEntity.getAccountApi() != null) {
            if (accountEntity.getAccountApi().getAccountPublicId() != null) {
                accountDto.setAccountPublicId(accountEntity.getAccountApi().getAccountPublicId());
            }
        }

//  PeriodCourse Creator Public Id
        if (!Hibernate.isInitialized(accountEntity.getUserCreator())) {
            accountEntity.setUserCreator(null);
        }
        if (accountEntity.getUserCreator() != null) {
            if (!Hibernate.isInitialized(accountEntity.getUserCreator().getPersonApiEntity())) {
                accountEntity.getUserCreator().setPersonApiEntity(null);
            }
            if (accountEntity.getUserCreator().getPersonApiEntity() != null) {
                accountDto
                        .setUserCreatorPublicId(
                                accountEntity
                                        .getUserCreator()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }

        //  PeriodCourse Editor Public Id
        if (!Hibernate.isInitialized(accountEntity.getUserLastEditor())) {
            accountEntity.setUserLastEditor(null);
        }
        if (accountEntity.getUserLastEditor() != null) {
            if (!Hibernate.isInitialized(accountEntity.getUserLastEditor().getPersonApiEntity())) {
                accountEntity.getUserLastEditor().setPersonApiEntity(null);
            }
            if (accountEntity.getUserLastEditor().getPersonApiEntity() != null) {
                accountDto
                        .setUserLastEditorPublicId(
                                accountEntity
                                        .getUserLastEditor()
                                        .getPersonApiEntity()
                                        .getPersonPublicId()
                        );
            }
        }
    }
}

