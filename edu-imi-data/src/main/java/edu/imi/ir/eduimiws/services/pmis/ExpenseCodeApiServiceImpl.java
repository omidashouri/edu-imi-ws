package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.repositories.pmis.ExpenseCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ExpenseCodeApiServiceImpl implements ExpenseCodeApiService {


    private final ExpenseCodeRepository expenseCodeRepository;

    @Override
    public Page<ExpenseCodeApiEntity> findAll(Pageable pageable) {
        return expenseCodeRepository.findAll(pageable);
    }

    @Override
    public Page<ExpenseCodeApiEntity> findAllByExpenseTitleContaining(String expenseTitle, Pageable pageable) {
        return expenseCodeRepository.findAllByExpenseTitleContaining(expenseTitle, pageable);
    }

    @Override
    public ExpenseCodeApiEntity findByExpenseCodePublicId(String expenseCodePublicId) {
        return expenseCodeRepository.findByExpenseCodePublicId(expenseCodePublicId);
    }

    @Override
    public ExpenseCodeApiEntity findByExpenseCode(Long expenseCode) {
        return expenseCodeRepository.findByExpenseCode(expenseCode);
    }
}
