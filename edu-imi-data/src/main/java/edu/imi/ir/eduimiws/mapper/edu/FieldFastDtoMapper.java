package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldFastDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface FieldFastDtoMapper {

    FieldFastDtoMapper INSTANCE = Mappers.getMapper(FieldFastDtoMapper.class);

//    organizationPublicId, preCertificatePublicId, supervisorPublicId
//    companyPublicId, contactPublicId, creatorPublicID
//    diplomaTypePublicId, editorPublicId, executerId

    @Mappings({
            @Mapping(source = "fieldApi.fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "fieldApi.fieldPublicId", target = "levelPublicId"),
            @Mapping(source = "fieldApi.eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "fname", target = "fname"),
            @Mapping(source = "foriegnFee", target = "foriegnFee"),
            @Mapping(source = "isInternational", target = "isInternational"),
            @Mapping(source = "lastPeriodNumber", target = "lastPeriodNumber"),
            @Mapping(source = "lname", target = "lname"),
            @Mapping(source = "needPermitionForAgancy", target = "needPermitionForAgancy"),
            @Mapping(source = "note", target = "note"),
            @Mapping(source = "preCoefficientId", target = "preCoefficientId"),
            @Mapping(source = "punit", target = "punit"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "siteAim", target = "siteAim"),
            @Mapping(source = "siteConditions", target = "siteConditions"),
            @Mapping(source = "siteContents", target = "siteContacts"),
            @Mapping(source = "siteContents", target = "siteContents"),
            @Mapping(source = "siteIntroduction", target = "siteIntroduction"),
            @Mapping(source = "siteRegisterR", target = "siteRegisterR"),
            @Mapping(source = "siteTmethods", target = "siteTmethods"),
            @Mapping(source = "tableau", target = "tableau"),
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
            @Mapping(source = "examType", target = "examType")

    })
    @BeanMapping(ignoreByDefault = true)
    FieldFastDto toFieldFastDto(FieldEntity fieldEntity, @Context CycleAvoidingMappingContext context);


    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldEntity toFieldEntity(FieldFastDto fieldFastDto, @Context CycleAvoidingMappingContext context);

    List<FieldEntity> toFieldEntities(List<FieldFastDto> fieldFastDtos, @Context CycleAvoidingMappingContext context);

    List<FieldFastDto> toFieldFastDtos(List<FieldEntity> fieldEntities, @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handleDtoPublicIds(FieldEntity fieldEntity, @MappingTarget FieldFastDto fieldFastDto) {

        if (!Hibernate.isInitialized(fieldEntity.getFieldApi())) {
            fieldEntity.setFieldApi(null);
        }

        if (fieldEntity.getFieldApi() != null) {
            if (fieldEntity.getFieldApi().getFieldPublicId() != null) {
                fieldFastDto.setFieldPublicId(fieldEntity.getFieldApi().getFieldPublicId());
            }
            if (fieldEntity.getFieldApi().getEduCategoryPublicId() != null) {
                fieldFastDto.setEduCategoryPublicId(fieldEntity.getFieldApi().getEduCategoryPublicId());
            }
            if (fieldEntity.getFieldApi().getLevelPublicId() != null) {
                fieldFastDto.setLevelPublicId(fieldEntity.getFieldApi().getLevelPublicId());
            }
        }
    }*/
}
