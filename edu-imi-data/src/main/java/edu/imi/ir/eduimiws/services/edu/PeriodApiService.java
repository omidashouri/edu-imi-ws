package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;

import java.util.List;

public interface PeriodApiService {

    PeriodApiEntity selectLastRecord();

    Long periodWebServiceCount();

    List<PeriodApiEntity> generatePeriodWebServicePublicId(List<PeriodEntity> newPeriodEntities);
}
