package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldDto;
import edu.imi.ir.eduimiws.models.response.edu.FieldResponse;
import org.hibernate.Hibernate;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FieldResponseFieldDtoMapper {

    FieldResponseFieldDtoMapper INSTANCE = Mappers
            .getMapper(FieldResponseFieldDtoMapper.class);

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
    FieldResponse toFieldResponse(FieldDto fieldDto
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldDto toFieldDto(FieldResponse fieldResponse
            , @Context CycleAvoidingMappingContext context);

    List<FieldResponse> toFieldResponses(List<FieldDto> fieldDtos,
                                         @Context CycleAvoidingMappingContext context);

    List<FieldDto> toFieldDtos(List<FieldResponse> fieldResponses,
                              @Context CycleAvoidingMappingContext context);

    @AfterMapping
    default void handleClobFieldsLevelTitleEduCategoryTitle(FieldDto fieldDto, @MappingTarget FieldResponse fieldResponse) {

        if(!Hibernate.isInitialized(fieldDto.getLevel())) {
            fieldDto.setLevel(null);
        }

        if(!Hibernate.isInitialized(fieldDto.getEduCategory())) {
            fieldDto.setEduCategory(null);
        }

        if(fieldDto.getLevel()!=null){
          fieldResponse.setLevelDescription(fieldDto.getLevel().getDescription());
        }

        if(fieldDto.getEduCategory()!=null){
            fieldResponse.setEduCategoryTitle(fieldDto.getEduCategory().getTitle());
        }

        /*if (fieldDto.getTableau() != null) {
            fieldResponse.setTableau(ClobHelper.clobToString(fieldDto.getTableau()));
        }
        if (fieldDto.getSiteAim() != null) {
            fieldResponse.setSiteAim(ClobHelper.clobToString(fieldDto.getSiteAim()));
        }
        if (fieldDto.getSiteConditions() != null) {
            fieldResponse.setSiteConditions(ClobHelper.clobToString(fieldDto.getSiteConditions()));
        }
        if (fieldDto.getSiteContacts() != null) {
            fieldResponse.setSiteContacts(ClobHelper.clobToString(fieldDto.getSiteContacts()));
        }
        if (fieldDto.getSiteContents() != null) {
            fieldResponse.setSiteContents(ClobHelper.clobToString(fieldDto.getSiteContents()));
        }
        if (fieldDto.getSiteIntroduction() != null) {
            fieldResponse.setSiteIntroduction(ClobHelper.clobToString(fieldDto.getSiteIntroduction()));
        }
        if (fieldDto.getSiteRegisterR() != null) {
            fieldResponse.setSiteRegisterR(ClobHelper.clobToString(fieldDto.getSiteRegisterR()));
        }
        if (fieldDto.getSiteTmethods()!= null) {
            fieldResponse.setSiteTmethods(ClobHelper.clobToString(fieldDto.getSiteTmethods()));
        }*/

/*        if (fieldDto.getTableau() != null) {
            fieldResponse.setTableau(Arrays.toString(fieldDto.getTableau()));
        }
        if (fieldDto.getSiteAim() != null) {
            fieldResponse.setSiteAim(Arrays.toString(fieldDto.getSiteAim()));
        }
        if (fieldDto.getSiteConditions() != null) {
            fieldResponse.setSiteConditions(Arrays.toString(fieldDto.getSiteConditions()));
        }
        if (fieldDto.getSiteContacts() != null) {
            fieldResponse.setSiteContacts(Arrays.toString(fieldDto.getSiteContacts()));
        }
        if (fieldDto.getSiteContents() != null) {
            fieldResponse.setSiteContents(Arrays.toString(fieldDto.getSiteContents()));
        }
        if (fieldDto.getSiteIntroduction() != null) {
            fieldResponse.setSiteIntroduction(Arrays.toString(fieldDto.getSiteIntroduction()));
        }
        if (fieldDto.getSiteRegisterR() != null) {
            fieldResponse.setSiteRegisterR(Arrays.toString(fieldDto.getSiteRegisterR()));
        }
        if (fieldDto.getSiteTmethods()!= null) {
            fieldResponse.setSiteTmethods(Arrays.toString(fieldDto.getSiteTmethods()));
        }*/
    }

//    Handle Update Dto from Response for later use
}
