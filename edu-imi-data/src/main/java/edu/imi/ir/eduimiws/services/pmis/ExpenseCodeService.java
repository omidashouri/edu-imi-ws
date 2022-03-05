package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@MappingUtil.ExpenseCodeService
public interface ExpenseCodeService {

    Page<ExpenseCodeApiEntity> findAll(Pageable pageable);

    Page<ExpenseCodeApiEntity> findAllByExpenseTitleContaining(String expenseTitle,Pageable pageable);

    ExpenseCodeApiEntity findByExpenseCodePublicId(String expenseCodePublicId);

    ExpenseCodeApiEntity findByExpenseCode(Long expenseCode);

    @MappingUtil.ExpenseCodePublicIdToExpenseCodeApiDto
    ExpenseCodeApiDto findExpenseCodeApiDtoByExpenseCodePublicId(String expenseCodePublicId);

    @MappingUtil.ProjectPublicIdToExpenseCodePublicId
    String findExpenseCodePublicIdByProjectPublicId(String projectPublicId);

    @MappingUtil.ProjectPublicIdToExpenseCodeApi
    ExpenseCodeApiDto findExpenseCodeApiByProjectPublicId(String projectPublicId);
}
