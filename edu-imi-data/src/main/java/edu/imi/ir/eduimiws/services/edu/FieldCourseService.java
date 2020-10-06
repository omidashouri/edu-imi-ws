package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldCourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FieldCourseService {

    Page<FieldCourseEntity> findAllByOrderPageable(Pageable pageable);

    FieldCourseEntity findByFieldCoursePublicId(String fieldCoursePublicId);
}
