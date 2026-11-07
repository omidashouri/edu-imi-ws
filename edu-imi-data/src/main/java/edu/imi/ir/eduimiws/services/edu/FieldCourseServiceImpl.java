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
        log.info("FieldCourseService.findAllByOrderPageable - pageable: {}", pageable);
        Page<FieldCourseEntity> result = fieldCourseRepository
                .findAllBy(pageable);
        log.info("FieldCourseService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public FieldCourseEntity findByFieldCoursePublicId(String fieldCoursePublicId) {
        log.info("FieldCourseService.findByFieldCoursePublicId - fieldCoursePublicId: {}", fieldCoursePublicId);
        FieldCourseEntity result = fieldCourseRepository
                .findByFieldCourseApi_FieldCoursePublicId(fieldCoursePublicId);
        log.info("FieldCourseService.findByFieldCoursePublicId - result: {}", result);
        return result;
    }
}
