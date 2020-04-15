package edu.imi.ir.eduimiws.assemblers.crm;

import edu.imi.ir.eduimiws.controllers.v1.ContactController;
import edu.imi.ir.eduimiws.controllers.v1.UserController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.UserResponseUserFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.response.crm.UserResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserResponseAssembler extends RepresentationModelAssemblerSupport<UserFastDto, UserResponse> {


    private final UserResponseUserFastDtoMapper userResponseUserFastDtoMapper;

    public UserResponseAssembler(UserResponseUserFastDtoMapper userResponseUserFastDtoMapper) {
        super(UserController.class, UserResponse.class);
        this.userResponseUserFastDtoMapper = userResponseUserFastDtoMapper;
    }

    @Override
    public UserResponse toModel(UserFastDto userFastDto) {

        UserResponse userResponse = userResponseUserFastDtoMapper
                .toUserResponse(userFastDto, new CycleAvoidingMappingContext());

        if(userFastDto.getPersonPublicId()!= null) {
            userResponse
                    .add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(userFastDto.getPersonPublicId()))
                            .withSelfRel());
        }

        if(userFastDto.getContactPublicId()!= null) {
            userResponse
                    .add(linkTo(
                            methodOn(
                                    ContactController.class)
                                    .getContactByContactPublicId(userFastDto.getContactPublicId()))
                            .withRel("contact"));
        }


/*        userResponse.
                add(linkTo(
                        methodOn(
                                UserController.class)
                                .getUsers(Pageable.unpaged()))
                        .withRel("userss"));*/
        return userResponse;
    }


    @Override
    public CollectionModel<UserResponse> toCollectionModel(Iterable<? extends UserFastDto> entities)
    {
        CollectionModel<UserResponse> actorModels = super.toCollectionModel(entities);

        Pageable defaultPageable = PageRequest.of(0,10, Sort.Direction.fromString("DESC"),"createDate");
//        actorModels.add(linkTo(methodOn(UserController.class).getUsers(defaultPageable)).withSelfRel());

        return actorModels;
    }

}
