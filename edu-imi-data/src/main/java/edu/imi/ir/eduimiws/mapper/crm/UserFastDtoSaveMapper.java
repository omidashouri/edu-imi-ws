package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserFastDtoSaveMapper {

    UserFastDtoSaveMapper INSTANCE = Mappers.getMapper(UserFastDtoSaveMapper.class);

    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "tel", target = "tel"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "address", target = "address")
    })
    PersonEntity toPersonForSaveFromUserRegister(UserFastDto userFastDto);


    @Mappings({
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "tel", target = "mobilePhone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(defaultValue = "public", target = "accessType"),
    })
    ContactEntity toContactForSaveFromUserRegister(UserFastDto userFastDto);

/*    @BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    void toPersonWebServiceEntity(UserFastDto userFastDto, @MappingTarget PersonWebServiceEntity personWebService);*/

}
