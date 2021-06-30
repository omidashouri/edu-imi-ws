package edu.imi.ir.eduimiws.mapper.sabtahval.config;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.EstelamResultDto;
import edu.imi.ir.eduimiws.models.sabtahval.EstelamResult;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.StringByteArrayAdapter;
import org.mapstruct.*;

@MapperConfig(componentModel = "spring",
        imports = {StringByteArrayAdapter.class},
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface Estelam0ResultDtoConfig {

    @Named("toEstelamResultDto")
    @Mappings({
            @Mapping(source = "birthDate", target = "birthDate"),
            @Mapping(source = "bookNo", target = "bookNo"),
            @Mapping(source = "bookRow", target = "bookRow"),
            @Mapping(source = "deathStatus", target = "deathStatus"),
            @Mapping(source = "family", target = "family"),
            @Mapping(source = "fatherName", target = "fatherName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "messages", target = "messages"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "nin", target = "nin"),
            @Mapping(source = "officeCode", target = "officeCode"),
            @Mapping(source = "officeName", target = "officeName"),
            @Mapping(source = "shenasnameNo", target = "shenasnameNo"),
            @Mapping(source = "shenasnameSeri", target = "shenasnameSeri"),
            @Mapping(source = "shenasnameSerial", target = "shenasnameSerial"),
            @Mapping(target = "familyString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getFamily()))"),
            @Mapping(target = "fatherNameString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getFatherName()))"),
            @Mapping(target = "nameString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getName()))"),
            @Mapping(target = "officeNameString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getOfficeName()))"),
            @Mapping(target = "shenasnameSeriString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getShenasnameSeri()))")
    })
    @BeanMapping(ignoreByDefault = true)
    EstelamResultDto toEstelamResultDto(EstelamResult source, @Context CycleAvoidingMappingContext context) throws Exception;


}
