package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldFastDto;
import edu.imi.ir.eduimiws.models.response.edu.FieldResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FieldResponseFieldFastDtoMapper {

    FieldResponseFieldFastDtoMapper INSTANCE = Mappers
            .getMapper(FieldResponseFieldFastDtoMapper.class);

    @Mappings({
            @Mapping(source = "fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "levelPublicId", target = "levelPublicId"),
            @Mapping(source = "isInternational", target = "isInternational"),
            @Mapping(source = "lastPeriodNumber", target = "lastPeriodNumber"),
            @Mapping(source = "lname", target = "lname"),
            @Mapping(source = "needPermitionForAgancy", target = "needPermitionForAgancy"),
            @Mapping(source = "note", target = "note"),
            @Mapping(source = "punit", target = "punit"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "termicStatus", target = "termicStatus"),
            @Mapping(source = "totalUnit", target = "totalUnit"),
            @Mapping(source = "tunit", target = "tunit"),
            @Mapping(source = "activityStatus", target = "activityStatus"),
            @Mapping(source = "capacity", target = "capacity"),
            @Mapping(source = "certAcceptedPresence", target = "certAcceptedPresence"),
            @Mapping(source = "certBack", target = "certBack"),
            @Mapping(source = "certBackFontSize", target = "certBackFontSize"),
            @Mapping(source = "certBackLineSpacing", target = "certBackLineSpacing"),
            @Mapping(source = "certBirth", target = "certBirth"),
            @Mapping(source = "certContent", target = "certContent"),
            @Mapping(source = "certDate", target = "certDate"),
            @Mapping(source = "certDesc", target = "certDesc"),
            @Mapping(source = "certDescriptFontSize", target = "certDescriptFontSize"),
            @Mapping(source = "certEqui", target = "certEqui"),
            @Mapping(source = "certGoal", target = "certGoal"),
            @Mapping(source = "certLaw", target = "certLaw"),
            @Mapping(source = "certNeedPresence", target = "certNeedPresence"),
            @Mapping(source = "certNeedScore", target = "certNeedScore"),
            @Mapping(source = "certScore", target = "certScore"),
            @Mapping(source = "certSodor", target = "certSodor"),
            @Mapping(source = "certTeachingmethods", target = "certTeachingmethods"),
            @Mapping(source = "certTime", target = "certTime"),
            @Mapping(source = "certTuition", target = "certTuition"),
            @Mapping(source = "certUnit", target = "certUnit"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "examType", target = "examType"),
            @Mapping(source = "fname", target = "fname"),
            @Mapping(source = "foriegnFee", target = "foriegnFee")
    })
    @BeanMapping(ignoreByDefault = true)
    FieldResponse toFieldResponse(FieldFastDto registerFastDto , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldFastDto toFieldFastDto(FieldResponse registerResponse, @Context CycleAvoidingMappingContext context);

    List<FieldResponse> toFieldResponses(List<FieldFastDto> registerFastDtos, @Context CycleAvoidingMappingContext context);

    List<FieldFastDto> toFieldFastDtos(List<FieldResponse> registerResponses, @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleClobFields(FieldFastDto fieldFastDto, @MappingTarget FieldResponse fieldResponse) {

/*        if (fieldFastDto.getTableau() != null) {
            fieldResponse.setTableau(ClobHelper.clobToString(fieldFastDto.getTableau()));
        }
        if (fieldFastDto.getSiteAim() != null) {
            fieldResponse.setSiteAim(ClobHelper.clobToString(fieldFastDto.getSiteAim()));
        }
        if (fieldFastDto.getSiteConditions() != null) {
            fieldResponse.setSiteConditions(ClobHelper.clobToString(fieldFastDto.getSiteConditions()));
        }
        if (fieldFastDto.getSiteContacts() != null) {
            fieldResponse.setSiteContacts(ClobHelper.clobToString(fieldFastDto.getSiteContacts()));
        }
        if (fieldFastDto.getSiteContents() != null) {
            fieldResponse.setSiteContents(ClobHelper.clobToString(fieldFastDto.getSiteContents()));
        }
        if (fieldFastDto.getSiteIntroduction() != null) {
            fieldResponse.setSiteIntroduction(ClobHelper.clobToString(fieldFastDto.getSiteIntroduction()));
        }
        if (fieldFastDto.getSiteRegisterR() != null) {
            fieldResponse.setSiteRegisterR(ClobHelper.clobToString(fieldFastDto.getSiteRegisterR()));
        }
        if (fieldFastDto.getSiteTmethods()!= null) {
            fieldResponse.setSiteTmethods(ClobHelper.clobToString(fieldFastDto.getSiteTmethods()));
        }*/

/*        if (fieldFastDto.getTableau() != null) {
            fieldResponse.setTableau(Arrays.toString(fieldFastDto.getTableau()));
        }
        if (fieldFastDto.getSiteAim() != null) {
            fieldResponse.setSiteAim(Arrays.toString(fieldFastDto.getSiteAim()));
        }
        if (fieldFastDto.getSiteConditions() != null) {
            fieldResponse.setSiteConditions(Arrays.toString(fieldFastDto.getSiteConditions()));
        }
        if (fieldFastDto.getSiteContacts() != null) {
            fieldResponse.setSiteContacts(Arrays.toString(fieldFastDto.getSiteContacts()));
        }
        if (fieldFastDto.getSiteContents() != null) {
            fieldResponse.setSiteContents(Arrays.toString(fieldFastDto.getSiteContents()));
        }
        if (fieldFastDto.getSiteIntroduction() != null) {
            fieldResponse.setSiteIntroduction(Arrays.toString(fieldFastDto.getSiteIntroduction()));
        }
        if (fieldFastDto.getSiteRegisterR() != null) {
            fieldResponse.setSiteRegisterR(Arrays.toString(fieldFastDto.getSiteRegisterR()));
        }
        if (fieldFastDto.getSiteTmethods()!= null) {
            fieldResponse.setSiteTmethods(Arrays.toString(fieldFastDto.getSiteTmethods()));
        }*/
    }

    //    Handle Update FastDto from Response for later use
}
