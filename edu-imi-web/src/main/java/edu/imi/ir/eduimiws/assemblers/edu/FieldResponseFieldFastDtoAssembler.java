package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.EduCategoryController;
import edu.imi.ir.eduimiws.controllers.edu.v1.FieldController;
import edu.imi.ir.eduimiws.controllers.edu.v1.LevelController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldResponseFieldFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.FieldFastDto;
import edu.imi.ir.eduimiws.models.response.edu.FieldResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class FieldResponseFieldFastDtoAssembler extends RepresentationModelAssemblerSupport<FieldFastDto, FieldResponse> {

    private final FieldResponseFieldFastDtoMapper fieldResponseFieldFastDtoMapper;


    public FieldResponseFieldFastDtoAssembler(FieldResponseFieldFastDtoMapper fieldResponseFieldFastDtoMapper) {
        super(FieldController.class, FieldResponse.class);
        this.fieldResponseFieldFastDtoMapper = fieldResponseFieldFastDtoMapper;
    }

    @Override
    public FieldResponse toModel(FieldFastDto fieldFastDto) {

        FieldResponse fieldResponse = fieldResponseFieldFastDtoMapper
                .toFieldResponse(fieldFastDto, new CycleAvoidingMappingContext());

        if (fieldFastDto.getFieldPublicId() != null) {
            fieldResponse
                    .add(linkTo(
                            methodOn(
                                    FieldController.class)
                                    .getFieldByFieldPublicId(fieldFastDto.getFieldPublicId()))
                            .withSelfRel());
        }

/*        if (fieldFastDto.getFieldPublicId() != null) {
            fieldResponse.
                    add(linkTo(
                            methodOn(
                                    FieldController.class)
                                    .getFieldByFieldPublicId(fieldFastDto.getFieldPublicId()))
                            .withRel("fields"));
        }*/

        if (fieldFastDto.getLevelPublicId() != null) {
            fieldResponse.
                    add(linkTo(
                            methodOn(
                                    LevelController.class)
                                    .getLevelByLevelPublicId(fieldFastDto.getLevelPublicId()))
                            .withRel("levels"));
        }

        if (fieldFastDto.getEduCategoryPublicId() != null) {
            fieldResponse.
                    add(linkTo(
                            methodOn(
                                    EduCategoryController.class)
                                    .getEduCategoryByEduCategoryPublicId(fieldFastDto.getEduCategoryPublicId()))
                            .withRel("eduCategorys"));
        }
        return fieldResponse;
    }


    @Override
    public CollectionModel<FieldResponse> toCollectionModel(Iterable<? extends FieldFastDto> fieldFastDtos) {

        CollectionModel<FieldResponse> fieldResponseCollectionModel = super.toCollectionModel(fieldFastDtos);

        Pageable pageable = Pageable.unpaged();

        fieldResponseCollectionModel
                .add(linkTo(methodOn(FieldController.class)
                        .getFields(pageable)).withRel("fields"));

        return fieldResponseCollectionModel;
    }

}
