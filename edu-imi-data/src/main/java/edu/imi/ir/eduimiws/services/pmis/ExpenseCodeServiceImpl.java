package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.repositories.pmis.ExpenseCodeRepository;
import edu.imi.ir.eduimiws.utilities.ExpenseCodes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ExpenseCodeServiceImpl implements ExpenseCodeService {


    private final ExpenseCodeRepository expenseCodeRepository;
    private final ProjectService projectService;
    private final ExpenseCodeApiFastMapper expenseCodeApiFastMapper;

    @Override
    public Page<ExpenseCodeApiEntity> findAll(Pageable pageable) {
        log.info("ExpenseCodeService.findAll - pageable: {}", pageable);
        Page<ExpenseCodeApiEntity> result = expenseCodeRepository.findAll(pageable);
        log.info("ExpenseCodeService.findAll - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<ExpenseCodeApiEntity> findAllByExpenseTitleContaining(String expenseTitle, Pageable pageable) {
        log.info("ExpenseCodeService.findAllByExpenseTitleContaining - expenseTitle: {}, pageable: {}", expenseTitle, pageable);
        Page<ExpenseCodeApiEntity> result = expenseCodeRepository.findAllByExpenseTitleContaining(expenseTitle, pageable);
        log.info("ExpenseCodeService.findAllByExpenseTitleContaining - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public ExpenseCodeApiEntity findByExpenseCodePublicId(String expenseCodePublicId) {
        log.info("ExpenseCodeService.findByExpenseCodePublicId - expenseCodePublicId: {}", expenseCodePublicId);
        ExpenseCodeApiEntity result = expenseCodeRepository.findByExpenseCodePublicId(expenseCodePublicId);
        log.info("ExpenseCodeService.findByExpenseCodePublicId - result: {}", result);
        return result;
    }

    @Override
    public ExpenseCodeApiEntity findByExpenseCode(Long expenseCode) {
        log.info("ExpenseCodeService.findByExpenseCode - expenseCode: {}", expenseCode);
        ExpenseCodeApiEntity result = expenseCodeRepository.findByExpenseCode(expenseCode);
        log.info("ExpenseCodeService.findByExpenseCode - result: {}", result);
        return result;
    }

    @Override
    public ExpenseCodeApiDto findExpenseCodeApiDtoByExpenseCodePublicId(String expenseCodePublicId) {
        log.info("ExpenseCodeService.findExpenseCodeApiDtoByExpenseCodePublicId - expenseCodePublicId: {}", expenseCodePublicId);
        ExpenseCodeApiDto result = expenseCodeApiFastMapper
                .toExpenseCodeApiDto(this.findByExpenseCodePublicId(expenseCodePublicId), new CycleAvoidingMappingContext());
        log.info("ExpenseCodeService.findExpenseCodeApiDtoByExpenseCodePublicId - result: {}", result);
        return result;
    }

    @Override
    public String findExpenseCodePublicIdByProjectPublicId(String projectPublicId) {
        log.info("ExpenseCodeService.findExpenseCodePublicIdByProjectPublicId - projectPublicId: {}", projectPublicId);

        ProjectEntity project = projectService.findProjectEntityByProjectApiPublicId(projectPublicId);

        if (project == null)
            throw new NotFoundException("cannot find any project by project public id ");

        String expenseCodePublicId = this.midProjectCodeExpenseCodePublicIdMap().get(Long.valueOf(project.getProjectCode().substring(2, 5)));
        String result = expenseCodePublicId == null ? "91842E74E2BD57F1613A943B2CC48D1016615A70FBBED819694D78403F1875DD" : expenseCodePublicId;
        log.info("ExpenseCodeService.findExpenseCodePublicIdByProjectPublicId - result: {}", result);
        return result;
    }

    @Override
    public ExpenseCodeApiDto findExpenseCodeApiByProjectPublicId(String projectPublicId) {
        log.info("ExpenseCodeService.findExpenseCodeApiByProjectPublicId - projectPublicId: {}", projectPublicId);

        String expenseCodePublicId = this.findExpenseCodePublicIdByProjectPublicId(projectPublicId);
        ExpenseCodeApiDto expenseCodeApiDto = this.findExpenseCodeApiDtoByExpenseCodePublicId(expenseCodePublicId);
        log.info("ExpenseCodeService.findExpenseCodeApiByProjectPublicId - result: {}", expenseCodeApiDto);
        return expenseCodeApiDto;
    }


    public Map<Long, String> midProjectCodeExpenseCodePublicIdMap() {
        log.info("ExpenseCodeService.midProjectCodeExpenseCodePublicIdMap - start");
        Map<Long, String> midProjectCodeExpenseCodeMap = new HashMap<>();
        midProjectCodeExpenseCodeMap.put(212L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(212)); //O
        midProjectCodeExpenseCodeMap.put(221L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(221)); //1
        midProjectCodeExpenseCodeMap.put(222L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(222)); //2
        midProjectCodeExpenseCodeMap.put(223L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(223)); //3
        midProjectCodeExpenseCodeMap.put(245L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(245)); //4
        midProjectCodeExpenseCodeMap.put(231L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(231)); //5
        midProjectCodeExpenseCodeMap.put(233L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(233)); //6
        midProjectCodeExpenseCodeMap.put(232L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(232)); //7
        midProjectCodeExpenseCodeMap.put(230L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(230)); //8
        midProjectCodeExpenseCodeMap.put(234L, ExpenseCodes.getExpensePublicIdFromMidProjectCode(234)); //8
//        all other code return 9
        log.info("ExpenseCodeService.midProjectCodeExpenseCodePublicIdMap - resultSize: {}", midProjectCodeExpenseCodeMap.size());
        return midProjectCodeExpenseCodeMap;
    }
}
