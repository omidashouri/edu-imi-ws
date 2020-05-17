package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.PeriodController;
import edu.imi.ir.eduimiws.controllers.v1.RegisterController;
import edu.imi.ir.eduimiws.controllers.v1.StudentController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterResponseRegisterDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterDto;
import edu.imi.ir.eduimiws.models.response.edu.RegisterResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RegisterResponseRegisterDtoAssembler extends RepresentationModelAssemblerSupport<RegisterDto, RegisterResponse> {
    private final RegisterResponseRegisterDtoMapper registerResponseRegisterDtoMapper;


    public RegisterResponseRegisterDtoAssembler(RegisterResponseRegisterDtoMapper registerResponseRegisterDtoMapper) {
        super(RegisterController.class, RegisterResponse.class);
        this.registerResponseRegisterDtoMapper = registerResponseRegisterDtoMapper;
    }

    @Override
    public RegisterResponse toModel(RegisterDto registerDto) {

        RegisterResponse registerResponse = registerResponseRegisterDtoMapper
                .toRegisterResponse(registerDto, new CycleAvoidingMappingContext());

        if (registerDto.getRegisterPublicId() != null) {
            registerResponse
                    .add(linkTo(
                            methodOn(
                                    RegisterController.class)
                                    .getRegisterByRegisterPublicId(registerDto.getRegisterPublicId()))
                            .withSelfRel());
        }

        if (registerDto.getRegisterPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    RegisterController.class)
                                    .getRegisterByRegisterPublicId(registerDto.getRegisterPublicId()))
                            .withRel("registers"));
        }

        if (registerDto.getStudentPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    StudentController.class)
                                    .getStudentByStudentPublicId(registerDto.getStudentPublicId()))
                            .withRel("students"));
        }

        if (registerDto.getPeriodPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    PeriodController.class)
                                    .getPeriodByPeriodPublicId(registerDto.getPeriodPublicId()))
                            .withRel("periods"));
        }

        return registerResponse;
    }


    @Override
    public CollectionModel<RegisterResponse> toCollectionModel(Iterable<? extends RegisterDto> registerDtos) {

        CollectionModel<RegisterResponse> registerResponseCollectionModel = super.toCollectionModel(registerDtos);

        Pageable pageable = Pageable.unpaged();

        registerResponseCollectionModel
                .add(linkTo(methodOn(RegisterController.class)
                        .getRegisters(pageable)).withRel("registers"));

        return registerResponseCollectionModel;
    }

}
