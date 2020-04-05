package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodWebServiceFastDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeriodWebServiceService {

    PeriodWebServiceEntity findAll();

    PeriodWebServiceEntity selectLastRecord();

    List<PeriodWebServiceEntity> findAllEntities();

    Long periodWebServiceCount();

    List<PeriodWebServiceEntity> generatePeriodWebServicePublicId(List<PeriodEntity> newPeriodEntities);

    Page<PeriodWebServiceFastDto> findAllPeriodWebServiceFastDtoPageable(Pageable pageable);

    List<PeriodWebServiceDto> findAllPeriodWebServiceDtoById(List<Long> ids);
}
