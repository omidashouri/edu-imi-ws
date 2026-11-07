package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.models.dto.mainparts.BankApiDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.PaymentCodeApiProjection;
import edu.imi.ir.eduimiws.models.request.mainparts.PaymentCodeRequest;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import edu.imi.ir.eduimiws.repositories.mainparts.PaymentCodeRepository;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.services.pmis.ExpenseCodeService;
import edu.imi.ir.eduimiws.utilities.ConvertorUtil;
import edu.imi.ir.eduimiws.utilities.DateConvertor;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PaymentCodeServiceImpl implements PaymentCodeService {

    private final PaymentCodeRepository paymentCodeRepository;
    private final DigitalPaymentCredential digitalPaymentCredential;
    private final PublicIdUtil publicIdUtil;
    private final DateConvertor dateConvertor;
    private final BankApiService bankApiService;
    private final ExpenseCodeService expenseCodeService;
    private final ConvertorUtil convertorUtil;


    @Override
    public Page<PaymentCodeApiEntity> findAll(Pageable pageable) {
        log.info("PaymentCodeService.findAll - pageable: {}", pageable);
        Page<PaymentCodeApiEntity> result = paymentCodeRepository.findAll(pageable);
        log.info("PaymentCodeService.findAll - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode, Pageable pageable) {
        log.info("PaymentCodeService.findAllByPaymentCodeContaining - paymentCode: {}, pageable: {}", paymentCode, pageable);
        Page<PaymentCodeApiEntity> result = paymentCodeRepository.findAllByPaymentCodeContaining(paymentCode, pageable);
        log.info("PaymentCodeService.findAllByPaymentCodeContaining - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId) {
        log.info("PaymentCodeService.findByPaymentCodePublicId - paymentCodePublicId: {}", paymentCodePublicId);
        PaymentCodeApiEntity result = paymentCodeRepository.findByPaymentCodePublicId(paymentCodePublicId);
        log.info("PaymentCodeService.findByPaymentCodePublicId - result: {}", result);
        return result;
    }

    @Override
    public PaymentCodeApiEntity generatePaymentCodeByNationalCodeProjectEntityAndPaymentCodeEntity(String nationalCode,
                                                                                                   ProjectEntity project,
                                                                                                   ExpenseCodeApiEntity expenseCodeApi,
                                                                                                   String bankTwoDigitPaymentCode) {
        log.info("PaymentCodeService.generatePaymentCodeByNationalCodeProjectEntityAndPaymentCodeEntity - nationalCode: {}, projectId: {}, expenseCode: {}, bankTwoDigitPaymentCode: {}",
                nationalCode,
                project != null ? project.getId() : null,
                expenseCodeApi != null ? expenseCodeApi.getExpenseCode() : null,
                bankTwoDigitPaymentCode);

        this.checkAllInputCodesForPaymentCode(nationalCode,
                String.valueOf(expenseCodeApi.getExpenseCode()), project.getProjectCode(), bankTwoDigitPaymentCode);

        PaymentCodeApiEntity newPaymentCodeApi = new PaymentCodeApiEntity();

        String paymentCode = concatenateAllEntityInputsForPaymentCode(nationalCode, project, expenseCodeApi, bankTwoDigitPaymentCode);

        newPaymentCodeApi.setPaymentCode(paymentCode);
        newPaymentCodeApi.setNationalCode(nationalCode);
        newPaymentCodeApi.setPaymentCodePublicId(this.generatePublicId());
        newPaymentCodeApi.setCreateDateTs(dateConvertor.getCurrentTimeStampWithZoneIdTehran());
        newPaymentCodeApi.setProjectCode(project.getProjectCode());
        newPaymentCodeApi.setProject(project);
        newPaymentCodeApi.setExpenseCode(expenseCodeApi.getExpenseCode());
        newPaymentCodeApi.setExpenseCodeApi(expenseCodeApi);
        newPaymentCodeApi.setCreator(this.getPersonFromContext());

        log.info("PaymentCodeService.generatePaymentCodeByNationalCodeProjectEntityAndPaymentCodeEntity - result: paymentCodePublicId={}, paymentCode={}, projectCode={}, expenseCode={}",
                newPaymentCodeApi.getPaymentCodePublicId(), newPaymentCodeApi.getPaymentCode(),
                newPaymentCodeApi.getProjectCode(), newPaymentCodeApi.getExpenseCode());
        return newPaymentCodeApi;
    }

    @Override
    public PaymentCodeApiEntity generatePaymentCodeAndPublicId(PaymentCodeApiEntity paymentCodeApi) {
        log.info("PaymentCodeService.generatePaymentCodeAndPublicId - paymentCodePublicId: {}, nationalCode: {}, projectCode: {}",
                paymentCodeApi != null ? paymentCodeApi.getPaymentCodePublicId() : null,
                paymentCodeApi != null ? paymentCodeApi.getNationalCode() : null,
                paymentCodeApi != null ? paymentCodeApi.getProjectCode() : null);

        String paymentCode = this.concatenateAllEntityInputsForPaymentCode(paymentCodeApi.getNationalCode(),
                paymentCodeApi.getProject(), paymentCodeApi.getExpenseCodeApi(),
                paymentCodeApi.getBankApi().getBankCode());

        paymentCodeApi.setPaymentCode(paymentCode);
        paymentCodeApi.setPaymentCodePublicId(this.generatePublicId());
        paymentCodeApi.setCreateDateTs(dateConvertor.getCurrentTimeStampWithZoneIdTehran());
        log.info("PaymentCodeService.generatePaymentCodeAndPublicId - result: paymentCodePublicId={}, paymentCode={}",
                paymentCodeApi.getPaymentCodePublicId(), paymentCodeApi.getPaymentCode());
        return paymentCodeApi;
    }

    @Override
    public PaymentCodeApiEntity save(PaymentCodeApiEntity paymentCodeApiEntity) {
        log.info("PaymentCodeService.save - paymentCodePublicId: {}, paymentCode: {}, nationalCode: {}",
                paymentCodeApiEntity != null ? paymentCodeApiEntity.getPaymentCodePublicId() : null,
                paymentCodeApiEntity != null ? paymentCodeApiEntity.getPaymentCode() : null,
                paymentCodeApiEntity != null ? paymentCodeApiEntity.getNationalCode() : null);

        PersonEntity creatorPerson = ((MyPrincipleUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPerson();
        paymentCodeApiEntity.setCreator(creatorPerson);

        PaymentCodeApiEntity result = paymentCodeRepository.save(paymentCodeApiEntity);
        log.info("PaymentCodeService.save - result: id={}, paymentCodePublicId={}, paymentCode={}",
                result != null ? result.getId() : null,
                result != null ? result.getPaymentCodePublicId() : null,
                result != null ? result.getPaymentCode() : null);
        return result;
    }

    @Override
    public String concatenateAllInputsForPaymentCode(String nationalCode,
                                                     String expenseCode,
                                                     String projectCode,
                                                     String bankTwoDigitPaymentCode) {
        log.info("PaymentCodeService.concatenateAllInputsForPaymentCode - nationalCode: {}, expenseCode: {}, projectCode: {}, bankTwoDigitPaymentCode: {}",
                nationalCode, expenseCode, projectCode, bankTwoDigitPaymentCode);

        String nationalEconomicCode = nationalCode;

        if (checkStringByLength.test(nationalCode, 10))
            nationalEconomicCode = "0".concat(nationalEconomicCode);


        String paymentCode = new StringBuilder()
                .append(nationalEconomicCode)
                .append(expenseCode)
                .append(projectCode.substring(Math.max(projectCode.length() - 3, 0)))
                .append(bankTwoDigitPaymentCode)
                .toString();

        if (!checkStringByLength.test(paymentCode, 17))
            throw new NotAcceptableException("expense code is not acceptable");

        log.info("PaymentCodeService.concatenateAllInputsForPaymentCode - result: {}", paymentCode);
        return paymentCode;
    }

    @Override
    public void checkAllInputCodesForPaymentCode(String nationalCode,
                                                 String expenseCode,
                                                 String projectCode,
                                                 String bankTwoDigitPaymentCode) {
        log.info("PaymentCodeService.checkAllInputCodesForPaymentCode - nationalCode: {}, expenseCode: {}, projectCode: {}, bankTwoDigitPaymentCode: {}",
                nationalCode, expenseCode, projectCode, bankTwoDigitPaymentCode);

        if (checkStringIsNull.test(nationalCode))
            throw new NotAcceptableException("national code is null");

        if (checkStringIsNull.test(expenseCode))
            throw new NotAcceptableException("expense code is null");

        if (checkStringIsNull.test(projectCode))
            throw new NotAcceptableException("project code is null");

        if (checkStringIsNull.test(bankTwoDigitPaymentCode))
            throw new NotAcceptableException("bank two digit code is null");

        if (!checkStringByLength.test(nationalCode, 10) || !checkStringByLength.test(nationalCode, 11))
            throw new NotAcceptableException("national/economic code length is not acceptable");

        if (!checkStringByLength.test(projectCode, 8))
            throw new NotAcceptableException("project code length is not acceptable");

        log.info("PaymentCodeService.checkAllInputCodesForPaymentCode - completed");
    }

    @Override
    public void validatePaymentCodeRequestNullInputs(PaymentCodeRequest paymentCodeRequest) {
        log.info("PaymentCodeService.validatePaymentCodeRequestNullInputs - nationalCode: {}, projectPublicId: {}, bankApiPublicId: {}, payerContactPublicId: {}, accountPublicId: {}",
                paymentCodeRequest != null ? paymentCodeRequest.getNationalCode() : null,
                paymentCodeRequest != null ? paymentCodeRequest.getProjectPublicId() : null,
                paymentCodeRequest != null ? paymentCodeRequest.getBankApiPublicId() : null,
                paymentCodeRequest != null ? paymentCodeRequest.getPayerContactPublicId() : null,
                paymentCodeRequest != null ? paymentCodeRequest.getAccountPublicId() : null);

        if (isInputNullOrEqualString().test(paymentCodeRequest.getNationalCode()))
            throw new NotAcceptableException("national/economic code is null");
        if (isInputNullOrEqualString().test(paymentCodeRequest.getProjectPublicId()))
            throw new NotAcceptableException("project public id is null");


//        expense code is generated by system
/*        if (isInputNullOrEqualString().test(paymentCodeRequest.getExpenseCodePublicId()))
            paymentCodeRequest.setExpenseCodePublicId(digitalPaymentCredential.getExpenseCodeDefaultPublicId());*/
//            throw new NotAcceptableException("expense code public id is null");


        if (isInputNullOrEqualString().test(paymentCodeRequest.getBankApiPublicId())) {
            paymentCodeRequest.setBankApiPublicId(digitalPaymentCredential.getMelliPublicId());
        }
        if (isInputNullOrEqualString().test(paymentCodeRequest.getPayerContactPublicId())
                && isInputNullOrEqualString().test(paymentCodeRequest.getAccountPublicId())) {
            throw new NotAcceptableException("contactPublicId or accountPublicId should have value");
        }
        log.info("PaymentCodeService.validatePaymentCodeRequestNullInputs - completed");
    }

    @Override
    public void validatePaymentCodeApiDtoNulls(PaymentCodeApiDto paymentCodeApiDto) {
        log.info("PaymentCodeService.validatePaymentCodeApiDtoNulls - paymentCodePublicId: {}, nationalCode: {}, paymentCode: {}",
                paymentCodeApiDto != null ? paymentCodeApiDto.getPaymentCodePublicId() : null,
                paymentCodeApiDto != null ? paymentCodeApiDto.getNationalCode() : null,
                paymentCodeApiDto != null ? paymentCodeApiDto.getPaymentCode() : null);

        if (isNull().test(paymentCodeApiDto.getBankApi())) {
            paymentCodeApiDto.setBankApi(this.findBankApiDtoByBunkPublicId());
        }

        if (isNull().test(paymentCodeApiDto.getExpenseCodeApi()))
            paymentCodeApiDto.setExpenseCodeApi(this.findExpenseCodeApiDtoByExpenseCodePublicId());
//            throw new NotFoundException("Expense Code Not Found");

        if (isNull().test(paymentCodeApiDto.getProject()))
            throw new NotFoundException("Project Not Found");

        if (isNull().test(paymentCodeApiDto.getPayerContact()) && isNull().test(paymentCodeApiDto.getAccount()))
            throw new NotFoundException("contact or account Not Found");
        log.info("PaymentCodeService.validatePaymentCodeApiDtoNulls - completed");
    }

    protected Predicate<String> checkStringIsNull =
            inputString -> inputString == null ? true : false;

    protected BiPredicate<String, Integer> checkStringByLength =
            (inputString, inputLength) -> inputString.length() == inputLength ? true : false;

    protected BiFunction<String, String, String> appendStringOneToStringTwo = (stringOne, stringTwo) ->
            stringOne.concat(stringOne);

    protected String generatePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

    protected PersonEntity getPersonFromContext() {
        MyPrincipleUser user = (MyPrincipleUser) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return user.getPerson();
    }

    protected <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

    protected Predicate<String> isEmpty() {
        return string -> string.isEmpty();
    }

    protected Predicate<String> isInputNullOrEqualString() {
        Predicate<String> isNull = input -> input == null;
        Predicate<String> isStringEqual = input -> input.equalsIgnoreCase("");
        return isNull.or(isStringEqual);
    }

    BankApiDto findBankApiDtoByBunkPublicId() {
        return bankApiService.findBankDtoByBankPublicId(digitalPaymentCredential.getMelliPublicId());
    }

    ExpenseCodeApiDto findExpenseCodeApiDtoByExpenseCodePublicId() {
        return expenseCodeService.findExpenseCodeApiDtoByExpenseCodePublicId(digitalPaymentCredential.getExpenseCodeDefaultPublicId());
    }

    protected String concatenateAllEntityInputsForPaymentCode(String nationalCode, ProjectEntity project, ExpenseCodeApiEntity expenseCodeApi, String bankTwoDigitPaymentCode) {
        String paymentCode = concatenateAllInputsForPaymentCode(nationalCode,
                String.valueOf(expenseCodeApi.getExpenseCode()), project.getProjectCode(), bankTwoDigitPaymentCode);
        return paymentCode;
    }

    @Override
    public Page<PaymentCodeApiProjection> queryAllPaymentCodeProjection(Map<String, String> queryParams) {
        log.info("PaymentCodeService.queryAllPaymentCodeProjection - queryParams: {}", queryParams);

        String paymentCode, requestDescription, nationalCode,
                expenseCode, expenseTitle, projectCode, projectName,
                payerContactMobilePhone, payerContactFullName, accountName, economicalCode;

        paymentCode = convertorUtil.findKey(queryParams, "paymentCode").orElse(null);
        requestDescription = convertorUtil.findKey(queryParams, "requestDescription").orElse(null);
        nationalCode = convertorUtil.findKey(queryParams, "nationalCode").orElse(null);
        expenseCode = convertorUtil.findKey(queryParams, "expenseCode").orElse(null);
        expenseTitle = convertorUtil.findKey(queryParams, "expenseTitle").orElse(null);
        projectCode = convertorUtil.findKey(queryParams, "projectCode").orElse(null);
        projectName = convertorUtil.findKey(queryParams, "projectName").orElse(null);
        payerContactMobilePhone = convertorUtil.findKey(queryParams, "payerContactMobilePhone").orElse(null);
        payerContactFullName = convertorUtil.findKey(queryParams, "payerContactFullName").orElse(null);
        economicalCode = convertorUtil.findKey(queryParams, "economicalCode").orElse(null);
        accountName = convertorUtil.findKey(queryParams, "accountName").orElse(null);

        Pageable pageable = convertorUtil.getPageableFromQueryParam(queryParams, "nationalCode");

        Page<PaymentCodeApiProjection> result = paymentCodeRepository.queryAllPaymentCodeApiProjection(paymentCode, requestDescription,
                nationalCode, expenseCode, expenseTitle,
                projectCode, projectName,
                payerContactMobilePhone, payerContactFullName, economicalCode,
                accountName, pageable);
        log.info("PaymentCodeService.queryAllPaymentCodeProjection - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

}
