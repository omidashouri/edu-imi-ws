package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;


import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranLinkDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranLink;
import org.mapstruct.*;

import java.util.List;

@Named("HamkaranLinkMapper")
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranLinkMapper {

    @Named("hamkaranLinkToHamkaranLinkDto")
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "href", target = "href")
    })
    @BeanMapping(ignoreByDefault = true)
    HamkaranLinkDto hamkaranLinkToHamkaranLinkDto(HamkaranLink source);

    @Named("hamkaranLinkDtoToHamkaranLink")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "hamkaranLinkToHamkaranLinkDto")
    HamkaranLink hamkaranLinkDtoToHamkaranLink(HamkaranLinkDto source);


    @Named("hamkaranLinksToHamkaranLinkDtoes")
    @IterableMapping(qualifiedByName = "hamkaranLinkToHamkaranLinkDto")
    List<HamkaranLinkDto> hamkaranLinksToHamkaranLinkDtoes(List<HamkaranLink> sources);

    @Named("hamkaranLinkDtosToHamkaranLinkes")
    @IterableMapping(qualifiedByName = "hamkaranLinkDtoToHamkaranLink")
    List<HamkaranLink> hamkaranLinkDtosToHamkaranLinkes(List<HamkaranLinkDto> sources);

}
