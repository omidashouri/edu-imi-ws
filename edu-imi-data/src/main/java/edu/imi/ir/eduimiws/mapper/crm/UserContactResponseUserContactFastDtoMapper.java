package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.UserContactFastDto;
import edu.imi.ir.eduimiws.models.response.UserContactResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserContactResponseUserContactFastDtoMapper {


    UserContactResponseUserContactFastDtoMapper INSTANCE = Mappers.getMapper(UserContactResponseUserContactFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "userContactResponseDto.firstName",target = "firstName"),
            @Mapping(source = "userContactResponseDto.lastName",target = "lastName"),
            @Mapping(source = "userContactResponseDto.mobilePhone",target = "mobilePhone"),
            @Mapping(source = "userContactResponseDto.email",target = "email"),
            @Mapping(source = "userContactResponseDto.gender",target = "gender"),
            @Mapping(source = "userContactResponseDto.birthdate",target = "birthdate"),
            @Mapping(source = "userContactResponseDto.fromCity",target = "fromCity"),
            @Mapping(source = "userContactResponseDto.nationCode",target = "nationCode"),
            @Mapping(source = "userContactResponseDto.fatherName",target = "fatherName"),
            @Mapping(source = "userContactResponseDto.description",target = "description"),
            @Mapping(source = "userContactResponseDto.address",target = "address"),
            @Mapping(source = "userContactResponseDto.lfirstName",target = "lfirstName"),
            @Mapping(source = "userContactResponseDto.llastName",target = "llastName"),
            @Mapping(source = "userContactResponseDto.postalCode",target = "postalCode"),
            @Mapping(source = "userContactResponseDto.lfatherName",target = "lfatherName"),
            @Mapping(source = "userContactResponseDto.lfromCity",target = "lfromCity")
    })
    UserContactResponse UserContactFastDtoToUserContactResponse(UserContactFastDto userContactFastDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    UserContactFastDto UserContactResponseToUserContactFastDto(UserContactResponse userContactResponse, @Context CycleAvoidingMappingContext context);


    List<UserContactResponse> UserContactFastDtoToUserContactResponses(List<UserContactFastDto> userContactFastDtos,@Context CycleAvoidingMappingContext context);

    List<UserContactFastDto> UserContactResponseToUserContactFastDtos(List<UserContactResponse> userContactResponses,@Context CycleAvoidingMappingContext context);


}
