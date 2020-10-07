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
        Page<TermPresentedGroupEntity> termPresentedGroupPages = termPresentedGroupRepository
                .findAllBy(pageable);
        return termPresentedGroupPages;
    }

    @Override
    public TermPresentedGroupEntity findByTermPresentedGroupPublicId(String termPresentedGroupPublicId) {
        TermPresentedGroupEntity termPresentedGroup = termPresentedGroupRepository
                .findByTermPresentedGroupApi_TermPresentedGroupPublicId(termPresentedGroupPublicId);
        return termPresentedGroup;
    }

    @Override
    public Page<TermPresentedGroupEntity>
    selectAllWithCoursePeriodTermProfessorFieldCourseTermPresentedCourseByOrderPageable(Pageable pageable) {

        Page<TermPresentedGroupEntity> termPresentedGroupPages = termPresentedGroupRepository
                .readAllBy(pageable);
        return termPresentedGroupPages;
    }
}
