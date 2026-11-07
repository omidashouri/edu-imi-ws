package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import edu.imi.ir.eduimiws.repositories.edu.TermPresentedGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TermPresentedGroupServiceImpl implements TermPresentedGroupService {

    private final TermPresentedGroupRepository termPresentedGroupRepository;

    @Override
    public Page<TermPresentedGroupEntity> findAllByOrderPageable(Pageable pageable) {
        log.info("TermPresentedGroupService.findAllByOrderPageable - pageable: {}", pageable);
        Page<TermPresentedGroupEntity> result = termPresentedGroupRepository
                .findAllBy(pageable);
        log.info("TermPresentedGroupService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public TermPresentedGroupEntity findByTermPresentedGroupPublicId(String termPresentedGroupPublicId) {
        log.info("TermPresentedGroupService.findByTermPresentedGroupPublicId - termPresentedGroupPublicId: {}", termPresentedGroupPublicId);
        TermPresentedGroupEntity result = termPresentedGroupRepository
                .findByTermPresentedGroupApi_TermPresentedGroupPublicId(termPresentedGroupPublicId);
        log.info("TermPresentedGroupService.findByTermPresentedGroupPublicId - result: {}", result);
        return result;
    }

    @Override
    public Page<TermPresentedGroupEntity>
    selectAllWithCoursePeriodTermProfessorFieldCourseTermPresentedCourseByOrderPageable(Pageable pageable) {
        log.info("TermPresentedGroupService.selectAllWithCoursePeriodTermProfessorFieldCourseTermPresentedCourseByOrderPageable - pageable: {}", pageable);
        Page<TermPresentedGroupEntity> result = termPresentedGroupRepository
                .readAllBy(pageable);
        log.info("TermPresentedGroupService.selectAllWithCoursePeriodTermProfessorFieldCourseTermPresentedCourseByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }
}
