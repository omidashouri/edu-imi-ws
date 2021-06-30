package edu.imi.ir.eduimiws.mapper.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.EstelamResult3Dto;
import edu.imi.ir.eduimiws.models.response.sabtahval.EstelamResultResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EstelamResultResponseMapper {

    @Named("toEstelamResultResponse")
    @Mappings({
            @Mapping(source = "birthDate", target = "birthDate"),
            @Mapping(source = "bookNo", target = "bookNo"),
            @Mapping(source = "bookRow", target = "bookRow"),
            @Mapping(source = "deathDate", target = "deathDate"),
            @Mapping(source = "deathStatus", target = "deathStatus"),
            @Mapping(source = "exceptionMessage", target = "exceptionMessage"),
            @Mapping(source = "familyString", target = "family"),
            @Mapping(source = "fatherNameString", target = "fatherName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "messages", target = "messages"),
            @Mapping(source = "nameString", target = "name"),
            @Mapping(source = "nin", target = "nin"),
            @Mapping(source = "officeCode", target = "officeCode"),
            @Mapping(source = "officeNameString", target = "officeName"),
            @Mapping(source = "shenasnameNo", target = "shenasnameNo"),
            @Mapping(source = "shenasnameSeriString", target = "shenasnameSeri"),
            @Mapping(source = "shenasnameSerial", target = "shenasnameSerial")
    })
    @BeanMapping(ignoreByDefault = true)
    EstelamResultResponse toEstelamResultResponse(EstelamResult3Dto source,
                                                  @Context CycleAvoidingMappingContext context);

    @Named("estelamResultResponseToEstelamResult3Dto")
    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration(name = "toEstelamResultResponse")
    EstelamResult3Dto toEstelamResult3Dto(EstelamResultResponse source, @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "toEstelamResultResponse")
    List<EstelamResultResponse> toEstelamResultResponses(List<EstelamResult3Dto> estelamResult3Dtos,
                                                         @Context CycleAvoidingMappingContext context);

    @IterableMapping(qualifiedByName = "estelamResultResponseToEstelamResult3Dto")
    List<EstelamResult3Dto> toEstelamResult3Dtos(List<EstelamResultResponse> sources,
                                                 @Context CycleAvoidingMappingContext context);
}
