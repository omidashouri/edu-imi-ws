package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.response.crm.ContactResponseForPaymentCode;
import org.mapstruct.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContactResponseForPaymentCodeContactFactDtoMapper {

    @Named("contactFastDtoToContactResponseForPaymentCode")
    @Mappings({
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "source", target = "fullName", qualifiedByName = "getFullNameFormContactFastDto"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "mobilePhone", target = "mobilePhone"),
            @Mapping(source = "birthdate", target = "birthdate")
    })
    @BeanMapping(ignoreByDefault = true)
    ContactResponseForPaymentCode contactFastDtoToContactResponseForPaymentCode(ContactFastDto source);

    @IterableMapping(qualifiedByName = "contactFastDtoToContactResponseForPaymentCode")
    List<ContactResponseForPaymentCode> contactResponseForPaymentCodeToContactFastDtos(List<ContactFastDto> sources);

    @Named("getFullNameFormContactFastDto")
    default String getFullNameFormContactFastDto(ContactFastDto contactFastDto) {

        return Optional.of(contactFastDto)
                .filter(Objects::nonNull)
                .map(c -> String.format("%s %s %s",
                        Objects.nonNull(c.getFirstName()) ? c.getFirstName() : "",
                        Objects.nonNull(c.getMiddleName()) ? c.getMiddleName() : "",
                        Objects.nonNull(c.getLastName()) ? c.getLastName() : ""
                ))
                .map(fn->fn.trim().replaceAll(" +"," "))
                .orElse(null);
    }

}
