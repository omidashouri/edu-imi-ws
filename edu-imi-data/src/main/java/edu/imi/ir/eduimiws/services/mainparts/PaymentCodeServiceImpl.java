package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.models.dto.mainparts.BankApiDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.PaymentCodeRequest;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import edu.imi.ir.eduimiws.repositories.mainparts.PaymentCodeRepository;
import edu.imi.ir.eduimiws.security.DigitalPaymentCredential;
import edu.imi.ir.eduimiws.utilities.DateConvertor;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    public Page<PaymentCodeApiEntity> findAll(Pageable pageable) {
        return paymentCodeRepository.findAll(pageable);
    }

    @Override
    public Page<PaymentCodeApiEntity> findAllByPaymentCodeContaining(String paymentCode, Pageable pageable) {
        return paymentCodeRepository.findAllByPaymentCodeContaining(paymentCode, pageable);
    }

    @Override
    public PaymentCodeApiEntity findByPaymentCodePublicId(String paymentCodePublicId) {
        return paymentCodeRepository.findByPaymentCodePublicId(paymentCodePublicId);
    }

    @Override
    public PaymentCodeApiEntity generatePaymentCodeByNationalCodeProjectEntityAndPaymentCodeEntity(String nationalCode,
                                                                                                   ProjectEntity project,
                                                                                                   ExpenseCodeApiEntity expenseCodeApi,
                                                                                                   String bankTwoDigitPaymentCode) {
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

        return newPaymentCodeApi;
    }

    @Override
    public PaymentCodeApiEntity generatePaymentCodeAndPublicId(PaymentCodeApiEntity paymentCodeApi) {

        String paymentCode = this.concatenateAllEntityInputsForPaymentCode(paymentCodeApi.getNationalCode(),
                paymentCodeApi.getProject(), paymentCodeApi.getExpenseCodeApi(),
                paymentCodeApi.getBankApi().getBankCode());

        paymentCodeApi.setPaymentCode(paymentCode);
        paymentCodeApi.setPaymentCodePublicId(this.generatePublicId());
        paymentCodeApi.setCreateDateTs(dateConvertor.getCurrentTimeStampWithZoneIdTehran());
        return paymentCodeApi;
    }

    @Override
    public PaymentCodeApiEntity save(PaymentCodeApiEntity paymentCodeApiEntity) {

        PersonEntity creatorPerson = ((MyPrincipleUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getPerson();
        paymentCodeApiEntity.setCreator(creatorPerson);

        return paymentCodeRepository.save(paymentCodeApiEntity);
    }

    @Override
    public String concatenateAllInputsForPaymentCode(String nationalCode,
                                                     String expenseCode,
                                                     String projectCode,
                                                     String bankTwoDigitPaymentCode) {

        String paymentCode = new StringBuilder()
                .append(0)
                .append(nationalCode)
                .append(expenseCode)
                .append(projectCode.substring(Math.max(projectCode.length() - 3, 0)))
                .append(bankTwoDigitPaymentCode)
                .toString();

        if (!checkStringByLength.test(paymentCode, 17))
            throw new NotAcceptableException("expense code is not acceptable");

        return paymentCode;
    }

    @Override
    public void checkAllInputCodesForPaymentCode(String nationalCode,
                                                 String expenseCode,
                                                 String projectCode,
                                                 String bankTwoDigitPaymentCode) {

        if (checkStringIsNull.test(nationalCode))
            throw new NotAcceptableException("national code is null");

        if (checkStringIsNull.test(expenseCode))
            throw new NotAcceptableException("expense code is null");

        if (checkStringIsNull.test(projectCode))
            throw new NotAcceptableException("project code is null");

        if (checkStringIsNull.test(bankTwoDigitPaymentCode))
            throw new NotAcceptableException("bank two digit code is null");

        if (!checkStringByLength.test(nationalCode, 10))
            throw new NotAcceptableException("national code length is not acceptable");

        if (!checkStringByLength.test(projectCode, 8))
            throw new NotAcceptableException("project code length is not acceptable");

    }

    @Override
    public void validatePaymentCodeRequestNullInputs(PaymentCodeRequest paymentCodeRequest) {
        if (isInputNullOrEqualString().test(paymentCodeRequest.getNationalCode()))
            throw new NotAcceptableException("national code is null");
        if (isInputNullOrEqualString().test(paymentCodeRequest.getExpenseCodePublicId()))
            throw new NotAcceptableException("expense code public id is null");
        if (isInputNullOrEqualString().test(paymentCodeRequest.getProjectPublicId()))
            throw new NotAcceptableException("project public id is null");
        if (isInputNullOrEqualString().test(paymentCodeRequest.getBankApiPublicId())) {
            paymentCodeRequest.setBankApiPublicId(digitalPaymentCredential.getMelliPublicId());
        }
        if (isInputNullOrEqualString().test(paymentCodeRequest.getPayerContactPublicId())
                && isInputNullOrEqualString().test(paymentCodeRequest.getPayerUserPublicId())) {
            throw new NotAcceptableException("both payer contact and payer user public Id are null");
        }
    }

    @Override
    public void validatePaymentCodeApiDtoNulls(PaymentCodeApiDto paymentCodeApiDto) {
        if (isNull().test(paymentCodeApiDto.getBankApi())) {
            paymentCodeApiDto.setBankApi(this.findBankApiDtoByBunkPublicId());
        }

        if (isNull().test(paymentCodeApiDto.getExpenseCodeApi()))
            throw new NotFoundException("Expense Code Not Found");

        if (isNull().test(paymentCodeApiDto.getProject()))
            throw new NotFoundException("Project Not Found");

        if (isNull().test(paymentCodeApiDto.getPayerUser()) && isNull().test(paymentCodeApiDto.getPayerContact()))
            throw new NotFoundException("Payer Not Found");
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

    protected String concatenateAllEntityInputsForPaymentCode(String nationalCode, ProjectEntity project, ExpenseCodeApiEntity expenseCodeApi, String bankTwoDigitPaymentCode) {
        String paymentCode = concatenateAllInputsForPaymentCode(nationalCode,
                String.valueOf(expenseCodeApi.getExpenseCode()), project.getProjectCode(), bankTwoDigitPaymentCode);
        return paymentCode;
    }

}
