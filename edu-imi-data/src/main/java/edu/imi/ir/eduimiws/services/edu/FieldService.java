package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FieldService {

    Long countFieldByIdLessThanEqual(Long fieldId);

    FieldEntity selectLastRecord();

    Page<FieldEntity> findAllByOrderPageable(Pageable pageable);

//    Page<FieldEntity> findAllWithStudentPeriodNameByOrderPageable(Pageable pageable);

    FieldEntity findByFieldPublicId(String fieldPublicId);

    Page<FieldEntity> findAllByLevelPublicIdPageable(String levelPublicId, Pageable pageable);

    Page<FieldEntity> findAllByEduCategoryPublicIdPageable(String eduCategoryPublicId, Pageable pageable);

//    FieldEntity findWithStudentPeriodNameByFieldPublicId(String fieldPublicId);

    List<FieldEntity> findAllFieldOnlyByIdBetween(Long startId, Long endId);

    List<FieldEntity> selectAllFieldOnly();

    FieldEntity findFirstByIdLessThanOrderByIdDesc(Long fieldId);

    Long selectFieldLastSequenceNumber();
}
