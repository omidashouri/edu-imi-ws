package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponseDescriptive;
import org.mapstruct.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeResponseDescriptiveMapper {

    @Named("paymentCodeApiDtoToPaymentCodeResponseDescriptive")
    @Mappings({
            @Mapping(source = "paymentCode", target = "paymentCode"),
            @Mapping(source = "paymentCodePublicId", target = "paymentCodePublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "requestIp", target = "requestIp"),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "expenseCodePublicId", target = "expenseCodePublicId"),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "expenseCodeApi.expenseTitle", target = "expenseTitle"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "project.projectName", target = "projectName"),
            @Mapping(source = "bankApiPublicId", target = "bankApiPublicId"),
            @Mapping(source = "requestCode", target = "requestCode"),
            @Mapping(source = "payerUserPublicId", target = "payerUserPublicId"),
            @Mapping(source = "payerContactPublicId", target = "payerContactPublicId"),
            @Mapping(source = "payerContact.mobilePhone", target = "payerContactMobilePhone"),
            @Mapping(source = "payerContact", target = "payerContactFullName", qualifiedByName = "getFullNameFromContact"),
            @Mapping(source = "account.accountName", target = "accountName")
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentCodeResponseDescriptive paymentCodeApiDtoToPaymentCodeResponseDescriptive(PaymentCodeApiDto source,
                                                                                     @Context CycleAvoidingMappingContext context);

    @Named("paymentCodeResponseDescriptiveToPaymentCodeApiDto")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "paymentCodeApiDtoToPaymentCodeResponseDescriptive")
    PaymentCodeApiDto paymentCodeResponseDescriptiveToPaymentCodeApiDto(PaymentCodeResponseDescriptive source,
                                                                        @Context CycleAvoidingMappingContext context);


    @IterableMapping(qualifiedByName = "paymentCodeResponseDescriptiveToPaymentCodeApiDto")
    List<PaymentCodeApiDto> paymentCodeResponseDescriptivesToPaymentCodeApiDtos(List<PaymentCodeResponseDescriptive> sources,
                                                                                @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "paymentCodeApiDtoToPaymentCodeResponseDescriptive")
    List<PaymentCodeResponseDescriptive> paymentCodeApiDtosToPaymentCodeResponseDescriptives(List<PaymentCodeApiDto> sources,
                                                                                             @Context CycleAvoidingMappingContext context);

    @Named("getFullNameFromContact")
    default String getFullNameFromContactDto(ContactDto contactDto) {
        return Optional.of(contactDto)
                .filter(Objects::nonNull)
                .map(c -> String.format("%s %s",
                        Objects.nonNull(c.getFirstName()) ? c.getFirstName() : null,
                        Objects.nonNull(c.getLastName()) ? c.getLastName() : null
                )).orElse(null);
    }
}
