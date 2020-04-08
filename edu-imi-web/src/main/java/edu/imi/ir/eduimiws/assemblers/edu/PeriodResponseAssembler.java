package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.PeriodController;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodResponseMapper;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PeriodResponseAssembler  extends RepresentationModelAssemblerSupport<PeriodEntity, PeriodResponse> {

    private final PeriodResponseMapper periodResponseMapper;;

    public PeriodResponseAssembler(PeriodResponseMapper periodResponseMapper) {
        super(PeriodController.class, PeriodResponse.class);
        this.periodResponseMapper = periodResponseMapper;
    }

    @Override
    public PeriodResponse toModel(PeriodEntity period) {

        PeriodResponse periodResponse = periodResponseMapper
                .PeriodEntityToPeriodResponse(period, new CycleAvoidingMappingContext());
        periodResponse
                .add(linkTo(
                        methodOn(
                                PeriodController.class)
                                .getPeriodByPeriodPublicId(period.getPeriodWebService().getPeriodPublicId()))
                .withSelfRel());

        periodResponse.
                add(linkTo(
                        methodOn(
                                PeriodController.class)
                                .getPeriods(Pageable.unpaged()))
                .withRel("periods"));

        return periodResponse;
    }

    @Override
    public CollectionModel<PeriodResponse> toCollectionModel(Iterable<? extends PeriodEntity> entities)
    {
        CollectionModel<PeriodResponse> actorModels = super.toCollectionModel(entities);

        Pageable defaultPageable = PageRequest.of(0,10, Sort.Direction.fromString("DESC"),"createDate");
        actorModels.add(linkTo(methodOn(PeriodController.class).getAllPeriods(defaultPageable)).withSelfRel());

        return actorModels;
    }
}
