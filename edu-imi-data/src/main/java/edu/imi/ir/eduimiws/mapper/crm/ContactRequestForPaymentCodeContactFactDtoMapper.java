package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.request.crm.ContactCreateRequestForPaymentCode;
import edu.imi.ir.eduimiws.models.request.crm.ContactRequestForPaymentCode;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactRequestForPaymentCodeContactFactDtoMapper {

    @Named("contactRequestForPaymentCodeToContactFastDto")
    @Mappings({
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "birthdate", target = "birthdate")
    })
    @BeanMapping(ignoreByDefault = true)
    ContactFastDto contactRequestForPaymentCodeToContactFastDto(ContactRequestForPaymentCode source);

    @Named("contactCreateRequestForPaymentCodeToContactFastDto")
    @Mappings({
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "birthdate", target = "birthdate")
    })
    @BeanMapping(ignoreByDefault = true)
    ContactFastDto contactCreateRequestForPaymentCodeToContactFastDto(ContactCreateRequestForPaymentCode source);

    @IterableMapping(qualifiedByName = "contactRequestForPaymentCodeToContactFastDto")
    List<ContactFastDto> contactFastDtosToContactRequestForPaymentCodes(List<ContactRequestForPaymentCode> sources);

}
