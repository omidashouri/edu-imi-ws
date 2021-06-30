package edu.imi.ir.eduimiws.mapper.sabtahval.config;

import edu.imi.ir.eduimiws.models.dto.sabtahval.EstelamResultDto;
import edu.imi.ir.eduimiws.models.sabtahval.EstelamResult;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.StringByteArrayAdapter;
import org.mapstruct.*;

@MapperConfig(componentModel = "spring",
        imports = {StringByteArrayAdapter.class},
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface Estelam0ResultDtoByteToStringConfig {

    @Named("updateEstelamResultDtoByteToString")
    @Mappings({
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
    void  updateEstelamResultDtoByteToString(EstelamResult source, @MappingTarget EstelamResultDto target) throws Exception;
}
