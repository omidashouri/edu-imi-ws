package edu.imi.ir.eduimiws.mapper.mainparts.melli;

import edu.imi.ir.eduimiws.models.dto.mainparts.MelliVerifyDto;
import edu.imi.ir.eduimiws.models.request.melli.v1.VerifyRequestBank;
import edu.imi.ir.eduimiws.utilities.MelliTripleDes;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface VerifyRequestBankMapper {

    @Named("melliVerifyDtoToVerifyRequestBank")
    @Mappings({
            @Mapping(target = "signData", expression = "java(melliTripleDes.encrypt(source.getToken()))"),
            @Mapping(source = "token", target = "token")
    })
    @BeanMapping(ignoreByDefault = true)
    VerifyRequestBank melliVerifyDtoToVerifyRequestBank(MelliVerifyDto source,
                                                        @Context MelliTripleDes melliTripleDes);

    @Named("verifyRequestBankToMelliVerifyDto")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "melliVerifyDtoToVerifyRequestBank")
    MelliVerifyDto verifyRequestBankToMelliVerifyDto(VerifyRequestBank source,
                                                     @Context MelliTripleDes melliTripleDes);
}
