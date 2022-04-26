package edu.imi.ir.eduimiws.mapper.mainparts.hamkaran;


import edu.imi.ir.eduimiws.models.dto.hamkaran.HamkaranHumanResourceDataDto;
import edu.imi.ir.eduimiws.models.response.hamkaran.v1.HamkaranHumanResourceData;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface HamkaranHumanResourceDataMapper {

    @Named("toHamkaranHumanResourceDataDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "shomareMostakhdem", target = "shomareMostakhdem"),
            @Mapping(source = "shomarePersoneli", target = "shomarePersoneli"),
            @Mapping(source = "codeMelli", target = "codeMelli"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "employeeId", target = "employeeId"),
            @Mapping(source = "mablaghePaeinHokm", target = "mablaghePaeinHokm"),
            @Mapping(source = "shoghlId", target = "shoghlId"),
            @Mapping(source = "shoghl", target = "shoghl"),
            @Mapping(source = "noeGharardadId", target = "noeGharardadId"),
            @Mapping(source = "noeGharardad", target = "noeGharardad"),
            @Mapping(source = "postId", target = "postId"),
            @Mapping(source = "post", target = "post"),
            @Mapping(source = "gorouhId", target = "gorouhId"),
            @Mapping(source = "gorouh", target = "gorouh"),
            @Mapping(source = "confirmDate", target = "confirmDate"),
            @Mapping(source = "confirmDateShamsi", target = "confirmDateShamsi"),
            @Mapping(source = "noeHokmId", target = "noeHokmId"),
            @Mapping(source = "noeHokm", target = "noeHokm"),
            @Mapping(source = "departmentId", target = "departmentId"),
            @Mapping(source = "departmentTitle", target = "departmentTitle"),
            @Mapping(source = "lastCreateDate", target = "lastCreateDate"),
            @Mapping(source = "lastEditDate", target = "lastEditDate"),
            @Mapping(source = "karkardeSaati", target = "karkardeSaati")
    })
    @BeanMapping(ignoreByDefault = true)
    HamkaranHumanResourceDataDto toHamkaranHumanResourceDataDto(HamkaranHumanResourceData source);

    @Named("toHamkaranHumanResourceData")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toHamkaranHumanResourceDataDto")
    HamkaranHumanResourceData toHamkaranHumanResourceData(HamkaranHumanResourceDataDto source);


    @Named("toHamkaranHumanResourceDataDtoes")
    @IterableMapping(qualifiedByName = "toHamkaranHumanResourceDataDto")
    List<HamkaranHumanResourceDataDto> toHamkaranHumanResourceDataDtoes(List<HamkaranHumanResourceData> sources);

    @Named("toHamkaranHumanResourceDatas")
    @IterableMapping(qualifiedByName = "toHamkaranHumanResourceData")
    List<HamkaranHumanResourceData> toHamkaranHumanResourceDatas(List<HamkaranHumanResourceDataDto> sources);

}
