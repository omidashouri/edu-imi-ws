package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PeriodService {

    Long PeriodCount();

    PeriodEntity selectLastRecord();

    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    List<PeriodEntity> findAllPeriodOnly();

    List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id);

    List<PeriodEntity> findNewPeriodNotInPeriodWebService(List<PeriodWebServiceEntity> periodWebServiceEntities);

    List<PeriodFastDto> findAllPeriodFastDtoByIds(List<Long> periodIds);

}
