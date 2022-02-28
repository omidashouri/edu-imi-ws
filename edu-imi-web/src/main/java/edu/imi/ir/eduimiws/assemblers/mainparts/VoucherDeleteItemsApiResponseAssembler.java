package edu.imi.ir.eduimiws.assemblers.mainparts;


import edu.imi.ir.eduimiws.controllers.mainparts.v1.VoucherDeleteItemsController;
import edu.imi.ir.eduimiws.mapper.mainparts.VoucherDeleteItemsApiResponseMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.VoucherDeleteItemsApiDto;
import edu.imi.ir.eduimiws.models.response.mainparts.VoucherDeleteItemsApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class VoucherDeleteItemsApiResponseAssembler extends RepresentationModelAssemblerSupport<VoucherDeleteItemsApiDto, VoucherDeleteItemsApiResponse> {

    private final VoucherDeleteItemsApiResponseMapper voucherDeleteItemsApiResponseMapper;


    public VoucherDeleteItemsApiResponseAssembler(VoucherDeleteItemsApiResponseMapper voucherDeleteItemsApiResponseMapper) {
        super(VoucherDeleteItemsController.class, VoucherDeleteItemsApiResponse.class);
        this.voucherDeleteItemsApiResponseMapper = voucherDeleteItemsApiResponseMapper;
    }

    @Override
    public VoucherDeleteItemsApiResponse toModel(VoucherDeleteItemsApiDto voucherDeleteItemsApiDto) {

        VoucherDeleteItemsApiResponse voucherDeleteItemsApiResponse = voucherDeleteItemsApiResponseMapper
                .voucherDeleteItemsApiDtoToVoucherDeleteItemsApiResponse(voucherDeleteItemsApiDto);

        if (voucherDeleteItemsApiDto.getPublicId() != null) {
            voucherDeleteItemsApiResponse
                    .add(linkTo(
                            methodOn(
                                    VoucherDeleteItemsController.class)
                                    .findByPublicId(voucherDeleteItemsApiDto.getPublicId()))
                            .withSelfRel());
        }

        return voucherDeleteItemsApiResponse;
    }


    @Override
    public CollectionModel<VoucherDeleteItemsApiResponse> toCollectionModel(Iterable<? extends VoucherDeleteItemsApiDto> voucherDeleteItemsApiDtos) {

        CollectionModel<VoucherDeleteItemsApiResponse> voucherDeleteItemsApiResponseCollectionModel = super.toCollectionModel(voucherDeleteItemsApiDtos);

        Pageable pageable = Pageable.unpaged();

        voucherDeleteItemsApiResponseCollectionModel
                .add(linkTo(methodOn(VoucherDeleteItemsController.class).getVoucherDeleteItems(pageable)).withRel("voucherDeleteItemsApi"));

        return voucherDeleteItemsApiResponseCollectionModel;
    }
}
