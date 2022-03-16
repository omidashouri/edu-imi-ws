package edu.imi.ir.eduimiws.assemblers.mainparts;

import edu.imi.ir.eduimiws.controllers.mainparts.v1.PaymentCodeController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeResponseDescriptiveMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponseDescriptive;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PaymentCodeResponseDescriptiveAssembler extends RepresentationModelAssemblerSupport<PaymentCodeApiDto, PaymentCodeResponseDescriptive> {

    private final PaymentCodeResponseDescriptiveMapper paymentCodeResponseDescriptiveMapper;


    public PaymentCodeResponseDescriptiveAssembler(PaymentCodeResponseDescriptiveMapper paymentCodeResponseDescriptiveMapper) {
        super(PaymentCodeController.class, PaymentCodeResponseDescriptive.class);
        this.paymentCodeResponseDescriptiveMapper = paymentCodeResponseDescriptiveMapper;
    }

    @Override
    public PaymentCodeResponseDescriptive toModel(PaymentCodeApiDto paymentCodeApiDto) {

        PaymentCodeResponseDescriptive paymentCodeResponseDescriptive = paymentCodeResponseDescriptiveMapper
                .paymentCodeApiDtoToPaymentCodeResponseDescriptive(paymentCodeApiDto, new CycleAvoidingMappingContext());

        if (paymentCodeApiDto.getPaymentCodePublicId() != null) {
            paymentCodeResponseDescriptive
                    .add(linkTo(
                            methodOn(
                                    PaymentCodeController.class)
                                    .getPaymentCodeByPaymentCodePublicId(paymentCodeApiDto.getPaymentCodePublicId()))
                            .withSelfRel());
        }

        if (paymentCodeApiDto.getPaymentCode() != null) {
            paymentCodeResponseDescriptive.
                    add(linkTo(
                            methodOn(
                                    PaymentCodeController.class)
                                    .getPaymentCodeByPaymentCode(paymentCodeApiDto.getPaymentCode(), Pageable.unpaged()))
                            .withRel("paymentCode"));
        }

        return paymentCodeResponseDescriptive;
    }


    @Override
    public CollectionModel<PaymentCodeResponseDescriptive> toCollectionModel(Iterable<? extends PaymentCodeApiDto> paymentCodeApiDtos) {

        CollectionModel<PaymentCodeResponseDescriptive> paymentCodeResponseCollectionModel = super.toCollectionModel(paymentCodeApiDtos);

        Pageable pageable = Pageable.unpaged();

        paymentCodeResponseCollectionModel
                .add(linkTo(methodOn(PaymentCodeController.class).getPaymentCodes(pageable)).withRel("paymentCodes"));

        return paymentCodeResponseCollectionModel;
    }

}