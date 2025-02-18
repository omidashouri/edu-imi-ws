package edu.imi.ir.eduimiws.mapper.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.GetEstelam3ResponseDto;
import edu.imi.ir.eduimiws.models.wsdl.sabtahval.GetEstelam3Response;
import org.mapstruct.*;


@Mapper(componentModel = "spring",
        uses = {EstelamResult3Mapper.class},
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface GetEstelam3ResponseMapper {


/*
    @Named("toEstelamResultDto")
    @Mappings({
            @Mapping(source = "birthDate", target = "birthDate"),
            @Mapping(source = "bookNo", target = "bookNo"),
            @Mapping(source = "bookRow", target = "bookRow"),
            @Mapping(source = "deathStatus", target = "deathStatus"),
            @Mapping(source = "family", target = "family"),
            @Mapping(source = "fatherName", target = "fatherName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "messages", target = "messages"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "nin", target = "nin"),
            @Mapping(source = "officeCode", target = "officeCode"),
            @Mapping(source = "officeName", target = "officeName"),
            @Mapping(source = "shenasnameNo", target = "shenasnameNo"),
            @Mapping(source = "shenasnameSeri", target = "shenasnameSeri"),
            @Mapping(source = "shenasnameSerial", target = "shenasnameSerial"),
            @Mapping(target = "familyString", expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getFamily()))"),
            @Mapping(target = "fatherNameString", expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getFatherName()))"),
            @Mapping(target = "nameString", expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getName()))"),
            @Mapping(target = "officeNameString", expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getOfficeName()))"),
            @Mapping(target = "shenasnameSeriString", expression = "java(new StringByteArrayAdapter().marshal(" +
                    "source.getShenasnameSeri()))")
    })
    @BeanMapping(ignoreByDefault = true)
    EstelamResultDto toEstelamResultDto(EstelamResult source, @Context CycleAvoidingMappingContext context) throws Exception;


    @Named("toEstelamResult3Dto")
    @Mappings({
            @Mapping(source = "deathDate", target = "deathDate"),
            @Mapping(source = "exceptionMessage", target = "exceptionMessage")
    })
    @BeanMapping(ignoreByDefault = true)
    @InheritConfiguration(name = "toEstelamResultDto")
    EstelamResult3Dto toEstelamResult3Dto(EstelamResult3 source, @Context CycleAvoidingMappingContext context) throws Exception;


    @Named("toEstelamResult3Dtos")
    @IterableMapping(qualifiedByName = "toEstelamResult3Dto")
    List<EstelamResult3Dto> toEstelamResult3Dtos(List<EstelamResult3> sources, @Context CycleAvoidingMappingContext context) throws Exception;

*/

// Attention:
//    uses = {EstelamResult3Mapper.class} AND @Named("toEstelamResult3Dtos") in 'EstelamResult3Mapper' is essential

    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "returns", target = "returns", qualifiedByName = "toEstelamResult3Dtos")
    })
    GetEstelam3ResponseDto toGetEstelam3ResponseDto(GetEstelam3Response source, @Context CycleAvoidingMappingContext context) throws Exception;

}
