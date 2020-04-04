package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.PeriodController;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.models.response.edu.PeriodResponse;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class PeriodResponseAssembler  extends RepresentationModelAssemblerSupport<PeriodEntity, PeriodResponse> {



    public PeriodResponseAssembler() {
        super(PeriodController.class, PeriodResponse.class);
    }

    @Override
    public PeriodResponse toModel(PeriodEntity entity) {
        return null;
    }
}
