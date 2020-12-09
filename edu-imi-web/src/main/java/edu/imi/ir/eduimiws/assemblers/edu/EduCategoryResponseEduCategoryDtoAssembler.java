package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.EduCategoryController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.EduCategoryResponseEduCategoryDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.EduCategoryDto;
import edu.imi.ir.eduimiws.models.response.edu.EduCategoryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EduCategoryResponseEduCategoryDtoAssembler extends RepresentationModelAssemblerSupport<EduCategoryDto, EduCategoryResponse> {

    private final EduCategoryResponseEduCategoryDtoMapper eduCategoryResponseEduCategoryDtoMapper;


    public EduCategoryResponseEduCategoryDtoAssembler(EduCategoryResponseEduCategoryDtoMapper eduCategoryResponseEduCategoryDtoMapper) {
        super(EduCategoryController.class, EduCategoryResponse.class);
        this.eduCategoryResponseEduCategoryDtoMapper = eduCategoryResponseEduCategoryDtoMapper;
    }

    @Override
    public EduCategoryResponse toModel(EduCategoryDto eduCategoryDto) {

        EduCategoryResponse eduCategoryResponse = eduCategoryResponseEduCategoryDtoMapper
                .toEduCategoryResponse(eduCategoryDto, new CycleAvoidingMappingContext());

        if (eduCategoryDto.getEduCategoryPublicId() != null) {
            eduCategoryResponse
                    .add(linkTo(
                            methodOn(
                                    EduCategoryController.class)
                                    .getEduCategoryByEduCategoryPublicId(eduCategoryDto.getEduCategoryPublicId()))
                            .withSelfRel());
        }

        return eduCategoryResponse;
    }


    @Override
    public CollectionModel<EduCategoryResponse> toCollectionModel(Iterable<? extends EduCategoryDto> eduCategoryDtos) {

        CollectionModel<EduCategoryResponse> eduCategoryResponseCollectionModel = super.toCollectionModel(eduCategoryDtos);

        Pageable pageable = Pageable.unpaged();

        eduCategoryResponseCollectionModel
                .add(linkTo(methodOn(EduCategoryController.class)
                        .getEduCategorys(pageable)).withRel("eduCategorys"));

        return eduCategoryResponseCollectionModel;
    }

}
