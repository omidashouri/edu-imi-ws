package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.RegisterController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterResponseRegisterFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import edu.imi.ir.eduimiws.models.response.edu.RegisterResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class RegisterResponseAssembler extends RepresentationModelAssemblerSupport<RegisterFastDto, RegisterResponse> {
    private final RegisterResponseRegisterFastDtoMapper registerResponseRegisterFastDtoMapper;


    public RegisterResponseAssembler(RegisterResponseRegisterFastDtoMapper registerResponseRegisterFastDtoMapper) {
        super(RegisterController.class, RegisterResponse.class);
        this.registerResponseRegisterFastDtoMapper = registerResponseRegisterFastDtoMapper;
    }

    @Override
    public RegisterResponse toModel(RegisterFastDto registerFastDto) {

        RegisterResponse registerResponse = registerResponseRegisterFastDtoMapper
                .toRegisterResponse(registerFastDto, new CycleAvoidingMappingContext());

/*        if (registerFastDto.getRegisterPublicId() != null) {
            registerResponse
                    .add(linkTo(
                            methodOn(
                                    RegisterController.class)
                                    .getRegisterByRegisterPublicId(registerFastDto.getRegisterPublicId()))
                            .withSelfRel());
        }

        if (registerFastDto.getPersonPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(registerFastDto.getPersonPublicId()))
                            .withRel("users"));
        }*/

        return registerResponse;
    }


    @Override
    public CollectionModel<RegisterResponse> toCollectionModel(Iterable<? extends RegisterFastDto> registerFastDtos) {

        CollectionModel<RegisterResponse> registerResponseCollectionModel = super.toCollectionModel(registerFastDtos);

        Pageable pageable = Pageable.unpaged();

/*        registerResponseCollectionModel
                .add(linkTo(methodOn(RegisterController.class).getRegisters(pageable)).withRel("registers"));*/

        return registerResponseCollectionModel;
    }

}
