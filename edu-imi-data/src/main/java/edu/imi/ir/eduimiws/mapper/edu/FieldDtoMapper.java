package edu.imi.ir.eduimiws.mapper.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.models.dto.edu.FieldDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface FieldDtoMapper {

    FieldDtoMapper INSTANCE = Mappers.getMapper(FieldDtoMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fieldApi.fieldPublicId", target = "fieldPublicId"),
            @Mapping(source = "isInternational", target = "isInternational"),
            @Mapping(source = "lastPeriodNumber", target = "lastPeriodNumber"),
            @Mapping(source = "level.id", target = "levelId"),
            @Mapping(source = "fieldApi.levelPublicId", target = "levelPublicId"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "lname", target = "lname"),
            @Mapping(source = "needPermitionForAgancy", target = "needPermitionForAgancy"),
            @Mapping(source = "note", target = "note"),
            @Mapping(source = "organization.id", target = "organizationId"),
            @Mapping(source = "planId", target = "planId"),
            @Mapping(source = "preCertificate.id", target = "preCertificateId"),
            @Mapping(source = "punit", target = "punit"),
            @Mapping(source = "preCoefficientId", target = "preCoefficientId"),
            @Mapping(source = "scoreAcceptBound", target = "scoreAcceptBound"),
            @Mapping(source = "scoreAcceptedQuality", target = "scoreAcceptedQuality"),
            @Mapping(source = "scoreHighBound", target = "scoreHighBound"),
            @Mapping(source = "scoreLowBound", target = "scoreLowBound"),
            @Mapping(source = "scoreQualityValues", target = "scoreQualityValues"),
            @Mapping(source = "scoringWay", target = "scoringWay"),
            @Mapping(source = "siteAim", target = "siteAim"),
            @Mapping(source = "siteConditions", target = "siteConditions"),
            @Mapping(source = "siteContacts", target = "siteContacts"),
            @Mapping(source = "siteContents", target = "siteContents"),
            @Mapping(source = "siteIntroduction", target = "siteIntroduction"),
            @Mapping(source = "siteRegisterR", target = "siteRegisterR"),
            @Mapping(source = "siteTmethods", target = "siteTmethods"),
            @Mapping(source = "supervisor.id", target = "supervisorId"),
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
            @Mapping(source = "company.id", target = "companyId"),
            @Mapping(source = "contact.id", target = "contactId"),
            @Mapping(source = "createDate", target = "createDate"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "diplomaType", target = "diplomaType"),
            @Mapping(source = "editDate", target = "editDate"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "eduCategory.id", target = "eduCategoryId"),
            @Mapping(source = "fieldApi.eduCategoryPublicId", target = "eduCategoryPublicId"),
            @Mapping(source = "eduCategory", target = "eduCategory"),
            @Mapping(source = "examType", target = "examType"),
            @Mapping(source = "executerId", target = "executerId"),
            @Mapping(source = "fname", target = "fname"),
            @Mapping(source = "foriegnFee", target = "foriegnFee")
    })
    @BeanMapping(ignoreByDefault = true)
    FieldDto toFieldDto(FieldEntity fieldEntity
            , @Context CycleAvoidingMappingContext context);

    @BeanMapping(ignoreByDefault = true)
    @InheritInverseConfiguration
    FieldEntity toFieldEntity(FieldDto fieldDto
            , @Context CycleAvoidingMappingContext context);

    List<FieldEntity> toFieldEntities(List<FieldDto> fieldDtos,
                                      @Context CycleAvoidingMappingContext context);

    List<FieldDto> toFieldDtos(List<FieldEntity> fieldEntities,
                               @Context CycleAvoidingMappingContext context);

/*    @AfterMapping
    default void handlePeriodNameStudentFullName(RegisterEntity registerEntity,
                                                 @MappingTarget RegisterDto registerDto) {


        if (!Hibernate.isInitialized(registerEntity.getRegisterApi().getStudent())) {
            registerEntity.setStudent(null);
            registerEntity.getRegisterApi().setStudent(null);
        }

        if (!Hibernate.isInitialized(registerEntity.getRegisterApi().getPeriod())) {
            registerEntity.setPeriod(null);
            registerEntity.getRegisterApi().setPeriod(null);
        }


        if (registerEntity.getRegisterApi().getStudent() != null) {
            registerDto.setStudentFirstName(registerEntity.getRegisterApi().getStudent().getFirstName());
            registerDto.setStudentLastName(registerEntity.getRegisterApi().getStudent().getLastName());
            registerDto
                    .setStudentFullName(
                            registerEntity.getRegisterApi().getStudent().getFirstName()
                                    + ' ' +
                                    registerEntity.getRegisterApi().getStudent().getLastName());
        }


        if (registerEntity.getRegisterApi().getPeriod() != null) {
            registerDto.setPeriodName(registerEntity.getRegisterApi().getPeriod().getName());
        }
    }*/
}
