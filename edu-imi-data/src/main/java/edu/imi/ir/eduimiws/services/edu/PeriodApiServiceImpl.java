package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodApiEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.repositories.edu.PeriodApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
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
public class PeriodApiServiceImpl implements PeriodApiService {

    private final PeriodApiRepository periodApiRepository;
    private final PublicIdUtil publicIdUtil;

    @Override
    public Long periodWebServiceCount() {
        return periodApiRepository.count();
    }

    @Override
    public List<PeriodApiEntity> generatePeriodWebServicePublicId(List<PeriodEntity> newPeriodEntities) {

        List<PeriodApiEntity> newPeriodWebServiceEntities = new ArrayList<>();

        newPeriodEntities.forEach(p -> {
            PeriodApiEntity newPeriodWebService = new PeriodApiEntity();
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

        newPeriodWebServiceEntities.sort(Comparator.comparing(PeriodApiEntity::getPeriodId));

        periodApiRepository.saveAll(newPeriodWebServiceEntities);

        return newPeriodWebServiceEntities;
    }

    @Override
    public PeriodApiEntity selectLastRecord() {
        return periodApiRepository.findFirstByOrderByIdDesc();
    }

    private String generatePeriodWebServicePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
