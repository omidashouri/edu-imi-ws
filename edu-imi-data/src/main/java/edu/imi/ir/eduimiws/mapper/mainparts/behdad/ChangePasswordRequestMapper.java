package edu.imi.ir.eduimiws.mapper.mainparts.behdad;


/*import edu.imi.ir.eduimiws.domain.crm.MessageEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.mapper.crm.MessageApiMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.models.behdad.account.ChangePasswordRequest;
import edu.imi.ir.eduimiws.models.dto.crm.MessageDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.ChangePasswordRequestDto;
import edu.imi.ir.eduimiws.services.crm.MessageApiService;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ChangePasswordRequestMapper {
/*

    @Named("toChangePasswordRequestDto")
    @Mappings({
            @Mapping(source = "newPassword", target = "newPassword"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "username", target = "username")
    })
    @BeanMapping(ignoreByDefault = true)
    ChangePasswordRequestDto toChangePasswordRequestDto(ChangePasswordRequest ChangePasswordRequest);


    @Named("toChangePasswordRequest")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "newPassword", target = "newPassword"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "username", target = "username")

    })
    ChangePasswordRequest toChangePasswordRequest(ChangePasswordRequestDto ChangePasswordRequestDto);

    @IterableMapping(qualifiedByName = "toChangePasswordRequest")
    List<ChangePasswordRequest> toChangePasswordRequests(List<ChangePasswordRequestDto> ChangePasswordRequestDtos);

    @IterableMapping(qualifiedByName = "toChangePasswordRequestDto")
    List<ChangePasswordRequestDto> toChangePasswordRequestDtos(List<ChangePasswordRequest> ChangePasswordRequests);
*/

}
