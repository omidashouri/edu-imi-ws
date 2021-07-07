package edu.imi.ir.eduimiws.assemblers.mainparts;

import edu.imi.ir.eduimiws.controllers.mainparts.v1.PaymentCodeController;
import edu.imi.ir.eduimiws.controllers.pmis.v1.ExpenseCodeController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.mainparts.PaymentCodeResponseMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeResponseMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.PaymentCodeResponse;
import edu.imi.ir.eduimiws.models.response.pmis.ExpenseCodeResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PaymentCodeResponseAssembler extends RepresentationModelAssemblerSupport<PaymentCodeApiDto, PaymentCodeResponse> {

    private final PaymentCodeResponseMapper paymentCodeResponseMapper;


    public PaymentCodeResponseAssembler(PaymentCodeResponseMapper paymentCodeResponseMapper) {
        super(PaymentCodeController.class, PaymentCodeResponse.class);
        this.paymentCodeResponseMapper = paymentCodeResponseMapper;
    }

    @Override
    public PaymentCodeResponse toModel(PaymentCodeApiDto paymentCodeFastDto) {

        PaymentCodeResponse paymentCodeResponse = paymentCodeResponseMapper
                .toPaymentCodeResponse(paymentCodeFastDto, new CycleAvoidingMappingContext());

        if (paymentCodeFastDto.getPaymentCodePublicId() != null) {
            paymentCodeResponse
                    .add(linkTo(
                            methodOn(
                                    PaymentCodeController.class)
                                    .getPaymentCodeByPaymentCodePublicId(paymentCodeFastDto.getPaymentCodePublicId()))
                            .withSelfRel());
        }

        if (paymentCodeFastDto.getPaymentCode() != null) {
            paymentCodeResponse.
                    add(linkTo(
                            methodOn(
                                    PaymentCodeController.class)
                                    .getPaymentCodeByPaymentCode(paymentCodeFastDto.getPaymentCode(), Pageable.unpaged()))
                            .withRel("paymentCode"));
        }

        return paymentCodeResponse;
    }


    @Override
    public CollectionModel<PaymentCodeResponse> toCollectionModel(Iterable<? extends PaymentCodeApiDto> paymentCodeFastDtos) {

        CollectionModel<PaymentCodeResponse> paymentCodeResponseCollectionModel = super.toCollectionModel(paymentCodeFastDtos);

        Pageable pageable = Pageable.unpaged();

        paymentCodeResponseCollectionModel
                .add(linkTo(methodOn(PaymentCodeController.class).getPaymentCodes(pageable)).withRel("paymentCodes"));

        return paymentCodeResponseCollectionModel;
    }

}