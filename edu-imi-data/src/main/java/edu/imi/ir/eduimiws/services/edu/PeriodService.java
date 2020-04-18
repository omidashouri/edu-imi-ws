package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeriodService {

    Long PeriodCount();

    PeriodEntity selectLastRecord();

    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    PeriodEntity findPeriodEntityByPeriodWebServicePublicId(String periodPublicId);

    List<PeriodEntity> findAllPeriodOnly();

    List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id);

    Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNull();

    Page<PeriodEntity> findAllPageableByExecutorPublicId(Pageable pageable, String executorPublicId);

}
