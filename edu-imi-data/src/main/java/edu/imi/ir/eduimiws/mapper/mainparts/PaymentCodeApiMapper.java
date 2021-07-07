package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ContactMapper.class, PersonMapper.class, ExpenseCodeApiFastMapper.class, ProjectFastMapper.class},
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PaymentCodeApiMapper {

    @Named("toPaymentCodeApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "bankCode", target = "bankCode"),
            @Mapping(source = "bankId", target = "bankId"),
            @Mapping(source = "contact", target = "contact", qualifiedByName = "toContactDto"),
            @Mapping(source = "contact.id", target = "contactId"),
            @Mapping(source = "contact.contactWebService.contactPublicId", target = "contactPublicId"),
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
            @Mapping(source = "person", target = "person", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "person.id", target = "personId"),
            @Mapping(source = "person.personApiEntity.personPublicId", target = "personPublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "project", target = "project", qualifiedByName = "toProjectDto"),
            @Mapping(source = "project.id", target = "projectId"),
            @Mapping(source = "project.projectApi.projectPublicId", target = "projectPublicId"),
            @Mapping(source = "requestCode", target = "requestCode"),
            @Mapping(source = "requestDescription", target = "requestDescription"),
            @Mapping(source = "requestId", target = "requestId"),
            @Mapping(source = "requestIp", target = "requestIp")
    })
    @BeanMapping(ignoreByDefault = true)
    PaymentCodeApiDto toPaymentCodeApiDto(PaymentCodeApiEntity PaymentCodeApiEntity,
                                          @Context CycleAvoidingMappingContext context);

    @Named("toPaymentCodeApiEntity")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toPaymentCodeApiDto")
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
