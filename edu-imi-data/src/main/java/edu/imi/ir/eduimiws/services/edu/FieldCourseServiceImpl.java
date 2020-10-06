package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldCourseEntity;
import edu.imi.ir.eduimiws.repositories.edu.FieldCourseRepository;
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
public class FieldCourseServiceImpl implements FieldCourseService {

    private final FieldCourseRepository fieldCourseRepository;

    @Override
    public Page<FieldCourseEntity> findAllByOrderPageable(Pageable pageable) {
        Page<FieldCourseEntity> fieldCoursePages = fieldCourseRepository
                .findAllBy(pageable);
        return fieldCoursePages;
    }

    @Override
    public FieldCourseEntity findByFieldCoursePublicId(String fieldCoursePublicId) {
        FieldCourseEntity fieldCourse = fieldCourseRepository
                .findByFieldCourseApi_FieldCoursePublicId(fieldCoursePublicId);
        return fieldCourse;
    }
}
