package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import java.util.List;

public interface PeriodWebServiceService {

    PeriodWebServiceEntity selectLastRecord();

    Long periodWebServiceCount();

    List<PeriodWebServiceEntity> generatePeriodWebServicePublicId(List<PeriodEntity> newPeriodEntities);
}
