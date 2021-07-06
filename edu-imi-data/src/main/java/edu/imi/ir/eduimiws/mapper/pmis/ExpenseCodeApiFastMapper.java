package edu.imi.ir.eduimiws.mapper.pmis;

import edu.imi.ir.eduimiws.domain.pmis.ExpenseCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectTypeEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectTypeDto;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.StringByteArrayAdapter;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExpenseCodeApiFastMapper {

    @Named("toExpenseCodeApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "expenseCodePublicId", target = "expenseCodePublicId"),
            @Mapping(source = "expenseTitle", target = "expenseTitle"),
            @Mapping(source = "status", target = "status")
    })
    @BeanMapping(ignoreByDefault = true)
    ExpenseCodeApiDto toExpenseCodeApiDto(ExpenseCodeApiEntity expenseCodeApiEntity, @Context CycleAvoidingMappingContext context);

    @Named("toExpenseCodeApiEntity")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toExpenseCodeApiDto")
    ExpenseCodeApiEntity toExpenseCodeApiEntity(ExpenseCodeApiDto expenseCodeApiDto, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toExpenseCodeApiDto")
    List<ExpenseCodeApiDto> toExpenseCodeApiDtos(List<ExpenseCodeApiEntity> expenseCodeApiEntities, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toExpenseCodeApiEntity")
    List<ExpenseCodeApiEntity> toExpenseCodeApiEntities(List<ExpenseCodeApiDto> ExpenseCodeApiDtos, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toExpenseCodeApiDto")
    default void handleExpenseCodeApiPublicIds(ExpenseCodeApiEntity expenseCodeApiEntity, @MappingTarget ExpenseCodeApiDto expenseCodeApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(expenseCodeApiEntity);
    }
}
