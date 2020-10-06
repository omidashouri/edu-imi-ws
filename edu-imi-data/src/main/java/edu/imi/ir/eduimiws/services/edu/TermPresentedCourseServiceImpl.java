package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedCourseEntity;
import edu.imi.ir.eduimiws.repositories.edu.TermPresentedCourseRepository;
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
public class TermPresentedCourseServiceImpl implements TermPresentedCourseService {

    private final TermPresentedCourseRepository termPresentedCourseRepository;

    @Override
    public Page<TermPresentedCourseEntity> findAllByOrderPageable(Pageable pageable) {
        Page<TermPresentedCourseEntity> termPresentedCoursePages = termPresentedCourseRepository
                .findAllBy(pageable);
        return termPresentedCoursePages;
    }

    @Override
    public TermPresentedCourseEntity findByTermPresentedCoursePublicId(String termPresentedCoursePublicId) {
        TermPresentedCourseEntity termPresentedCourse = termPresentedCourseRepository
                .findByTermPresentedCourseApi_TrmPresentedCoursePublicId(termPresentedCoursePublicId);
        return termPresentedCourse;
    }
}
