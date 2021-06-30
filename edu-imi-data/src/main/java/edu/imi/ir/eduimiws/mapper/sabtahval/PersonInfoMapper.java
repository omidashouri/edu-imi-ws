package edu.imi.ir.eduimiws.mapper.sabtahval;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.sabtahval.PersonInfoDto;
import edu.imi.ir.eduimiws.models.sabtahval.PersonInfo;
import edu.imi.ir.eduimiws.models.sabtahval.adapter.StringByteArrayAdapter;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        imports = {StringByteArrayAdapter.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PersonInfoMapper {

    PersonInfoMapper INSTANCE = Mappers.getMapper(PersonInfoMapper.class);
    @Mappings({
            @Mapping(source = "birthDate", target = "birthDate"),
            @Mapping(source = "bookNo", target = "bookNo"),
            @Mapping(source = "bookRow", target = "bookRow"),
            @Mapping(source = "dateHasPostfix", target = "dateHasPostfix"),
            @Mapping(source = "family", target = "family"),
            @Mapping(source = "familyHasPerfix", target = "familyHasPerfix"),
            @Mapping(source = "familyHasPostfix", target = "familyHasPostfix"),
            @Mapping(source = "fatherName", target = "fatherName"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "nameHasPerfix", target = "nameHasPerfix"),
            @Mapping(source = "nameHasPostfix", target = "nameHasPostfix"),
            @Mapping(source = "nin", target = "nin"),
            @Mapping(source = "officeCode", target = "officeCode"),
            @Mapping(source = "officeName", target = "officeName"),
            @Mapping(source = "shenasnameNo", target = "shenasnameNo"),
            @Mapping(source = "shenasnameSeri", target = "shenasnameSeri"),
            @Mapping(source = "shenasnameSerial", target = "shenasnameSerial"),
            @Mapping(target = "familyString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "personInfo.getFamily()))"),
            @Mapping(target = "fatherNameString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "personInfo.getFatherName()))"),
            @Mapping(target = "nameString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "personInfo.getName()))"),
            @Mapping(target = "officeNameString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "personInfo.getOfficeName()))"),
            @Mapping(target = "shenasnameSeriString",expression = "java(new StringByteArrayAdapter().marshal(" +
                    "personInfo.getShenasnameSeri()))")

    })
    @BeanMapping(ignoreByDefault = true)
    PersonInfoDto toPersonInfoDto(PersonInfo personInfo, @Context CycleAvoidingMappingContext context) throws Exception;

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    PersonInfo toPersonInfo(PersonInfoDto personInfoDto, @Context CycleAvoidingMappingContext context);

    List<PersonInfo> toPersonInfo(List<PersonInfoDto> PersonInfoDtos, @Context CycleAvoidingMappingContext context);

    List<PersonInfoDto> toPersonInfoDtos(List<PersonInfo> personInfos, @Context CycleAvoidingMappingContext context) throws Exception;
}
