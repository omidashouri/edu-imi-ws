package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.edu.v1.PeriodController;
import edu.imi.ir.eduimiws.controllers.edu.v1.RegisterController;
import edu.imi.ir.eduimiws.controllers.edu.v1.StudentController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.RegisterResponseRegisterFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.RegisterFastDto;
import edu.imi.ir.eduimiws.models.response.edu.RegisterResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RegisterResponseRegisterFastDtoAssembler extends RepresentationModelAssemblerSupport<RegisterFastDto, RegisterResponse> {
    private final RegisterResponseRegisterFastDtoMapper registerResponseRegisterFastDtoMapper;


    public RegisterResponseRegisterFastDtoAssembler(RegisterResponseRegisterFastDtoMapper registerResponseRegisterFastDtoMapper) {
        super(RegisterController.class, RegisterResponse.class);
        this.registerResponseRegisterFastDtoMapper = registerResponseRegisterFastDtoMapper;
    }

    @Override
    public RegisterResponse toModel(RegisterFastDto registerFastDto) {

        RegisterResponse registerResponse = registerResponseRegisterFastDtoMapper
                .toRegisterResponse(registerFastDto, new CycleAvoidingMappingContext());

        if (registerFastDto.getRegisterPublicId() != null) {
            registerResponse
                    .add(linkTo(
                            methodOn(
                                    RegisterController.class)
                                    .getRegisterByRegisterPublicId(registerFastDto.getRegisterPublicId()))
                            .withSelfRel());
        }

        if (registerFastDto.getRegisterPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    RegisterController.class)
                                    .getRegisterByRegisterPublicId(registerFastDto.getRegisterPublicId()))
                            .withRel("registers"));
        }

        if (registerFastDto.getStudentPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    StudentController.class)
                                    .getStudentByStudentPublicId(registerFastDto.getStudentPublicId()))
                            .withRel("students"));
        }

        if (registerFastDto.getPeriodPublicId() != null) {
            registerResponse.
                    add(linkTo(
                            methodOn(
                                    PeriodController.class)
                                    .getPeriodByPeriodPublicId(registerFastDto.getPeriodPublicId()))
                            .withRel("periods"));
        }

        return registerResponse;
    }


    @Override
    public CollectionModel<RegisterResponse> toCollectionModel(Iterable<? extends RegisterFastDto> registerFastDtos) {

        CollectionModel<RegisterResponse> registerResponseCollectionModel = super.toCollectionModel(registerFastDtos);

        Pageable pageable = Pageable.unpaged();

        registerResponseCollectionModel
                .add(linkTo(methodOn(RegisterController.class)
                        .getRegisters(pageable)).withRel("registers"));

        return registerResponseCollectionModel;
    }

}
