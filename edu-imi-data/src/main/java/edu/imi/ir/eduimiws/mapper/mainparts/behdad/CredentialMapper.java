package edu.imi.ir.eduimiws.mapper.mainparts.behdad;

/*import edu.imi.ir.eduimiws.models.behdad.account.BalanceInfo;
import edu.imi.ir.eduimiws.models.behdad.account.Credential;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.CredentialDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.account.BalanceInfoDto;*/

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CredentialMapper {

 /*
    @Named("toCredentialDto")
    @Mappings({
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "username", target = "username")
    })
    @BeanMapping(ignoreByDefault = true)
    CredentialDto toCredentialDto(Credential credential);


    @Named("toCredential")
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "username", target = "username")

    })
    Credential toCredential(CredentialDto credentialDto);

    @IterableMapping(qualifiedByName = "toCredential")
    List<Credential> toCredentials(List<CredentialDto> credentialDtos);

    @IterableMapping(qualifiedByName = "toCredentialDto")
    List<CredentialDto> toCredentialDtos(List<Credential> credentials);
*/
}
