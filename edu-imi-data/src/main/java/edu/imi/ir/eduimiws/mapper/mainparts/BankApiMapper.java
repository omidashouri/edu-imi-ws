package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.domain.mainparts.BankApiEntity;
import edu.imi.ir.eduimiws.domain.mainparts.PaymentCodeApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ExpenseCodeApiFastMapper;
import edu.imi.ir.eduimiws.mapper.pmis.ProjectFastMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.BankApiDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.PaymentCodeApiDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {PersonMapper.class},
        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BankApiMapper {

    @Named("toBankApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "bankPublicId", target = "bankPublicId"),
            @Mapping(source = "bankName", target = "bankName"),
            @Mapping(source = "bankCode", target = "bankCode"),
            @Mapping(source = "creator", target = "creator", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "creator.personApiEntity.personPublicId", target = "creatorPublicId"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "editor", target = "editor", qualifiedByName = "personEntityToPersonDto"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "editor.personApiEntity.personPublicId", target = "editorPublicId"),
            @Mapping(source = "description", target = "description")
    })
    @BeanMapping(ignoreByDefault = true)
    BankApiDto toBankApiDto(BankApiEntity BankApiEntity,
                            @Context CycleAvoidingMappingContext context);

    @Named("toBankApiEntity")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "bankName", target = "bankName"),
            @Mapping(source = "bankCode", target = "bankCode"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "creator", target = "creator", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "editor", target = "editor", qualifiedByName = "personDtoToPersonEntity"),
            @Mapping(source = "description", target = "description")
    })
    @BeanMapping(ignoreByDefault = true)
    BankApiEntity toBankApiEntity(BankApiDto BankApiDto,
                                  @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toBankApiDto")
    List<BankApiDto> toBankApiDtos(List<BankApiEntity> BankApiEntities,
                                   @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toBankApiEntity")
    List<BankApiEntity> toBankApiEntities(List<BankApiDto> BankApiDtos,
                                          @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "toBankApiDto")
    default void handleBankApiPublicIds(BankApiEntity bankApiEntity,
                                        @MappingTarget BankApiDto bankApiDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(bankApiEntity);
    }
}
