package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.request.mainparts.PaymentCodeRequest;
import edu.imi.ir.eduimiws.services.crm.AccountService;
import edu.imi.ir.eduimiws.services.crm.ContactService;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.services.mainparts.BankApiService;
import edu.imi.ir.eduimiws.services.pmis.ExpenseCodeService;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {java.lang.Long.class},
        uses = {BankApiService.class, ContactService.class,
                PersonService.class, ProjectService.class,
                ExpenseCodeService.class, AccountService.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeRequestMapper {

    @Named("paymentCodeRequestToPaymentCodeApiDto")
    @Mappings({
            @Mapping(source = "bankApiPublicId", target = "bankApiPublicId"),
            @Mapping(source = "bankApiPublicId", target = "bankApi",
                    qualifiedBy = MappingUtil.BankPublicIdToBankDto.class),
            @Mapping(source = "payerContactPublicId", target = "payerContactPublicId"),
            @Mapping(source = "payerContactPublicId", target = "payerContact",
                    qualifiedBy = MappingUtil.ContactPublicIdToContactDto.class),
            @Mapping(target = "expenseCode",
                    expression = "java(paymentCodeRequest.getExpenseCode()!= null ? " +
                            "Long.valueOf(paymentCodeRequest.getExpenseCode()) : null)"),
            @Mapping(source = "projectPublicId", target = "expenseCodePublicId",
                    qualifiedBy = {MappingUtil.ExpenseCodeService.class,
                            MappingUtil.ProjectPublicIdToExpenseCodePublicId.class}),
            @Mapping(source = "projectPublicId", target = "expenseCodeApi",
                    qualifiedBy = {MappingUtil.ExpenseCodeService.class,
                            MappingUtil.ProjectPublicIdToExpenseCodeApi.class}),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "payerUserPublicId", target = "payerUserPublicId"),
            @Mapping(source = "payerUserPublicId", target = "payerUser",
                    qualifiedBy = MappingUtil.PersonPublicIdToPersonDto.class),
/*            @Mapping(source = "payerUserPublicId", target = "payerUser",
                    qualifiedByName = "userPublicIdToUserDto"),*/
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectPublicId", target = "project",
                    qualifiedBy = MappingUtil.ProjectPublicIdToProjectDto.class),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "accountPublicId", target = "account",
                    qualifiedBy = {MappingUtil.AccountService.class,
                            MappingUtil.AccountPublicIdToAccountDto.class}),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "requestIp", target = "requestIp")
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentCodeApiDto paymentCodeRequestToPaymentCodeApiDto(PaymentCodeRequest paymentCodeRequest,
/*                                                            @Context PersonService personService,
                                                            @Context PersonMapper personMapper,*/
                                                            @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "paymentCodeRequestToPaymentCodeApiDto")
    List<PaymentCodeApiDto> toPaymentCodeApiDtos(List<PaymentCodeRequest> paymentCodeRequests,
/*                                                 @Context PersonService personService,
                                                 @Context PersonMapper personMapper,*/
                                                 @Context CycleAvoidingMappingContext context);

