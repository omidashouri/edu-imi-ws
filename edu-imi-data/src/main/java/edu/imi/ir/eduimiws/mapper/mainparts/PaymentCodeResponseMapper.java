package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeResponseMapper {

    @Named("paymentCodeResponseToPaymentCodeApiDto")
    @Mappings({
            @Mapping(source = "bankApiPublicId", target = "bankApiPublicId"),
            @Mapping(source = "payerContactPublicId", target = "payerContactPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "expenseCodePublicId", target = "expenseCodePublicId"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "paymentCode", target = "paymentCode"),
            @Mapping(source = "paymentCodePublicId", target = "paymentCodePublicId"),
            @Mapping(source = "payerUserPublicId", target = "payerUserPublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "requestCode", target = "requestCode"),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "requestIp", target = "requestIp")
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentCodeApiDto paymentCodeResponseToPaymentCodeApiDto(PaymentCodeResponse paymentCodeResponse,
                                          @Context CycleAvoidingMappingContext context);

    @Named("toPaymentCodeResponse")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "paymentCodeResponseToPaymentCodeApiDto")
    PaymentCodeResponse toPaymentCodeResponse(PaymentCodeApiDto paymentCodeApiDto,
                                                @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "paymentCodeResponseToPaymentCodeApiDto")
    List<PaymentCodeApiDto> toPaymentCodeApiDtos(List<PaymentCodeResponse> paymentCodeResponses,
                                                 @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toPaymentCodeResponse")
    List<PaymentCodeResponse> toPaymentCodeApiEntities(List<PaymentCodeApiDto> PaymentCodeApiDtos,
                                                        @Context CycleAvoidingMappingContext context);
}
