package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.EduCategoryController;
import edu.imi.ir.eduimiws.controllers.edu.v1.FieldController;
import edu.imi.ir.eduimiws.controllers.edu.v1.LevelController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.FieldResponseFieldDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.FieldDto;
import edu.imi.ir.eduimiws.models.response.edu.FieldResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class FieldResponseFieldDtoAssembler extends RepresentationModelAssemblerSupport<FieldDto, FieldResponse> {

    private final FieldResponseFieldDtoMapper fieldResponseFieldDtoMapper;

    public FieldResponseFieldDtoAssembler(FieldResponseFieldDtoMapper fieldResponseFieldDtoMapper) {
        super(FieldController.class, FieldResponse.class);
        this.fieldResponseFieldDtoMapper = fieldResponseFieldDtoMapper;
    }

    @Override
    public FieldResponse toModel(FieldDto fieldDto) {

        FieldResponse fieldResponse = fieldResponseFieldDtoMapper
                .toFieldResponse(fieldDto, new CycleAvoidingMappingContext());

        if (fieldDto.getFieldPublicId() != null) {
            fieldResponse
                    .add(linkTo(
                            methodOn(
                                    FieldController.class)
                                    .getFieldByFieldPublicId(fieldDto.getFieldPublicId()))
                            .withSelfRel());
        }

        if (fieldDto.getLevelPublicId() != null) {
            fieldResponse.
                    add(linkTo(
                            methodOn(
                                    LevelController.class)
                                    .getLevelByLevelPublicId(fieldDto.getLevelPublicId()))
                            .withRel("levels"));
        }

        if (fieldDto.getEduCategoryPublicId() != null) {
            fieldResponse.
                    add(linkTo(
                            methodOn(
                                    EduCategoryController.class)
                                    .getEduCategoryByEduCategoryPublicId(fieldDto.getEduCategoryPublicId()))
                            .withRel("eduCategories"));
        }

        return fieldResponse;
    }


    @Override
    public CollectionModel<FieldResponse> toCollectionModel(Iterable<? extends FieldDto> fieldDtos) {

        CollectionModel<FieldResponse> fieldResponseCollectionModel = super.toCollectionModel(fieldDtos);

        Pageable pageable = Pageable.unpaged();

        fieldResponseCollectionModel
                .add(linkTo(methodOn(FieldController.class)
                        .getFields(pageable)).withRel("fields"));

        return fieldResponseCollectionModel;
    }

}
