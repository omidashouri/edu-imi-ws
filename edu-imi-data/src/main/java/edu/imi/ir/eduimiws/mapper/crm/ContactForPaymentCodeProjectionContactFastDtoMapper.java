package edu.imi.ir.eduimiws.mapper.crm;


import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.projections.crm.ContactForPaymentCodeProjection;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactForPaymentCodeProjectionContactFastDtoMapper {

    @Named("contactForPaymentCodeProjectionToContactFastDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "birthdate", target = "birthdate")
    })
    @BeanMapping(ignoreByDefault = true)
    ContactFastDto contactForPaymentCodeProjectionToContactFastDto(ContactForPaymentCodeProjection paymentCodeApiProjection);

    @IterableMapping(qualifiedByName = "contactForPaymentCodeProjectionToContactFastDto")
    List<ContactFastDto> contactForPaymentCodeProjectionToContactFastDtos(List<ContactForPaymentCodeProjection> paymentCodeApiProjections);

}
