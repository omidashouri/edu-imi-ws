package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

//User is PersonEntity plus PersonApiEntity
@Mapper
public interface UserFastDtoMapper {

    UserFastDtoMapper INSTANCE = Mappers.getMapper(UserFastDtoMapper.class);

    /*
     *organizationClassPublicId, organizationPositionPublicId, ownerPublicId,
     * authorityPublicId, commerceAdditionalInfoPublicId, companyPublicId,
     * selectedLanguagePublicId,
     * */


    @Mappings({
            @Mapping(source = "personPublicId", target = "personApiEntity.personPublicId"),
            @Mapping(source = "description", target = "personApiEntity.description"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "emailProcessType", target = "emailProcessType"),
            @Mapping(source = "emailVerificationStatus", target = "personApiEntity.emailVerificationStatus"),
            @Mapping(source = "emailVerificationToken", target = "personApiEntity.emailVerificationToken"),
            @Mapping(source = "encryptedPassword", target = "personApiEntity.encryptedPassword"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "kind", target = "kind"),
            @Mapping(source = "lastlogindate", target = "lastlogindate"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "limitationNumber", target = "limitationNumber"),
            @Mapping(source = "mobileVerificationStatus", target = "personApiEntity.mobileVerificationStatus"),
            @Mapping(source = "noeEstekhdam", target = "noeEstekhdam"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "personalCode", target = "personalCode"),
            @Mapping(source = "pwdp", target = "pwdp"),
            @Mapping(source = "selectedSkin", target = "selectedSkin"),
            @Mapping(source = "signature", target = "signature"),
            @Mapping(source = "signatureImg", target = "signatureImg"),
            @Mapping(source = "tel", target = "tel"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "website", target = "website"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "address", target = "address")
    })
    @BeanMapping(ignoreByDefault = true)
    PersonEntity toPersonEntity(UserFastDto userFastDto, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    UserFastDto toUserFastDto(PersonEntity personEntity, @Context CycleAvoidingMappingContext context);

    List<PersonEntity> toPersonEntities(List<UserFastDto> UserFastDtos, @Context CycleAvoidingMappingContext context);

    List<UserFastDto> toUserFastDtos(List<PersonEntity> personEntities, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleContactPublicIds(PersonEntity personEntity, @MappingTarget UserFastDto userFastDto) {
        if (!Hibernate.isInitialized(personEntity.getContact())) {
            personEntity.setContact(null);
        }
        if (personEntity.getContact() != null) {
            if (personEntity.getContact().getContactWebService() != null) {
                userFastDto.
                        setContactPublicId(personEntity.getContact().getContactWebService().getContactPublicId());
            }
            if (personEntity.getContact().getNationCode() != null) {
                userFastDto.setNationCode(personEntity.getContact().getNationCode());
            }
        }
        if (!Hibernate.isInitialized(personEntity.getPersonApiEntity())) {
            personEntity.setPersonApiEntity(null);
        }
        if (personEntity.getPersonApiEntity() != null) {
            if (!Hibernate.isInitialized(personEntity.getPersonApiEntity().getRoles())) {
                personEntity.getPersonApiEntity().setRoles(null);
            }
            if (personEntity.getPersonApiEntity().getRoles() != null &&
                    personEntity.getPersonApiEntity().getRoles().size() > 0) {
                List<RoleApiEntity> roleApies = personEntity
                        .getPersonApiEntity()
                        .getRoles()
                        .stream()
                        .distinct()
                        .collect(Collectors.toList());
                userFastDto.setRoleFastDtos(
                        new RoleFastDtoMapperImpl()
                                .toRoleFastDtos(roleApies, new CycleAvoidingMappingContext()));
            }
        }
    }
}
