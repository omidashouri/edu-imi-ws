package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    @Override
    public List<PeriodEntity> findNewPeriodNotInPeriodWebService(List<PeriodWebServiceEntity> periodWebServiceEntities) {
        List<PeriodEntity> periodEntities;
        List<PeriodEntity> periodEntities2;
//        periodEntities2 = periodRepository.findAll();
        periodEntities = periodRepository.findByPeriodWebServiceIn(periodWebServiceEntities);
        periodEntities = periodRepository.findByPeriodWebServiceNotIn(periodWebServiceEntities);
        return periodEntities;
    }
}
