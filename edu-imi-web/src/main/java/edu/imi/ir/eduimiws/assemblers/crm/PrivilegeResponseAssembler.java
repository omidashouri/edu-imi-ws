package edu.imi.ir.eduimiws.assemblers.crm;


import edu.imi.ir.eduimiws.controllers.v1.PrivilegeController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PrivilegeResponsePrivilegeFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PrivilegeFastDto;
import edu.imi.ir.eduimiws.models.response.crm.PrivilegeResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PrivilegeResponseAssembler extends RepresentationModelAssemblerSupport<PrivilegeFastDto, PrivilegeResponse> {

    private final PrivilegeResponsePrivilegeFastDtoMapper privilegeResponsePrivilegeFastDtoMapper;


    public PrivilegeResponseAssembler(PrivilegeResponsePrivilegeFastDtoMapper privilegeResponsePrivilegeFastDtoMapper) {
        super(PrivilegeController.class, PrivilegeResponse.class);
        this.privilegeResponsePrivilegeFastDtoMapper = privilegeResponsePrivilegeFastDtoMapper;
    }

    @Override
    public PrivilegeResponse toModel(PrivilegeFastDto privilegeFastDto) {

        PrivilegeResponse privilegeResponse = privilegeResponsePrivilegeFastDtoMapper
                .toPrivilegeResponse(privilegeFastDto, new CycleAvoidingMappingContext());

        if (privilegeFastDto.getPrivilegePublicId() != null) {
            privilegeResponse
                    .add(linkTo(
                            methodOn(
                                    PrivilegeController.class)
                                    .getPrivilegeByPrivilegePublicId(privilegeFastDto.getPrivilegePublicId()))
                            .withSelfRel());
        }

 /*       if (privilegeFastDto.getPersonPublicId() != null) {
            privilegeResponse.
                    add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(privilegeFastDto.getPersonPublicId()))
                            .withRel("users"));
        }*/

        return privilegeResponse;
    }


    @Override
    public CollectionModel<PrivilegeResponse> toCollectionModel(Iterable<? extends PrivilegeFastDto> privilegeFastDtos) {

        CollectionModel<PrivilegeResponse> privilegeResponseCollectionModel = super.toCollectionModel(privilegeFastDtos);

        Pageable pageable = Pageable.unpaged();

        privilegeResponseCollectionModel
                .add(linkTo(methodOn(PrivilegeController.class).getPrivileges(pageable)).withRel("privileges"));

        return privilegeResponseCollectionModel;
    }

}
