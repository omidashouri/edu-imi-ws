package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    Page<CourseEntity> findAllByPageable(Pageable pageable);

    CourseEntity findByCoursePublicId(String coursePublicId);
}
