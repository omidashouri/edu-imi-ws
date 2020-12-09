package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.TermController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.TermResponseTermFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.TermFastDto;
import edu.imi.ir.eduimiws.models.response.edu.TermResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TermResponseTermFastDtoAssembler extends RepresentationModelAssemblerSupport<TermFastDto, TermResponse> {
    private final TermResponseTermFastDtoMapper termResponseTermFastDtoMapper;


    public TermResponseTermFastDtoAssembler(TermResponseTermFastDtoMapper termResponseTermFastDtoMapper) {
        super(TermController.class, TermResponse.class);
        this.termResponseTermFastDtoMapper = termResponseTermFastDtoMapper;
    }

    @Override
    public TermResponse toModel(TermFastDto termFastDto) {

        TermResponse termResponse = termResponseTermFastDtoMapper
                .toTermResponse(termFastDto, new CycleAvoidingMappingContext());

        if (termFastDto.getTermPublicId() != null) {
            termResponse
                    .add(linkTo(
                            methodOn(
                                    TermController.class)
                                    .getTermByTermPublicId(termFastDto.getTermPublicId()))
                            .withSelfRel());
        }

        return termResponse;
    }


    @Override
    public CollectionModel<TermResponse> toCollectionModel(Iterable<? extends TermFastDto> termFastDtos) {

        CollectionModel<TermResponse> termResponseCollectionModel = super.toCollectionModel(termFastDtos);

        Pageable pageable = Pageable.unpaged();

        termResponseCollectionModel
                .add(linkTo(methodOn(TermController.class)
                        .getTerms(pageable)).withRel("terms"));

        return termResponseCollectionModel;
    }

}
