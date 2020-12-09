package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.crm.v1.UserController;
import edu.imi.ir.eduimiws.controllers.edu.v1.PeriodController;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodResponseMapper;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.hibernate.Hibernate;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PeriodResponseAssemblerOld extends RepresentationModelAssemblerSupport<PeriodEntity, PeriodResponse> {

    private final PeriodResponseMapper periodResponseMapper;
    ;

    public PeriodResponseAssemblerOld(PeriodResponseMapper periodResponseMapper) {
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
                                .getPeriodByPeriodPublicId(period.getPeriodApi().getPeriodPublicId()))
                        .withSelfRel());

        if (!Hibernate.isInitialized(period.getExecuter())) {
            period.setExecuter(null);
        }

        if (period.getExecuter() != null) {
            if (!Hibernate.isInitialized(period.getExecuter().getPersonApiEntity())) {
                period.getExecuter().setPersonApiEntity(null);
            } else {
                periodResponse.
                        add(linkTo(
                                methodOn(
                                        UserController.class)
                                        .getUserByUserPublicId(period.getExecuter().getPersonApiEntity().getPersonPublicId()))
                                .withRel("executors"));
            }
        }

        return periodResponse;
    }

    @Override
    public CollectionModel<PeriodResponse> toCollectionModel(Iterable<? extends PeriodEntity> periods) {

        CollectionModel<PeriodResponse> periodResponseCollectionModel = super.toCollectionModel(periods);

        Pageable defaultPageable = PageRequest
                .of(0, 10, Sort.Direction.fromString("DESC"), "createDate");

        periodResponseCollectionModel
                .add(linkTo(methodOn(PeriodController.class).getPeriods(defaultPageable)).withRel("periods"));

        return periodResponseCollectionModel;
    }
}
