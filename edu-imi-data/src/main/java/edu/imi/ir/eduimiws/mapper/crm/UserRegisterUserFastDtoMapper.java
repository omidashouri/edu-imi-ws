package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.request.UserRegister;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserRegisterUserFastDtoMapper {

    UserRegisterUserFastDtoMapper INSTANCE = Mappers.getMapper(UserRegisterUserFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "username",target = "username"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "firstName",target = "firstName"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "nationCode",target = "nationCode"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "tel",target = "tel")
    })
    @BeanMapping(ignoreByDefault = true)
    UserFastDto toUserFastDto(UserRegister userRegister, @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    UserRegister toUserRegister(UserFastDto userFastDto, @Context CycleAvoidingMappingContext context);

    List<UserFastDto> toUserFastDtoes(List<UserRegister> userRegisters, @Context CycleAvoidingMappingContext context);

    List<UserRegister> toUserRegister(List<UserFastDto> userFastDtos,@Context CycleAvoidingMappingContext context);

}
