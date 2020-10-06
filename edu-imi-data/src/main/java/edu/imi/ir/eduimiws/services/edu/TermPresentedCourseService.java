package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TermPresentedCourseService {

    Page<TermPresentedCourseEntity> findAllByOrderPageable(Pageable pageable);

    TermPresentedCourseEntity findByTermPresentedCoursePublicId(String termPresentedCoursePublicId);
}
