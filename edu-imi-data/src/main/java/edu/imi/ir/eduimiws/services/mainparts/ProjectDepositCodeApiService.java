package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.mainparts.ProjectDepositCodeApiDto;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomThree;
import edu.imi.ir.eduimiws.models.projections.mainparts.ProjectDepositCodeApiProjectionCustomTwo;
import edu.imi.ir.eduimiws.models.request.mainparts.ProjectDepositCodeApiRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;

public interface ProjectDepositCodeApiService {

    Page<ProjectDepositCodeApiDto> findAllAndDeleteDateTsIsNull(Pageable pageable);

    Page<ProjectDepositCodeApiDto> findAllByDeleteDateTsNotNull(Pageable pageable);

    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByPublicId(String publicId);

    @MappingUtil.ProjectPublicIdToProjectDto
    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectPublicId(String projectPublicId);

//    ProjectDepositCodeApiDto updateDepositCodeApi(ProjectDepositCodeApiDto newProjectDepositCodeApiDto, ProjectDepositCodeApiEntity editTblProjectDepositCodeApi);

    ProjectDepositCodeApiDto save(ProjectDepositCodeApiDto newProjectDepositCodeApiDto);

    //  List<ProjectDepositCodeApiEntity> findAllAndDeleteDateTsIsNull();

    ProjectDepositCodeApiDto findProjectDepositCodeApiEntityPublicId(String publicId);

    Page<ProjectDepositCodeApiDto> findByDepositCode(String depositCode, Pageable pageable);

    ProjectDepositCodeApiDto findProjectDepositCodeApiDtoByProjectCodeAndDepositCode(String projectCode,
                                                                                     String depositCode);

    Page<ProjectDepositCodeApiDto> findByProjectNameContaining(String projectName, Pageable pageable);

    void validateProjectDepositCodeApiRequestNullInputs(ProjectDepositCodeApiRequest projectDepositCodeApiRequest);

    void validateProjectDepositCodeApiDtoNulls(ProjectDepositCodeApiDto projectDepositCodeApiDto);

    Page<ProjectDepositCodeApiProjectionCustomTwo> queryAllProjectDepositCodeApiCustomTwo(String publicId,
                                                                                          String depositCode,
                                                                                          String description,
                                                                                          Timestamp createDateTs,
                                                                                          Timestamp editDateTs,
                                                                                          Timestamp deleteDateTs,
                                                                                          String projectName,
                                                                                          String projectCode,
                                                                                          String creatorFullName,
                                                                                          String editorFullName,
                                                                                          Pageable pageable
    );

    Page<ProjectDepositCodeApiProjectionCustomThree> queryAllProjectDepositCodeApiCustomThree(String publicId,
                                                                                              String depositCode,
                                                                                              String description,
                                                                                              Timestamp createDateTs,
                                                                                              Timestamp editDateTs,
                                                                                              Timestamp deleteDateTs,
                                                                                              String projectName,
                                                                                              String projectCode,
                                                                                              String projectCreateDate,
                                                                                              Long projectStatusId,
                                                                                              String projectTypeName,
                                                                                              String startDatePlan,
                                                                                              String endDatePlan,
                                                                                              String lastVersion,
                                                                                              Character statusForTimeshit,
                                                                                              String creatorFullName,
                                                                                              String editorFullName,
                                                                                              String executor,
                                                                                              String projectPublicId,
                                                                                              Pageable pageable
    );

}
