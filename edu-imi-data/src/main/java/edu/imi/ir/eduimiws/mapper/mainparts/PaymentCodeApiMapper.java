package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.AccountMapper;
import edu.imi.ir.eduimiws.mapper.crm.ContactMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ContactMapper.class, PersonMapper.class, BankApiMapper.class,
                ExpenseCodeApiFastMapper.class, ProjectFastMapper.class, AccountMapper.class},
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeApiMapper {

    @Named("toPaymentCodeApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "bankApi.bankPublicId", target = "bankApiPublicId"),
            @Mapping(source = "bankApi.id", target = "bankApiId"),
            @Mapping(source = "bankApi", target = "bankApi",  qualifiedByName = "toBankApiDto"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "creator", target = "creator", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "creator.personApiEntity.personPublicId", target = "creatorPublicId"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "expenseCodeApi", target = "expenseCodeApi", qualifiedByName = "toExpenseCodeApiDto"),
            @Mapping(source = "expenseCodeApi.id", target = "expenseCodeId"),
            @Mapping(source = "expenseCodeApi.expenseCodePublicId", target = "expenseCodePublicId"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "paymentCode", target = "paymentCode"),
            @Mapping(source = "paymentCodePublicId", target = "paymentCodePublicId"),
            @Mapping(source = "payerUser.personApiEntity.personPublicId", target = "payerUserPublicId"),
            @Mapping(source = "payerUser", target = "payerUser", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "payerUser.id", target = "payerUserId"),
            @Mapping(source = "payerContact", target = "payerContact", qualifiedByName = "toContactDto"),
            @Mapping(source = "payerContact.contactWebService.contactPublicId", target = "payerContactPublicId"),
            @Mapping(source = "payerContact.id", target = "payerContactId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "project", target = "project", qualifiedByName = "toProjectDto"),
            @Mapping(source = "project.id", target = "projectId"),
            @Mapping(source = "project.projectApi.projectPublicId", target = "projectPublicId"),
            @Mapping(source = "requestCode", target = "requestCode"),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "requestIp", target = "requestIp"),
            @Mapping(source = "account", target = "account", qualifiedByName = "toAccountDto"),
            @Mapping(source = "account.id", target = "accountId"),
            @Mapping(source = "account.accountApi.accountPublicId", target = "accountPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentCodeApiDto toPaymentCodeApiDto(PaymentCodeApiEntity PaymentCodeApiEntity,
                                          @Context CycleAvoidingMappingContext context);

    @Named("toPaymentCodeApiEntity")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "bankApi", target = "bankApi",  qualifiedByName = "toBankApiEntity"),
            @Mapping(source = "creator", target = "creator", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "expenseCodeApi", target = "expenseCodeApi", qualifiedByName = "toExpenseCodeApiEntity"),
            @Mapping(source = "payerUser", target = "payerUser", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "payerContact", target = "payerContact", qualifiedByName = "toContactEntity"),
            @Mapping(source = "project", target = "project", qualifiedByName = "toProjectEntity"),
            @Mapping(source = "account", target = "account", qualifiedByName = "toAccountEntity"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "paymentCode", target = "paymentCode"),
            @Mapping(source = "paymentCodePublicId", target = "paymentCodePublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "requestCode", target = "requestCode"),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "requestIp", target = "requestIp")
    })
    PaymentCodeApiEntity toPaymentCodeApiEntity(PaymentCodeApiDto PaymentCodeApiDto,
                                                @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toPaymentCodeApiDto")
    List<PaymentCodeApiDto> toPaymentCodeApiDtos(List<PaymentCodeApiEntity> PaymentCodeApiEntities,
                                                 @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toPaymentCodeApiEntity")
    List<PaymentCodeApiEntity> toPaymentCodeApiEntities(List<PaymentCodeApiDto> PaymentCodeApiDtos,
                                                        @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toPaymentCodeApiDto")
    default void handlePaymentCodeApiPublicIds(PaymentCodeApiEntity paymentCodeApiEntity,
                                               @MappingTarget PaymentCodeApiDto PaymentCodeApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(paymentCodeApiEntity);
    }
}
