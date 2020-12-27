package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.CompanyEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.CompanyDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        uses = {CompanyApiMapper.class, ContactMapper.class},
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);


    @Mappings({
            @Mapping(source = "annualRevenue", target = "annualRevenue"),
            @Mapping(source = "billingAddress", target = "billingAddress"),
            @Mapping(source = "calenderType", target = "calenderType"),
            @Mapping(source = "companyApi", target = "companyApi"),
            @Mapping(source = "companyApiId", target = "companyApi.id"),
            @Mapping(source = "contactEntities", target = "contactEntities"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "employees", target = "employees"),
            @Mapping(source = "fax", target = "fax"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "isMain", target = "isMain"),
            @Mapping(source = "language", target = "language"),
            @Mapping(source = "languageId", target = "language.id"),
            @Mapping(source = "logo", target = "logo"),
            @Mapping(source = "mainAccount", target = "mainAccount"),
            @Mapping(source = "mainAccountId", target = "mainAccount.id"),
//            omiddo: handle it in method beforMapping
            @Mapping(source = "mainAccountPublicId", target = "mainAccount.accountApi.accountPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    CompanyEntity toCompanyEntity(CompanyDto companyDto, @Context CycleAvoidingMappingContext context);

}
