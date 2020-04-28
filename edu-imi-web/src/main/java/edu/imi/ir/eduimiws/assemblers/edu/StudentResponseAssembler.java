package edu.imi.ir.eduimiws.assemblers.edu;

import edu.imi.ir.eduimiws.controllers.v1.StudentController;
import edu.imi.ir.eduimiws.controllers.v1.UserController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.StudentResponseStudentFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.StudentFastDto;
import edu.imi.ir.eduimiws.models.response.edu.StudentResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StudentResponseAssembler extends RepresentationModelAssemblerSupport<StudentFastDto, StudentResponse> {

    private final StudentResponseStudentFastDtoMapper studentResponseStudentFastDtoMapper;


    public StudentResponseAssembler(StudentResponseStudentFastDtoMapper studentResponseStudentFastDtoMapper) {
        super(StudentController.class, StudentResponse.class);
        this.studentResponseStudentFastDtoMapper = studentResponseStudentFastDtoMapper;
    }

    @Override
    public StudentResponse toModel(StudentFastDto studentFastDto) {

        StudentResponse studentResponse = studentResponseStudentFastDtoMapper
                .toStudentResponse(studentFastDto, new CycleAvoidingMappingContext());

        if (studentFastDto.getStudentPublicId() != null) {
            studentResponse
                    .add(linkTo(
                            methodOn(
                                    StudentController.class)
                                    .getStudentByStudentPublicId(studentFastDto.getStudentPublicId()))
                            .withSelfRel());
        }

        if (studentFastDto.getPersonPublicId() != null) {
            studentResponse.
                    add(linkTo(
                            methodOn(
                                    UserController.class)
                                    .getUserByUserPublicId(studentFastDto.getPersonPublicId()))
                            .withRel("users"));
        }

        return studentResponse;
    }


    @Override
    public CollectionModel<StudentResponse> toCollectionModel(Iterable<? extends StudentFastDto> studentFastDtos) {

        CollectionModel<StudentResponse> studentResponseCollectionModel = super.toCollectionModel(studentFastDtos);

        Pageable pageable = Pageable.unpaged();

        studentResponseCollectionModel
                .add(linkTo(methodOn(StudentController.class).getStudents(pageable)).withRel("students"));

        return studentResponseCollectionModel;
    }

}
