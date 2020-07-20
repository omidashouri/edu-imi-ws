package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.LevelController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.LevelResponseLevelDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import edu.imi.ir.eduimiws.models.response.edu.LevelResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class LevelResponseAssembler extends RepresentationModelAssemblerSupport<LevelDto, LevelResponse> {

    private final LevelResponseLevelDtoMapper levelResponseLevelDtoMapper;


    public LevelResponseAssembler(LevelResponseLevelDtoMapper levelResponseLevelDtoMapper) {
        super(LevelController.class, LevelResponse.class);
        this.levelResponseLevelDtoMapper = levelResponseLevelDtoMapper;
    }

    @Override
    public LevelResponse toModel(LevelDto levelDto) {

        LevelResponse levelResponse = levelResponseLevelDtoMapper
                .toLevelResponse(levelDto, new CycleAvoidingMappingContext());

/*    levelResponse
            .add(linkTo(
                    methodOn(
                            LevelController.class)
                            .getLevelByLevelPublicId(levelDto.getLevelPublicId()))
                    .withSelfRel());*/

        return levelResponse;
    }


    @Override
    public CollectionModel<LevelResponse> toCollectionModel(Iterable<? extends LevelDto> levelDtos) {

        CollectionModel<LevelResponse> levelResponseCollectionModel = super.toCollectionModel(levelDtos);

        Pageable pageable = Pageable.unpaged();

/*        levelResponseCollectionModel
                .add(linkTo(methodOn(LevelController.class)
                        .getLevels(pageable)).withRel("levels"));*/

        return levelResponseCollectionModel;
    }

}
