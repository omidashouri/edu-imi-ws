package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.request.UserRegister;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserRegisterUserFastDtoMapper {

    UserRegisterUserFastDtoMapper INSTANCE = Mappers.getMapper(UserRegisterUserFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "nationCode",target = "username"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "firstName",target = "firstName"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "nationCode",target = "nationCode"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "tel",target = "tel")
    })
    UserFastDto toUserFastDto(UserRegister userRegister, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    UserRegister toUserRegister(UserFastDto userFastDto, @Context CycleAvoidingMappingContext context);

    List<UserFastDto> toUserFastDtoes(List<UserRegister> userRegisters, @Context CycleAvoidingMappingContext context);

    List<UserRegister> toUserRegister(List<UserFastDto> userFastDtos,@Context CycleAvoidingMappingContext context);

}
