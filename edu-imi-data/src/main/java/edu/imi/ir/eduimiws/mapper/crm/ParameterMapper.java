package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.ParameterEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.ParameterDto;
import edu.imi.ir.eduimiws.utilities.PersistenceUtils;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ParameterApiMapper.class},
//        imports = {PersistenceUtils.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ParameterMapper {

    @Named("parameterDtoToParameterEntity")
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "paramName",target = "paramName"),
            @Mapping(source = "paramValue",target = "paramValue"),
//            todo: check te result is correct or not → there is a risk for looping
//            todo: or use findById id in service
            @Mapping(source = "mainParamDto",target = "mainParam", qualifiedByName = "resolveMainParam")

    })
    @BeanMapping(ignoreByDefault = true)
    ParameterEntity parameterDtoToParameterEntity(ParameterDto parameterDto, @Context CycleAvoidingMappingContext context);

    @Named("parameterEntityToParameterDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "parameterApi.parameterPublicId", target = "parameterPublicId"),
            @Mapping(source = "paramName", target = "paramName"),
            @Mapping(source = "paramValue", target = "paramValue"),
            @Mapping(source = "mainParam.id", target = "mainParamId"),
            @Mapping(source = "mainParam.parameterApi.parameterPublicId", target = "mainParamPublicId"),
            @Mapping(source = "mainParam", target = "mainParamDto", qualifiedByName = "resolveMainParamDto"),
            @Mapping(source = "parameterApi", target = "parameterApiDto", qualifiedByName = "parameterApiEntityToParameterApiDto")
    })
            @InheritInverseConfiguration(name = "parameterDtoToParameterEntity")
    ParameterDto parameterEntityToParameterDto(ParameterEntity parameterEntity, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "parameterDtoToParameterEntity")
    List<ParameterEntity> toPersonEntities(List<ParameterDto> personTpParameterDtos, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "parameterEntityToParameterDto")
    List<ParameterDto> toParameterDtos(List<ParameterEntity> personEntities, @Context CycleAvoidingMappingContext context);

    @BeforeMapping
    @InheritConfiguration(name = "parameterEntityToParameterDto")
    default void handlePersonApiPublicIds(ParameterEntity parameterEntity,
                                          @MappingTarget ParameterDto parameterDto) {
        new PersistenceUtils().cleanFromProxyByReadMethod(parameterEntity);
    }

    @Named("resolveMainParam")
    default ParameterEntity resolveMainParam(ParameterDto parameterDto){
        return this.parameterDtoToParameterEntity(parameterDto, new CycleAvoidingMappingContext());
    }

    @Named("resolveMainParamDto")
    default ParameterDto resolveMainParamDto(ParameterEntity parameterEntity){
        return this.parameterEntityToParameterDto(parameterEntity, new CycleAvoidingMappingContext());
    }

}
