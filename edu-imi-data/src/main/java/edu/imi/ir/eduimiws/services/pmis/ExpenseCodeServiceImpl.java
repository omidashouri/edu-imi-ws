package edu.imi.ir.eduimiws.services.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.repositories.pmis.ExpenseCodeRepository;
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

    @Override
    public ExpenseCodeApiDto findExpenseCodeApiDtoByExpenseCodePublicId(String expenseCodePublicId) {
        return expenseCodeApiFastMapper
                .toExpenseCodeApiDto(this.findByExpenseCodePublicId(expenseCodePublicId), new CycleAvoidingMappingContext());
    }

    @Override
    public String findExpenseCodePublicIdByProjectPublicId(String projectPublicId) {

        ProjectEntity project = projectService.findProjectEntityByProjectApiPublicId(projectPublicId);

        if (project == null)
            throw new NotFoundException("cannot find any project by project public id ");

        String expenseCodePublicId = this.midProjectCodeExpenseCodePublicIdMap().get(Long.valueOf(project.getProjectCode().substring(2, 5)));
        return expenseCodePublicId == null ? "91842E74E2BD57F1613A943B2CC48D1016615A70FBBED819694D78403F1875DD" : expenseCodePublicId;
    }

    @Override
    public ExpenseCodeApiDto findExpenseCodeApiByProjectPublicId(String projectPublicId) {

        String expenseCodePublicId = this.findExpenseCodePublicIdByProjectPublicId(projectPublicId);
        ExpenseCodeApiDto expenseCodeApiDto = this.findExpenseCodeApiDtoByExpenseCodePublicId(expenseCodePublicId);
        return expenseCodeApiDto;
    }


    public Map<Long, String> midProjectCodeExpenseCodePublicIdMap() {
        Map<Long, String> midProjectCodeExpenseCodeMap = new HashMap<>();
        midProjectCodeExpenseCodeMap.put(212L, "265D5B996E16F64685C68E51DC18457A85595759158EAAEE5CD1C143A0CD0752"); //O
        midProjectCodeExpenseCodeMap.put(221L, "D099908940230FF8DED290869251144C076F99867DD55C15897D7BAEAB4385D9"); //1
        midProjectCodeExpenseCodeMap.put(222L, "E26DB13AC288BCCFFC486527ECBCD4B2A2DEEDB34E6F7BD7B2498E23BD06DBF5"); //2
        midProjectCodeExpenseCodeMap.put(223L, "57D093943DB07A804DB7DFB1914B7B7DF587953BCF1BAA71847A7B058595F4FC"); //3
        midProjectCodeExpenseCodeMap.put(245L, "993A6F9E1C6D6C0FC753DAE5A587091D623ADF2068C14D77B28E3511A0C63A07"); //4
        midProjectCodeExpenseCodeMap.put(231L, "08A142BE0920A4807F79AEB140DD8A0C0F412EC444141C727554D617EDE18C6D"); //5
        midProjectCodeExpenseCodeMap.put(233L, "DAD9166AED5CF98A4D1834F49BCE2B4BC9D3D32B9ECFC1286D48922FDFDB9169"); //6
        midProjectCodeExpenseCodeMap.put(232L, "ED938B85A41A712D3B96ACA913437349238F80B63D4540974BDF54B53E8DF58B"); //7
        midProjectCodeExpenseCodeMap.put(230L, "E88340C9C372655EDB0DCA84326A80A8C9460AB9FDCDF41A33086F2B74190F25"); //8
        midProjectCodeExpenseCodeMap.put(234L, "E88340C9C372655EDB0DCA84326A80A8C9460AB9FDCDF41A33086F2B74190F25"); //8
//        all other code return 9
        return midProjectCodeExpenseCodeMap;
    }
}
