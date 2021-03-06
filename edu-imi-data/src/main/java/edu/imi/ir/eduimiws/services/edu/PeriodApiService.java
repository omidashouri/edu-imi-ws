package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;

import java.util.List;

public interface PeriodApiService {

    PeriodApiEntity selectLastRecord();

    Long periodApiCount();

    List<PeriodApiEntity> generatePeriodApiPublicId(List<PeriodEntity> newPeriodEntities);

    List<PeriodApiEntity> findAllByPeriodIdIn(List<Long> periodIds);

    List<PeriodApiEntity> findAllByPeriodIdInAndPeriodPublicIdIsNotNull(List<Long> periodIds);

    List<PeriodApiEntity> findAllPeriodApisByFieldPublicIdIsNull();

    List<PeriodApiEntity> updatePeriodApiByFieldPublicId(List<PeriodApiEntity> periodApisWithNullFieldPublicIds);
}
