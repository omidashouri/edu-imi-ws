package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import org.mapstruct.*;
import org.springframework.context.annotation.Lazy;

@Mapper(componentModel = "spring",
        uses = {ParameterMapper.class, LanguageMapper.class},
        imports = {PublicIdUtil.class},
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CompanyMapper {

    @Named("toCompanyDto")
    @Mappings({
            @Mapping(source = "annualRevenue", target = "annualRevenue"),
            @Mapping(source = "companyApi.companyPublicId", target = "companyPublicId"),
            @Mapping(source = "billingAddress", target = "billingAddress"),
            @Mapping(source = "calenderType", target = "calenderType"),
            @Mapping(source = "companyApi", target = "companyApi"),
            @Mapping(source = "companyApi.id", target = "companyApiId"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "employees", target = "employees"),
            @Mapping(source = "fax", target = "fax"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "isMain", target = "isMain"),
            @Mapping(source = "language", target = "language"),
            @Mapping(source = "language.id", target = "languageId"),
            @Mapping(source = "logo", target = "logo"),
            @Mapping(source = "mainAccount", target = "mainAccount"),
            @Mapping(source = "mainAccount.id", target = "mainAccountId"),
//            later put accountPublicId it in companyApi
//            @Mapping(source = "companyApi.accountPublicId", target = "mainAccountPublicId"),
            @Mapping(source = "nameLo", target = "nameLo"),
            @Mapping(source = "ownership", target = "ownership"),
            @Mapping(source = "parameter", target = "parameter"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "shippingAddress", target = "shippingAddress"),
            @Mapping(source = "territory", target = "territory"),
            @Mapping(source = "webSite", target = "webSite")
    })
    @BeanMapping(ignoreByDefault = true)
    CompanyDto toCompanyDto(CompanyEntity company, @Context CycleAvoidingMappingContext context);

    @Named("toCompanyEntity")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nameLo", target = "nameLo"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "fax", target = "fax"),
            @Mapping(source = "webSite", target = "webSite"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "billingAddress", target = "billingAddress"),
            @Mapping(source = "shippingAddress", target = "shippingAddress"),
            @Mapping(source = "annualRevenue", target = "annualRevenue"),
            @Mapping(source = "employees", target = "employees"),
            @Mapping(source = "ownership", target = "ownership"),
            @Mapping(source = "parameter", target = "parameter", qualifiedByName = "parameterDtoToParameterEntity"),
            @Mapping(source = "territory", target = "territory"),
            @Mapping(source = "language", target = "language", qualifiedByName = "languageDtoToLanguageEntity"),
            @Mapping(source = "calenderType", target = "calenderType"),
//            @Mapping(source = "mainAccount", target = "mainAccount", qualifiedByName = "toAccountEntity"),
            @Mapping(source = "isMain", target = "isMain"),
            @Mapping(source = "logo", target = "logo")
    })
    @BeanMapping(ignoreByDefault = true)
    CompanyEntity toCompanyEntity(CompanyDto companyDto, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    default void handleLazyInitialization(CompanyEntity companyEntity, @MappingTarget CompanyDto companyDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(companyEntity);
    }

}
