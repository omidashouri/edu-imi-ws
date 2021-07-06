package edu.imi.ir.eduimiws.mapper.pmis;


import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.pmis.ExpenseCodeApiDto;
import edu.imi.ir.eduimiws.models.response.pmis.ExpenseCodeResponse;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ExpenseCodeResponseMapper {

    @Named("toExpenseCodeApiDto")
    @Mappings({
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "description", target = "description"),
            @Mapping(target = "createDateTs", expression = "java(java.sql.Timestamp.valueOf(source.getCreateDateTs()))"),
            @Mapping(source = "expenseCode", target = "expenseCode"),
            @Mapping(source = "expenseCodePublicId", target = "expenseCodePublicId"),
            @Mapping(source = "expenseTitle", target = "expenseTitle"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "creatorPublicId", target = "creatorPublicId"),
            @Mapping(source = "editorPublicId", target = "editorPublicId")
    })
    @BeanMapping(ignoreByDefault = true)
    ExpenseCodeApiDto toExpenseCodeApiDto(ExpenseCodeResponse source, @Context CycleAvoidingMappingContext context);

    @Named("toExpenseCodeResponse")
    @Mappings({
            @Mapping(target = "createDateTs", expression = "java(source.getCreateDateTs().toString())")
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toExpenseCodeApiDto")
    ExpenseCodeResponse toExpenseCodeResponse(ExpenseCodeApiDto source, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toExpenseCodeApiDto")
    List<ExpenseCodeApiDto> toExpenseCodeApiDtos(List<ExpenseCodeResponse> expenseCodeApiEntities, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toExpenseCodeResponse")
    List<ExpenseCodeResponse> toExpenseCodeApiEntities(List<ExpenseCodeApiDto> ExpenseCodeApiDtos, @Context CycleAvoidingMappingContext context);

}
