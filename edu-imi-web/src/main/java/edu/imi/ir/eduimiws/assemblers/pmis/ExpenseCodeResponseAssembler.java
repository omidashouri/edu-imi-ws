package edu.imi.ir.eduimiws.assemblers.pmis;

import edu.imi.ir.eduimiws.controllers.crm.v1.UserController;
import edu.imi.ir.eduimiws.controllers.edu.v1.StudentController;
import edu.imi.ir.eduimiws.controllers.pmis.v1.ExpenseCodeController;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.StudentResponseStudentFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeResponseMapper;
import edu.imi.ir.eduimiws.models.dto.edu.StudentFastDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.response.edu.StudentResponse;
import edu.imi.ir.eduimiws.models.response.pmis.ExpenseCodeResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ExpenseCodeResponseAssembler extends RepresentationModelAssemblerSupport<ExpenseCodeApiDto, ExpenseCodeResponse> {

    private final ExpenseCodeResponseMapper expenseCodeResponseMapper;


    public ExpenseCodeResponseAssembler(ExpenseCodeResponseMapper expenseCodeResponseMapper) {
        super(ExpenseCodeController.class, ExpenseCodeResponse.class);
        this.expenseCodeResponseMapper = expenseCodeResponseMapper;
    }

    @Override
    public ExpenseCodeResponse toModel(ExpenseCodeApiDto expenseCodeFastDto) {

        ExpenseCodeResponse expenseCodeResponse = expenseCodeResponseMapper
                .toExpenseCodeResponse(expenseCodeFastDto, new CycleAvoidingMappingContext());

        if (expenseCodeFastDto.getExpenseCodePublicId() != null) {
            expenseCodeResponse
                    .add(linkTo(
                            methodOn(
                                    ExpenseCodeController.class)
                                    .getExpenseCodeByExpenseCodePublicId(expenseCodeFastDto.getExpenseCodePublicId()))
                            .withSelfRel());
        }

        if (expenseCodeFastDto.getExpenseCode() != null) {
            expenseCodeResponse.
                    add(linkTo(
                            methodOn(
                                    ExpenseCodeController.class)
                                    .getExpenseCodeByExpenseCode(String.valueOf(expenseCodeFastDto.getExpenseCode())))
                            .withRel("expenseCode"));
        }

        if (expenseCodeFastDto.getExpenseTitle() != null) {
            expenseCodeResponse.
                    add(linkTo(
                            methodOn(
                                    ExpenseCodeController.class)
                                    .getExpenseCodeByExpenseTitle(expenseCodeFastDto.getExpenseTitle(), Pageable.unpaged()))
                            .withRel("expenseTitle"));
        }

        return expenseCodeResponse;
    }


    @Override
    public CollectionModel<ExpenseCodeResponse> toCollectionModel(Iterable<? extends ExpenseCodeApiDto> expenseCodeFastDtos) {

        CollectionModel<ExpenseCodeResponse> expenseCodeResponseCollectionModel = super.toCollectionModel(expenseCodeFastDtos);

        Pageable pageable = Pageable.unpaged();

        expenseCodeResponseCollectionModel
                .add(linkTo(methodOn(ExpenseCodeController.class).getExpenseCodes(pageable)).withRel("expenseCodes"));

        return expenseCodeResponseCollectionModel;
    }

}
