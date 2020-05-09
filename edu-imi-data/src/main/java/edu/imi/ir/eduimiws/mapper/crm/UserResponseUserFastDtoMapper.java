package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.response.crm.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserResponseUserFastDtoMapper {

    UserResponseUserFastDtoMapper INSTANCE = Mappers.getMapper(UserResponseUserFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId",target = "personPublicId"),
            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "description",target = "description"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "emailProcessType",target = "emailProcessType"),
            @Mapping(source = "emailVerificationStatus",target = "emailVerificationStatus"),
            @Mapping(source = "emailVerificationToken",target = "emailVerificationToken"),
            @Mapping(source = "encryptedPassword",target = "encryptedPassword"),
            @Mapping(source = "firstName",target = "firstName"),
            @Mapping(source = "kind",target = "kind"),
            @Mapping(source = "lastlogindate",target = "lastlogindate"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "limitationNumber",target = "limitationNumber"),
            @Mapping(source = "mobileVerificationStatus",target = "mobileVerificationStatus"),
            @Mapping(source = "noeEstekhdam",target = "noeEstekhdam"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "personalCode",target = "personalCode"),
            @Mapping(source = "pwdp",target = "pwdp"),
            @Mapping(source = "selectedSkin",target = "selectedSkin"),
            @Mapping(source = "signature",target = "signature"),
            @Mapping(source = "signatureImg",target = "signatureImg"),
            @Mapping(source = "tel",target = "tel"),
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "website",target = "website"),
            @Mapping(source = "activityStatus",target = "activityStatus"),
            @Mapping(source = "address",target = "address")
    })
    @BeanMapping(ignoreByDefault = true)
    UserResponse toUserResponse(UserFastDto userFastDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    @BeanMapping(ignoreByDefault = true)
    UserFastDto toUserFastDto(UserResponse userResponse, @Context CycleAvoidingMappingContext context);

    List<UserResponse> toUserResponses(List<UserFastDto> userFastDtos, @Context CycleAvoidingMappingContext context);

    List<UserFastDto> toUserFastDtos(List<UserResponse> userResponses,@Context CycleAvoidingMappingContext context);


}
