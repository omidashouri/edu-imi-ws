package edu.imi.ir.eduimiws.mapper.sabtahval.config;


import edu.imi.ir.eduimiws.mapper.sabtahval.EstelamResultMapper;
import edu.imi.ir.eduimiws.models.dto.sabtahval.EstelamResult3Dto;
import edu.imi.ir.eduimiws.models.sabtahval.EstelamResult3;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.StringByteArrayAdapter;
import org.mapstruct.*;

@MapperConfig(componentModel = "spring",
        imports = {StringByteArrayAdapter.class},
        uses = {EstelamResultMapper.class},
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EstelamResult3MapperConfig extends Estelam1ResultMapperConfig {

//    Attention:
//              1- method of the implemented interfaces or (Mapper methods) should have same signature to method of config Mapper
//              2- always for the base class in inheritance do not use config mapper
//              3- we cannot inheritance two method from one Interface SO >>
//    IN EstelamResult3Mapper.toEstelamResult3Dto >> inherited 'toEstelamResultDto' from Estelam1ResultMapperConfig
//    IN EstelamResult3Mapper.updateEstelamResult3DtoByteToString >> inherited 'updateEstelamResult3DtoByteToString' from EstelamResult3MapperConfig

    @Named("updateEstelamResult3DtoByteToString")
    @InheritConfiguration(name = "updateEstelamResultDtoByteToString")
    void  updateEstelamResult3DtoByteToString(EstelamResult3 source, @MappingTarget EstelamResult3Dto target) throws Exception;
}
