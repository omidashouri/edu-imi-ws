package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.PersonDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

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
            @Mapping(source = "companyId",target = "companyId"),
            @Mapping(source = "contactId",target = "contactId"),
            @Mapping(source = "selectedSkin",target = "selectedSkin"),
            @Mapping(source = "selectedLanguage",target = "selectedLanguage"),
            @Mapping(source = "emailProcessType",target = "emailProcessType"),
            @Mapping(source = "personalCode",target = "personalCode"),
            @Mapping(source = "activityStatus",target = "activityStatus"),
            @Mapping(source = "kind",target = "kind"),
            @Mapping(source = "organizationPositionId",target = "organizationPositionId"),
            @Mapping(source = "ownerId",target = "ownerId"),
            @Mapping(source = "organizationClassId",target = "organizationClassId"),
            @Mapping(source = "noeEstekhdam",target = "noeEstekhdam"),
            @Mapping(source = "pwdp",target = "pwdp"),
            @Mapping(source = "signatureImg",target = "signatureImg"),
            @Mapping(source = "commerceAdditionalInfo",target = "commerceAdditionalInfo")

    })
    PersonEntity PersonDtoToPersonEntity(PersonDto personDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonDto PersonEntityToPersonDto(PersonEntity personEntity, @Context CycleAvoidingMappingContext context);
}
