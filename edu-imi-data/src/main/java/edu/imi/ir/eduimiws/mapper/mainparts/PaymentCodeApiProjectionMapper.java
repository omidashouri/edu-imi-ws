package edu.imi.ir.eduimiws.mapper.mainparts;


import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.PaymentCodeApiProjection;
import edu.imi.ir.eduimiws.services.crm.AccountService;
import edu.imi.ir.eduimiws.services.crm.ContactService;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.services.mainparts.BankApiService;
import edu.imi.ir.eduimiws.services.pmis.ExpenseCodeService;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {PersonService.class, ContactService.class,
                ExpenseCodeService.class, ProjectService.class,
                BankApiService.class, AccountService.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeApiProjectionMapper {

    @Named("toPaymentCodeApiDto")
    @Mappings({
            @Mapping(source = "paymentCode", target = "paymentCode"),
            @Mapping(source = "paymentCodePublicId", target = "paymentCodePublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "creatorPublicId", target = "creator",
                    qualifiedBy = {MappingUtil.PersonService.class,
                            MappingUtil.PersonPublicIdToPersonDto.class}),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "requestIp", target = "requestIp"),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "nationalCode", target = "nationalCode"),
            @Mapping(source = "expenseCodePublicId", target = "expenseCodePublicId"),
            @Mapping(source = "expenseCodePublicId", target = "expenseCodeApi",
                    qualifiedBy = {MappingUtil.ExpenseCodeService.class,
                            MappingUtil.ExpenseCodePublicIdToExpenseCodeApiDto.class}),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectPublicId", target = "project",
                    qualifiedBy = {MappingUtil.ProjectService.class,
                            MappingUtil.ProjectPublicIdToProjectDto.class}),
            @Mapping(source = "bankApiPublicId", target = "bankApiPublicId"),
            @Mapping(source = "bankApiPublicId", target = "bankApi",
                    qualifiedBy = {MappingUtil.BankService.class,
                            MappingUtil.BankPublicIdToBankDto.class}),
            @Mapping(source = "requestCode", target = "requestCode"),
            @Mapping(source = "payerUserPublicId", target = "payerUserPublicId"),
            @Mapping(source = "payerUserPublicId", target = "payerUser",
                    qualifiedBy = {MappingUtil.PersonService.class,
                            MappingUtil.PersonPublicIdToPersonDto.class}),
            @Mapping(source = "payerContactPublicId", target = "payerContactPublicId"),
            @Mapping(source = "payerContactPublicId", target = "payerContact",
                    qualifiedBy = {MappingUtil.ContactService.class,
                            MappingUtil.ContactPublicIdToContactDto.class}),
            @Mapping(source = "accountPublicId", target = "accountPublicId"),
            @Mapping(source = "accountPublicId", target = "account",
                    qualifiedBy = {MappingUtil.AccountService.class,
                            MappingUtil.AccountPublicIdToAccountDto.class})
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentCodeApiDto toPaymentCodeApiDto(PaymentCodeApiProjection paymentCodeApiProjection);

    @IterableMapping(qualifiedByName = "toPaymentCodeApiDto")
    List<PaymentCodeApiDto> toPaymentCodeApiDtos(List<PaymentCodeApiProjection> paymentCodeApiProjections);


}
