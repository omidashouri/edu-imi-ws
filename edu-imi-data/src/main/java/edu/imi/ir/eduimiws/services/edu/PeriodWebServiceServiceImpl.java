package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.repositories.edu.PeriodWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodWebServiceServiceImpl implements PeriodWebServiceService {

    private final PeriodWebServiceRepository periodWebServiceRepository;
    private final Utils utils;

    @Override
    public Long periodWebServiceCount() {
        return periodWebServiceRepository.count();
    }

    @Override
    public List<PeriodWebServiceEntity> generatePeriodWebServicePublicId(List<PeriodEntity> newPeriodEntities) {

        List<PeriodWebServiceEntity> newPeriodWebServiceEntities = new ArrayList<>();

        newPeriodEntities.forEach(p -> {
            PeriodWebServiceEntity newPeriodWebService = new PeriodWebServiceEntity();
            newPeriodWebService.setPeriod(p);
            newPeriodWebService.setPeriodId(p.getId());
            newPeriodWebService.setPeriodPublicId(this.generatePeriodWebServicePublicId());
            if (null != p.getCanRegisterOnline()) {
                newPeriodWebService.setCanRegisterOnline(p.getCanRegisterOnline().trim());
            }
            if (null != p.getDeleteStatus() && p.getDeleteStatus().equals(1L)) {
                newPeriodWebService.setDeleteTs(new Timestamp(new Date().getTime()));
            }
            if (null != p.getEditDate()) {
                newPeriodWebService.setPeriodEditDate(p.getEditDate());
            }
            newPeriodWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
            newPeriodWebServiceEntities.add(newPeriodWebService);
        });

        newPeriodWebServiceEntities.sort(Comparator.comparing(PeriodWebServiceEntity::getPeriodId));

        periodWebServiceRepository.saveAll(newPeriodWebServiceEntities);

        return newPeriodWebServiceEntities;
    }

    @Override
    public PeriodWebServiceEntity selectLastRecord() {
        return periodWebServiceRepository.findFirstByOrderByIdDesc();
    }

    private String generatePeriodWebServicePublicId() {
        return utils.generateUniquePublicId();
    }

}
