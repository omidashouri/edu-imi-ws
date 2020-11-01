package edu.imi.ir.eduimiws.assemblers.crm;

import edu.imi.ir.eduimiws.controllers.crm.v1.UserController;
import edu.imi.ir.eduimiws.controllers.v1.ContactController;
import edu.imi.ir.eduimiws.controllers.v1.RoleController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.UserRolePrivilegeResponseUserFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.response.crm.UserRolePrivilegeResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserRolePrivilegeResponseAssembler extends RepresentationModelAssemblerSupport<UserFastDto, UserRolePrivilegeResponse> {

    private final UserRolePrivilegeResponseUserFastDtoMapper userRolePrivilegeResponseUserFastDtoMapper;

    public UserRolePrivilegeResponseAssembler(UserRolePrivilegeResponseUserFastDtoMapper userRolePrivilegeResponseUserFastDtoMapper) {
        super(UserController.class, UserRolePrivilegeResponse.class);
        this.userRolePrivilegeResponseUserFastDtoMapper = userRolePrivilegeResponseUserFastDtoMapper;
    }

    @Override
    public UserRolePrivilegeResponse toModel(UserFastDto userFastDto) {

        UserRolePrivilegeResponse userRolePrivilegeResponse = userRolePrivilegeResponseUserFastDtoMapper
                .toUserRolePrivilegeResponse(userFastDto, new CycleAvoidingMappingContext());

        if(userFastDto.getPersonPublicId()!= null) {
            userRolePrivilegeResponse
                    .add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(userFastDto.getPersonPublicId()))
                            .withSelfRel());
        }

        if(userFastDto.getContactPublicId()!= null) {
            userRolePrivilegeResponse
                    .add(linkTo(
                            methodOn(
                                    ContactController.class)
                                    .getContactByContactPublicId(userFastDto.getContactPublicId()))
                            .withRel("contact"));
        }

        if(userFastDto.getNationCode()!= null) {
            userRolePrivilegeResponse
                    .add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByNationalCode(userFastDto.getNationCode()))
                            .withRel("nationalCode"));
        }

        if(userFastDto.getRoleFastDtos()!=null &&
        userFastDto.getRoleFastDtos().size()>0){
            userFastDto.getRoleFastDtos().forEach(role->{
                userRolePrivilegeResponse
                        .add(linkTo(
                                methodOn(RoleController.class)
                                        .getRoleByRolePublicId(role.getRolePublicId()))
                        .withRel("role"));
            });
        }

        return userRolePrivilegeResponse;
    }


    @Override
    public CollectionModel<UserRolePrivilegeResponse> toCollectionModel(Iterable<? extends UserFastDto> userFastDtos)
    {
        CollectionModel<UserRolePrivilegeResponse> userRolePrivilegeResponseCollectionModel = super.toCollectionModel(userFastDtos);

        Pageable defaultPageable = PageRequest
                .of(0,10, Sort.Direction.fromString("DESC"),"personalDate");

        userRolePrivilegeResponseCollectionModel
                .add(linkTo(methodOn(UserController.class).getUsers(defaultPageable)).withRel("users"));

        return userRolePrivilegeResponseCollectionModel;
    }

}
