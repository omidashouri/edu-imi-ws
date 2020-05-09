package edu.imi.ir.eduimiws.assemblers.crm;

import edu.imi.ir.eduimiws.controllers.v1.RoleController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.RoleResponseRoleFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.RoleFastDto;
import edu.imi.ir.eduimiws.models.response.crm.RoleResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RoleResponseAssembler extends RepresentationModelAssemblerSupport<RoleFastDto, RoleResponse> {

    private final RoleResponseRoleFastDtoMapper roleResponseRoleFastDtoMapper;


    public RoleResponseAssembler(RoleResponseRoleFastDtoMapper roleResponseRoleFastDtoMapper) {
        super(RoleController.class, RoleResponse.class);
        this.roleResponseRoleFastDtoMapper = roleResponseRoleFastDtoMapper;
    }

    @Override
    public RoleResponse toModel(RoleFastDto roleFastDto) {

        RoleResponse roleResponse = roleResponseRoleFastDtoMapper
                .toRoleResponse(roleFastDto, new CycleAvoidingMappingContext());

        if (roleFastDto.getRolePublicId() != null) {
            roleResponse
                    .add(linkTo(
                            methodOn(
                                    RoleController.class)
                                    .getRoleByRolePublicId(roleFastDto.getRolePublicId()))
                            .withSelfRel());
        }

 /*       if (roleFastDto.getPersonPublicId() != null) {
            roleResponse.
                    add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(roleFastDto.getPersonPublicId()))
                            .withRel("users"));
        }*/

        return roleResponse;
    }


    @Override
    public CollectionModel<RoleResponse> toCollectionModel(Iterable<? extends RoleFastDto> roleFastDtos) {

        CollectionModel<RoleResponse> roleResponseCollectionModel = super.toCollectionModel(roleFastDtos);

        Pageable pageable = Pageable.unpaged();

        roleResponseCollectionModel
                .add(linkTo(methodOn(RoleController.class).getRoles(pageable)).withRel("roles"));

        return roleResponseCollectionModel;
    }

}
