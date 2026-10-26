package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.models.dto.crm.AuthTokenDto;
import edu.imi.ir.eduimiws.models.response.crm.AuthTokenResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AuthTokenResponseMapper {

    @Mappings({
            @Mapping(source = "accessToken", target = "accessToken"),
            @Mapping(source = "refreshToken", target = "refreshToken"),
            @Mapping(source = "userPublicId", target = "userPublicId"),
            @Mapping(source = "tokenType", target = "tokenType"),
            @Mapping(source = "accessTokenExpiresIn", target = "accessTokenExpiresIn"),
            @Mapping(source = "refreshTokenExpiresIn", target = "refreshTokenExpiresIn")
    })
    @BeanMapping(ignoreByDefault = true)
    AuthTokenResponse toAuthTokenResponse(AuthTokenDto authTokenDto);
}
