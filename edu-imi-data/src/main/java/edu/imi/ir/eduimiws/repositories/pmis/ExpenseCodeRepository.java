package edu.imi.ir.eduimiws.repositories.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCodeRepository extends CrudRepository<ExpenseCodeApiEntity, Long> {

    Page<ExpenseCodeApiEntity> findAll(Pageable pageable);

    Page<ExpenseCodeApiEntity> findAllByExpenseTitleContaining(String expenseTitle,Pageable pageable);

    ExpenseCodeApiEntity findByExpenseCodePublicId(String expenseCodePublicId);

    ExpenseCodeApiEntity findByExpenseCode(Long expenseCode);
}
