package edu.imi.ir.eduimiws.mapper.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.sabtahval.config.EstelamResult3MapperConfig;
import edu.imi.ir.eduimiws.models.dto.sabtahval.EstelamResult3Dto;
import edu.imi.ir.eduimiws.models.wsdl.sabtahval.EstelamResult3;
import lombok.SneakyThrows;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        config = EstelamResult3MapperConfig.class)
public interface EstelamResult3Mapper  {


    @Named("toEstelamResult3Dto")
    @Mappings({
            @Mapping(source = "deathDate", target = "deathDate"),
            @Mapping(source = "exceptionMessage", target = "exceptionMessage")
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritConfiguration(name = "toEstelamResultDto")
    EstelamResult3Dto toEstelamResult3Dto(EstelamResult3 source, @Context CycleAvoidingMappingContext context) throws Exception;

    @Named("toEstelamResult3")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toEstelamResult3Dto")
    EstelamResult3 toEstelamResult3(EstelamResult3Dto estelamResult3Dto, @Context CycleAvoidingMappingContext context)throws Exception;

    @Named("toEstelamResult3s")
    @IterableMapping(qualifiedByName = "toEstelamResult3")
    List<EstelamResult3> toEstelamResult3s(List<EstelamResult3Dto> EstelamResult3Dtos, @Context CycleAvoidingMappingContext context)throws Exception;

    @Named("toEstelamResult3Dtos")
    @IterableMapping(qualifiedByName = "toEstelamResult3Dto")
    List<EstelamResult3Dto> toEstelamResult3Dtos(List<EstelamResult3> sources, @Context CycleAvoidingMappingContext context) throws Exception;



    @InheritConfiguration(name = "updateEstelamResult3DtoByteToString")
    void updateEstelamResult3DtoByteToString(EstelamResult3 source, @MappingTarget EstelamResult3Dto target) throws Exception;

}
