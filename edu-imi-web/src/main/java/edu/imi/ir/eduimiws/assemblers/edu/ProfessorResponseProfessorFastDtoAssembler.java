package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.crm.v1.UserController;
import edu.imi.ir.eduimiws.controllers.v1.ProfessorController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.ProfessorResponseProfessorFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.ProfessorFastDto;
import edu.imi.ir.eduimiws.models.response.edu.ProfessorResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProfessorResponseProfessorFastDtoAssembler extends
        RepresentationModelAssemblerSupport<ProfessorFastDto, ProfessorResponse> {

    private final ProfessorResponseProfessorFastDtoMapper professorResponseProfessorFastDtoMapper;

    public ProfessorResponseProfessorFastDtoAssembler(
            ProfessorResponseProfessorFastDtoMapper professorResponseProfessorFastDtoMapper) {
        super(ProfessorController.class, ProfessorResponse.class);
        this.professorResponseProfessorFastDtoMapper = professorResponseProfessorFastDtoMapper;
    }

    @Override
    public ProfessorResponse toModel(ProfessorFastDto professorFastDto) {

        ProfessorResponse professorResponse = professorResponseProfessorFastDtoMapper
                .toProfessorResponse(professorFastDto, new CycleAvoidingMappingContext());

        professorResponse
                .add(linkTo(
                        methodOn(
                                ProfessorController.class)
                                .getProfessorByProfessorPublicId(professorFastDto.getProfessorPublicId()))
                        .withSelfRel());

        if (professorFastDto.getPersonPublicId() != null) {
            professorResponse.
                    add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(professorFastDto.getPersonPublicId()))
                            .withRel("users"));
        }

        return professorResponse;
    }

    @Override
    public CollectionModel<ProfessorResponse> toCollectionModel(Iterable<? extends ProfessorFastDto> professorFastDtos) {

        CollectionModel<ProfessorResponse> professorResponseCollectionModel = super.toCollectionModel(professorFastDtos);

        Pageable pageable = Pageable.unpaged();

        professorResponseCollectionModel
                .add(linkTo(
                        methodOn(ProfessorController.class).getAllProfessors(pageable))
                        .withRel("professors"));

        return professorResponseCollectionModel;
    }
}
