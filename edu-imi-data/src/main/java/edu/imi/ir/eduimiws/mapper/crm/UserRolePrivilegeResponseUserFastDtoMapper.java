package edu.imi.ir.eduimiws.mapper.crm;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.crm.RoleFastDto;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.models.response.crm.UserRolePrivilegeResponse;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper
public interface UserRolePrivilegeResponseUserFastDtoMapper {

    UserRolePrivilegeResponseUserFastDtoMapper INSTANCE = Mappers.getMapper(UserRolePrivilegeResponseUserFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "personPublicId", target = "personPublicId"),
            @Mapping(source = "contactPublicId", target = "contactPublicId"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationCode", target = "nationCode"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "roleFastDtos", target = "roleResponses")
    })
    @BeanMapping(ignoreByDefault = true)
    UserRolePrivilegeResponse toUserRolePrivilegeResponse(UserFastDto userFastDto,
                                                          @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    @BeanMapping(ignoreByDefault = true)
    UserFastDto toUserFastDto(UserRolePrivilegeResponse userRolePrivilegeResponse,
                              @Context CycleAvoidingMappingContext context);

    List<UserRolePrivilegeResponse> toUserRolePrivilegeResponses(List<UserFastDto> userFastDtos,
                                                                 @Context CycleAvoidingMappingContext context);

    List<UserFastDto> toUserFastDtos(List<UserRolePrivilegeResponse> userRolePrivilegeResponses,
                                     @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleUserPrivileges(UserFastDto userFastDto, @MappingTarget UserRolePrivilegeResponse userRolePrivilegeResponse) {

        if (!Hibernate.isInitialized(userFastDto.getRoleFastDtos())) {
            userFastDto.setRoleFastDtos(null);
        }
        if (userFastDto.getRoleFastDtos() != null &&
                userFastDto.getRoleFastDtos().size()>0 ) {
            List<UserFastDto> noNullRolePrivilegeUserFastDtos = Stream.of(userFastDto)
                    .filter(r1->r1
                            .getRoleFastDtos()
                            .iterator()
                            .next()
                            .getPrivilegeFastDtos() !=null)
                    .filter(r2->r2
                            .getRoleFastDtos()
                            .iterator()
                            .next()
                            .getPrivilegeFastDtos().size()>0)
                    .distinct()
                    .collect(Collectors.toList());

            List<RoleFastDto> roleFastDtos = noNullRolePrivilegeUserFastDtos
                    .stream()
                    .map(UserFastDto::getRoleFastDtos)
                    .flatMap(Collection::stream)
                    .distinct()
                    .collect(Collectors.toList());
            userRolePrivilegeResponse.setRoleResponses(
                    new RoleResponseRoleFastDtoMapperImpl()
                    .toRoleResponses(roleFastDtos,new CycleAvoidingMappingContext()));
        }

    }



}
