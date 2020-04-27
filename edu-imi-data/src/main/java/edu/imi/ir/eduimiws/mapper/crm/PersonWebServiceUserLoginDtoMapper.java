package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.PersonApiDto;
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
    UserLoginDto PersonWebServiceEntityToUserLoginDto(PersonApiEntity personApiEntity, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    PersonApiDto UserLoginDtoToPersonWebServiceEntity(UserLoginDto userLoginDto, @Context CycleAvoidingMappingContext context);

}
