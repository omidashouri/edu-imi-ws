package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;

import java.util.List;

public interface PeriodService {


    List<PeriodEntity> findNewPeriodNotInPeriodWebService(List<PeriodWebServiceEntity> periodWebServiceEntities);

}
