package edu.imi.ir.eduimiws.mapper;

import edu.imi.ir.eduimiws.models.dto.UserContactFastDto;
import edu.imi.ir.eduimiws.models.response.UserContactResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserContactResponseMapper {


    UserContactResponseMapper INSTANCE = Mappers.getMapper(UserContactResponseMapper.class);

    @Mappings({
            @Mapping(source = "contactFastDto.contactPublicId",target = "contactPublicId"),
            @Mapping(source = "contactFastDto.firstName",target = "firstName"),
            @Mapping(source = "contactFastDto.lastName",target = "lastName"),
            @Mapping(source = "contactFastDto.mobilePhone",target = "mobilePhone"),
            @Mapping(source = "contactFastDto.email",target = "email"),
            @Mapping(source = "contactFastDto.gender",target = "gender"),
            @Mapping(source = "contactFastDto.birthdate",target = "birthdate"),
            @Mapping(source = "contactFastDto.fromCity",target = "fromCity"),
            @Mapping(source = "contactFastDto.nationCode",target = "nationCode"),
            @Mapping(source = "contactFastDto.fatherName",target = "fatherName"),
            @Mapping(source = "contactFastDto.description",target = "description"),
            @Mapping(source = "contactFastDto.address",target = "address"),
            @Mapping(source = "contactFastDto.lfirstName",target = "lfirstName"),
            @Mapping(source = "contactFastDto.llastName",target = "llastName"),
            @Mapping(source = "contactFastDto.postalCode",target = "postalCode"),
            @Mapping(source = "contactFastDto.lfatherName",target = "lfatherName"),
            @Mapping(source = "contactFastDto.lfromCity",target = "lfromCity")
    })
    UserContactResponse UserContactFastDtoToUserContactResponse(UserContactFastDto userContactFastDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    UserContactFastDto UserContactResponseToUserContactFastDto(UserContactResponse userContactResponse, @Context CycleAvoidingMappingContext context);



}