/*    @Named("userPublicIdToUserDto")
    default PersonDto userPublicIdToUserDto(String payerUserPublicId,
                                            @Context PersonService personService,
                                            @Context PersonMapper personMapper) {

        PersonEntity payerUser = personService.findPersonEntityByPersonApiPublicId(payerUserPublicId);
        return personMapper.personEntityToPersonDto(payerUser,new CycleAvoidingMappingContext());
    }*/

    @BeforeMapping
    default void changeDefaultValueToNull(PaymentCodeRequest paymentCodeRequest) {
        if (paymentCodeRequest != null) {

            if (paymentCodeRequest.getExpenseCode() != null &&
                    paymentCodeRequest.getExpenseCode().equalsIgnoreCase("string"))
                paymentCodeRequest.setExpenseCode(null);

            if (paymentCodeRequest.getRequestIp() != null &&
                    paymentCodeRequest.getRequestIp().equalsIgnoreCase("string"))
                paymentCodeRequest.setRequestIp(null);

            if (paymentCodeRequest.getProjectCode() != null &&
                    paymentCodeRequest.getProjectCode().equalsIgnoreCase("string"))
                paymentCodeRequest.setProjectCode(null);

            if (paymentCodeRequest.getNationalCode() != null &&
                    paymentCodeRequest.getNationalCode().equalsIgnoreCase("string"))
                paymentCodeRequest.setNationalCode(null);

            if (paymentCodeRequest.getRequestDescription() != null &&
                    paymentCodeRequest.getRequestDescription().equalsIgnoreCase("string"))
                paymentCodeRequest.setRequestDescription(null);

            if (paymentCodeRequest.getExpenseCodePublicId() != null &&
                    paymentCodeRequest.getExpenseCodePublicId().equalsIgnoreCase("string"))
                paymentCodeRequest.setExpenseCodePublicId(null);

            if (paymentCodeRequest.getBankApiPublicId() != null &&
                    paymentCodeRequest.getBankApiPublicId().equalsIgnoreCase("string"))
                paymentCodeRequest.setBankApiPublicId(null);

            if (paymentCodeRequest.getPayerUserPublicId() != null &&
                    paymentCodeRequest.getPayerUserPublicId().equalsIgnoreCase("string"))
                paymentCodeRequest.setPayerUserPublicId(null);

            if (paymentCodeRequest.getProjectPublicId() != null &&
                    paymentCodeRequest.getProjectPublicId().equalsIgnoreCase("string"))
                paymentCodeRequest.setProjectPublicId(null);

            if (paymentCodeRequest.getPayerContactPublicId() != null &&
                    paymentCodeRequest.getPayerContactPublicId().equalsIgnoreCase("string"))
                paymentCodeRequest.setPayerContactPublicId(null);

            if (paymentCodeRequest.getAccountPublicId() != null &&
                    paymentCodeRequest.getAccountPublicId().equalsIgnoreCase("string"))
                paymentCodeRequest.setAccountPublicId(null);
        }
    }

    @AfterMapping
    default void fillNullCodeEntities(@MappingTarget PaymentCodeApiDto paymentCodeApiDto) {
        if (paymentCodeApiDto != null) {
            if (paymentCodeApiDto.getBankCode() == null) {
                if (paymentCodeApiDto.getBankApi() != null)
                    paymentCodeApiDto.setBankCode(paymentCodeApiDto.getBankApi().getBankCode());
            }
            if (paymentCodeApiDto.getExpenseCode() == null) {
                if (paymentCodeApiDto.getExpenseCodeApi() != null)
                    paymentCodeApiDto.setExpenseCode(paymentCodeApiDto.getExpenseCodeApi().getExpenseCode());
            }
            if (paymentCodeApiDto.getProjectCode() == null) {
                if (paymentCodeApiDto.getProject() != null)
                    paymentCodeApiDto.setProjectCode(paymentCodeApiDto.getProject().getProjectCode());
            }
            if (paymentCodeApiDto.getPayerUser() == null) {
                if (paymentCodeApiDto.getPayerContact() != null) {
                    paymentCodeApiDto
                            .setRequestDescription(
                                    String.format("%s , %s",
                                            paymentCodeApiDto.getDescription() != null ? paymentCodeApiDto.getDescription() : "",
                                            paymentCodeApiDto.getPayerContact().getFirstName()
                                                    + ' ' +
                                                    paymentCodeApiDto.getPayerContact().getLastName()));
                }
            }
            if (paymentCodeApiDto.getPayerContact() == null) {
                if (paymentCodeApiDto.getPayerUser() != null) {
                    paymentCodeApiDto
                            .setRequestDescription(
                                    String.format("%s , %s",
                                            paymentCodeApiDto.getDescription() != null ? paymentCodeApiDto.getDescription() : "",
                                            paymentCodeApiDto.getPayerUser().getFirstName()
                                                    + ' ' +
                                                    paymentCodeApiDto.getPayerUser().getLastName()));
                }
            }
            if (paymentCodeApiDto.getPayerContact() != null && paymentCodeApiDto.getPayerUser() != null) {
                paymentCodeApiDto
                        .setRequestDescription(
                                String.format("%s , %s",
                                        paymentCodeApiDto.getDescription() != null ? paymentCodeApiDto.getDescription() : "",
                                        paymentCodeApiDto.getPayerUser().getFirstName()
                                                + ' ' +
                                                paymentCodeApiDto.getPayerUser().getLastName()));
            }
            if (paymentCodeApiDto.getAccount() != null) {
                paymentCodeApiDto
                        .setRequestDescription(
                                String.format("%s , %s",
                                        paymentCodeApiDto.getDescription() != null ? paymentCodeApiDto.getDescription() : "",
                                        paymentCodeApiDto.getAccount().getAccountName()));
            }
        }
    }
}
