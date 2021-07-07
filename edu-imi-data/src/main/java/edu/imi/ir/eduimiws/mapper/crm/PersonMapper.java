package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ContactMapper.class, PersonMapper.class, ExpenseCodeApiFastMapper.class},
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PersonMapper {

    @Named("personDtoToPersonEntity")
    @Mappings({
            @Mapping(source = "firstName",target = "firstName"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "tel",target = "tel"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "website",target = "website"),
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "limitationNumber",target = "limitationNumber"),
            @Mapping(source = "signature",target = "signature"),
            @Mapping(source = "lastlogindate",target = "lastlogindate"),
            @Mapping(source = "company",target = "company"),
            @Mapping(source = "contact",target = "contact", qualifiedByName = "toContactEntity"),
            @Mapping(source = "selectedSkin",target = "selectedSkin"),
            @Mapping(source = "selectedLanguage",target = "selectedLanguage"),
            @Mapping(source = "emailProcessType",target = "emailProcessType"),
            @Mapping(source = "personalCode",target = "personalCode"),
            @Mapping(source = "activityStatus",target = "activityStatus"),
            @Mapping(source = "kind", target = "kind"),
            @Mapping(source = "organizationPosition", target = "organizationPosition"),
            @Mapping(source = "owner", target = "owner"),
            @Mapping(source = "organizationClass", target = "organizationClass"),
            @Mapping(source = "noeEstekhdam", target = "noeEstekhdam"),
            @Mapping(source = "pwdp", target = "pwdp"),
            @Mapping(source = "signatureImg", target = "signatureImg"),
            @Mapping(source = "commerceAdditionalInfo", target = "commerceAdditionalInfo")

    })
    @BeanMapping(ignoreByDefault = true)
    PersonEntity personDtoToPersonEntity(PersonDto personDto, @Context CycleAvoidingMappingContext context);

    @Named("personEntityToPersonDto")
    @Mappings({
            @Mapping(source = "contact",target = "contact", qualifiedByName = "toContactDto")})
    @InheritInverseConfiguration(name = "personDtoToPersonEntity")
    PersonDto personEntityToPersonDto(PersonEntity personEntity, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "personDtoToPersonEntity")
    List<PersonEntity> toPersonEntities(List<PersonDto> personTpPersonDtos, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "personEntityToPersonDto")
    List<PersonDto> toPersonDtos(List<PersonEntity> personEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "personEntityToPersonDto")
    default void handlePersonApiPublicIds(PersonEntity personEntity,
                                               @MappingTarget PersonDto personDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(personEntity);
    }
}
