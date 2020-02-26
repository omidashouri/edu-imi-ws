package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import edu.imi.ir.eduimiws.repositories.edu.PeriodWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodWebServiceServiceImpl implements PeriodWebServiceService {

    private final PeriodWebServiceRepository periodWebServiceRepository;
    private final PeriodRepository periodRepository;
    private final Utils utils;


    @Override
    public List<PeriodWebServiceEntity> findAllEntities() {
        List<PeriodWebServiceEntity> periodWebServiceEntities = new ArrayList<>();
        periodWebServiceEntities = periodWebServiceRepository.findAll();
        return periodWebServiceEntities;
    }

    @Override
    public Long periodWebServiceCount() {
        return periodWebServiceRepository.count();
    }

    @Override
    public List<PeriodWebServiceEntity> generatePeriodWebServicePublicId(List<PeriodEntity> newPeriodEntities) {

        List<PeriodWebServiceEntity> newPeriodWebServiceEntities = new ArrayList<>();

        if (0 == newPeriodEntities.size()) {
            newPeriodEntities = periodRepository.findTop10By();
        } else {
            newPeriodEntities = periodRepository.findTop20By();
        }

        newPeriodEntities.forEach(p -> {
            PeriodWebServiceEntity newPeriodWebService = new PeriodWebServiceEntity();
            newPeriodWebService.setPeriod(p);
            newPeriodWebService.setPeriodPublicId(this.generatePeriodWebServicePublicId());
            if (null != p.getCanRegisterOnline()) {
                newPeriodWebService.setCanRegisterOnline(p.getCanRegisterOnline().trim());
            }
            if (null != p.getDeleteStatus() && p.getDeleteStatus().equals(1L)) {
                newPeriodWebService.setDeleteTs(new Timestamp(new Date().getTime()));
            }
            newPeriodWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
            newPeriodWebServiceEntities.add(newPeriodWebService);
        });


        periodWebServiceRepository.saveAll(newPeriodWebServiceEntities);


        return newPeriodWebServiceEntities;
    }

    @Override
    public PeriodWebServiceEntity findAll() {

        List<PeriodWebServiceEntity> periodWebServiceEntities;
        List<PeriodEntity> periodEntities;
        List<PeriodEntity> newPeriodEntities = new ArrayList<>();
        List<PeriodWebServiceEntity> newPeriodWebServiceEntities;

        if (!isPeriodWebServiceUpdated()) {
            periodWebServiceEntities = periodWebServiceRepository.findAll();
            periodEntities = periodRepository.findAll();

//            periodEntities.stream().map(PeriodEntity::getPeriodWebService).collect(Collectors.toList()).removeAll(periodWebServiceEntities);

/*            list2.stream().map(toKey)
                    .filter(list1.stream().map(toKey).collect(Collectors.toSet())::contains)*/

/*            periodEntities.stream().map(PeriodEntity::getPeriodWebService)
                    .filter(periodWebServiceEntities.stream().collect(Collectors.toSet())::contains).map(newPeriodEntities::add);*/

            periodEntities
                    .stream()
                    .filter(periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriod).collect(Collectors.toSet())::contains)
                    .map(newPeriodEntities::add);


            Predicate<PeriodEntity> periodPredicate = newPeriod -> newPeriod.getId().equals(newPeriod);
            Predicate<List<PeriodEntity>> periodsPredicate = (newPeriods) -> newPeriods.equals(newPeriods);


            periodWebServiceRepository.findAll();
            return null;
        }
        return null;
    }


    private boolean isPeriodWebServiceUpdated() {
        boolean returnValue = false;
        Long periodWebServiceSize;
        Long periodSize;

        periodWebServiceSize = periodWebServiceRepository.count();
        periodSize = periodRepository.count();

        if (periodWebServiceSize == periodSize) {
            returnValue = true;
        }

        return returnValue;
    }

    private String generatePeriodWebServicePublicId() {
        return utils.generateUniquePublicId();
    }

}
