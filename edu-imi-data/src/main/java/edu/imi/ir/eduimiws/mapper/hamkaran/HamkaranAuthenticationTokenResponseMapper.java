package edu.imi.ir.eduimiws.mapper.hamkaran;

import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranAuthenticationTokenDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranAuthenticationTokenResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranAuthenticationTokenResponseMapper {


            @Named("hamkaranAuthenticationTokenResponseToDto")
            @Mappings({
                    @Mapping(source = "success", target = "success"),
                    @Mapping(source = "token", target = "token"),
                    @Mapping(source = "message", target = "message")

            })
            @BeanMapping(ignoreByDefault = true)
            HamkaranAuthenticationTokenDto hamkaranAuthenticationTokenResponseToDto(HamkaranAuthenticationTokenResponse source);

            @Named("hamkaranAuthenticationTokenDtoToResponse")
            @BeanMapping(ignoreByDefault = true)
            @InheritInverseConfiguration(name = "hamkaranAuthenticationTokenResponseToDto")
            HamkaranAuthenticationTokenResponse hamkaranAuthenticationTokenDtoToResponse(HamkaranAuthenticationTokenDto source);

    @Mappings({
            @Mapping(source = "success", target = "success"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "message", target = "message")
    })
    @BeanMapping(ignoreByDefault = true)
    void updateHamkaranAuthenticationTokenDtoByHamkaranAuthenticationTokenResponse(@MappingTarget HamkaranAuthenticationTokenDto target,
                                                                                   HamkaranAuthenticationTokenResponse source);


}
