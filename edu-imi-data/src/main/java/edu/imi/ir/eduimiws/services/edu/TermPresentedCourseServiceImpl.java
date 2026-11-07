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
        log.info("TermPresentedCourseService.findAllByOrderPageable - pageable: {}", pageable);
        Page<TermPresentedCourseEntity> result = termPresentedCourseRepository
                .findAllBy(pageable);
        log.info("TermPresentedCourseService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public TermPresentedCourseEntity findByTermPresentedCoursePublicId(String termPresentedCoursePublicId) {
        log.info("TermPresentedCourseService.findByTermPresentedCoursePublicId - termPresentedCoursePublicId: {}", termPresentedCoursePublicId);
        TermPresentedCourseEntity result = termPresentedCourseRepository
                .findByTermPresentedCourseApi_TrmPresentedCoursePublicId(termPresentedCoursePublicId);
        log.info("TermPresentedCourseService.findByTermPresentedCoursePublicId - result: {}", result);
        return result;
    }
}
