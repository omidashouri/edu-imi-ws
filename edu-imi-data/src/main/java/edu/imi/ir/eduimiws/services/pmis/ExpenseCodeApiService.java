package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseCodeApiService {

    Page<ExpenseCodeApiEntity> findAll(Pageable pageable);

    Page<ExpenseCodeApiEntity> findAllByExpenseTitleContaining(String expenseTitle,Pageable pageable);

    ExpenseCodeApiEntity findByExpenseCodePublicId(String expenseCodePublicId);

    ExpenseCodeApiEntity findByExpenseCode(Long expenseCode);
}
