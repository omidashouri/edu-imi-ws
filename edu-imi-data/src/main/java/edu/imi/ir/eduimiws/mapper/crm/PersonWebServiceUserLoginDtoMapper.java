package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PersonWebServiceDto;
import edu.imi.ir.eduimiws.models.dto.crm.UserLoginDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonWebServiceUserLoginDtoMapper {

    PersonWebServiceUserLoginDtoMapper INSTANCE = Mappers.getMapper(PersonWebServiceUserLoginDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId",target = "personPublicId"),
            @Mapping(source = "contactPublicId",target = "contactPublicId"),
            @Mapping(source = "userName",target = "username"),
            @Mapping(source = "encryptedPassword",target = "encryptedPassword")
    })
    UserLoginDto PersonWebServiceEntityToUserLoginDto(PersonWebServiceEntity personWebServiceEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonWebServiceDto UserLoginDtoToPersonWebServiceEntity(UserLoginDto userLoginDto, @Context CycleAvoidingMappingContext context);

}
