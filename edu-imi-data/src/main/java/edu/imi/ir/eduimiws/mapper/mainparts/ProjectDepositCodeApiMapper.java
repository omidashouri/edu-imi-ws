package edu.imi.ir.eduimiws.mapper.mainparts;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.mainparts.ProjectDepositCodeApiEntity;
import edu.imi.ir.eduimiws.domain.pmis.ProjectEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.dto.pmis.ProjectDto;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import edu.imi.ir.eduimiws.services.pmis.ProjectService;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import edu.imi.ir.eduimiws.utilities.SecurityUtil;
import org.mapstruct.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Named("ProjectDepositCodeApiMapper")
@Mapper(componentModel = "spring",
        imports = {java.sql.Timestamp.class, java.util.Date.class, SecurityUtil.class},
        uses = {ProjectService.class, PublicIdUtil.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProjectDepositCodeApiMapper {

    @Named("toProjectDepositCodeApiDto")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "publicId", target = "publicId"),
            @Mapping(source = "project.id", target = "projectId"),
            @Mapping(source = "project.projectName", target = "projectName"),
            @Mapping(source = "project.projectCode", target = "projectCode"),
            @Mapping(source = "project.projectApi.projectPublicId", target = "projectPublicId"),
            @Mapping(source = "project.lastVersion", target = "projectLastVersion"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
            @Mapping(source = "creator.id", target = "creatorId"),
            @Mapping(source = "creator.personApiEntity.personPublicId", target = "creatorPublicId"),
            @Mapping(source = "editor.id", target = "editorId"),
            @Mapping(source = "editor.personApiEntity.personPublicId", target = "editorPublicId"),
            @Mapping(source = "creator", target = "creatorDto",
                    qualifiedByName = "personEntityToPersonDtoForDepositCodeApi"),
            @Mapping(source = "creator", target = "creatorFullName",
                    qualifiedByName = "fullNameFormPersonEntityForDepositCodeApi"),
            @Mapping(source = "editor", target = "editorDto",
                    qualifiedByName = "personEntityToPersonDtoForDepositCodeApi"),
            @Mapping(source = "editor", target = "editorFullName",
                    qualifiedByName = "fullNameFormPersonEntityForDepositCodeApi"),
            @Mapping(source = "project", target = "projectDto",
                    qualifiedByName = "toProjectDtoForDepositCodeApi")

    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDepositCodeApiDto toProjectDepositCodeApiDto(ProjectDepositCodeApiEntity source);

    @Named("toProjectDepositCodeApiEntity")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "publicId", target = "publicId"),
//            @Mapping(source = "projectId", target = "project.id"),
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "createDateTs", target = "createDateTs"),
            @Mapping(source = "deleteDateTs", target = "deleteDateTs"),
            @Mapping(source = "editDateTs", target = "editDateTs"),
/*            @Mapping(source = "creatorId", target = "creator.id"),
            @Mapping(source = "editorId", target = "editor.id"),*/
            @Mapping(source = "creatorDto", target = "creator",
                    qualifiedByName = "personDtoToPersonEntityForDepositCodeApi"),
            @Mapping(source = "editorDto", target = "editor",
                    qualifiedByName = "personDtoToPersonEntityForDepositCodeApi"),
            @Mapping(source = "projectDto", target = "project",
                    qualifiedByName = "toProjectEntityForDepositCodeApi")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDepositCodeApiEntity toProjectDepositCodeApiEntity(ProjectDepositCodeApiDto source);

    @IterableMapping(qualifiedByName = "toProjectDepositCodeApiDto")
    List<ProjectDepositCodeApiDto> toProjectDepositCodeApiDtos(List<ProjectDepositCodeApiEntity> sources);

    @IterableMapping(qualifiedByName = "toProjectDepositCodeApiEntity")
    List<ProjectDepositCodeApiEntity> toProjectDepositCodeApiEntities(List<ProjectDepositCodeApiDto> sources);

    void updateProjectCodeApiByProjectDepositCodeApiDto(ProjectDepositCodeApiDto newProjectDepositCodeApiDto,
                                                        @MappingTarget ProjectDepositCodeApiEntity editTblProjectDepositCodeApi);


    default void setPublicIdCreatorCreateDateTs(@MappingTarget ProjectDepositCodeApiDto depositCodeApiDto,
                                                @Context PersonMapper personMapper) {

        depositCodeApiDto.setPublicId(new PublicIdUtil().generateUniquePublicId());
        depositCodeApiDto
                .setCreatorDto(this
                        .personEntityToPersonDtoForDepositCodeApi(new SecurityUtil()
                                .getPersonEntityFromSecurityContext()));
        depositCodeApiDto.setCreatorId(new SecurityUtil().getPersonIdFromSecurityContext());
        depositCodeApiDto.setCreateDateTs(new Timestamp(new Date().getTime()));
    }

    default void setEditorEditDateTs(@MappingTarget ProjectDepositCodeApiDto depositCodeApiDto,
                                     @Context PersonMapper personMapper) {
        depositCodeApiDto
                .setEditorDto(this
                        .personEntityToPersonDtoForDepositCodeApi(new SecurityUtil()
                                .getPersonEntityFromSecurityContext()));
        depositCodeApiDto.setEditorId(new SecurityUtil().getPersonIdFromSecurityContext());
        depositCodeApiDto.setEditDateTs(new Timestamp(new Date().getTime()));
    }

    ProjectDepositCodeApiDto updateByProjectDepositCodeApiDto(ProjectDepositCodeApiDto source);

    //          1- ProjectDepositCodeApiDto → through publicID (in Service)

    @Mappings({
            @Mapping(source = "depositCode", target = "depositCode"),
            @Mapping(source = "projectPublicId", target = "projectDto",
                    qualifiedBy = {MappingUtil.ProjectService.class,
                            MappingUtil.ProjectPublicIdToProjectDto.class}),
            @Mapping(source = "description", target = "description")
    })
    @BeanMapping(ignoreByDefault = true,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateByProjectDepositCodeApiRequest(ProjectDepositCodeApiRequest source,
                                              @MappingTarget ProjectDepositCodeApiDto target);


    @Named("toProjectDtoForDepositCodeApi")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectApi.projectPublicId", target = "projectPublicId"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "lastVersion", target = "lastVersion")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectDto toProjectDtoForDepositCodeApi(ProjectEntity projectEntity);

    @Named("toProjectEntityForDepositCodeApi")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "projectCode", target = "projectCode"),
            @Mapping(source = "projectName", target = "projectName"),
            @Mapping(source = "lastVersion", target = "lastVersion")
    })
    @BeanMapping(ignoreByDefault = true)
    ProjectEntity toProjectEntityForDepositCodeApi(ProjectDto projectDto);

    @Named("personDtoToPersonEntityForDepositCodeApi")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName")
    })
    @BeanMapping(ignoreByDefault = true)
    PersonEntity personDtoToPersonEntityForDepositCodeApi(PersonDto personDto);

    @Named("personEntityToPersonDtoForDepositCodeApi")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "personApiEntity.personPublicId", target = "personPublicId"),
    })
    @BeanMapping(ignoreByDefault = true)
    PersonDto personEntityToPersonDtoForDepositCodeApi(PersonEntity personEntity);

    @Named("fullNameFormPersonEntityForDepositCodeApi")
    default String fullNameFormPersonEntityForDepositCodeApi(PersonEntity personEntity) {

        return Optional.of(personEntity)
                .filter(Objects::nonNull)
                .map(c -> String.format("%s %s",
                        Objects.nonNull(c.getFirstName()) ? c.getFirstName() : "",
                        Objects.nonNull(c.getLastName()) ? c.getLastName() : ""
                ))
                .map(fn -> fn.trim().replaceAll(" +", " "))
                .orElse(null);
    }

}
