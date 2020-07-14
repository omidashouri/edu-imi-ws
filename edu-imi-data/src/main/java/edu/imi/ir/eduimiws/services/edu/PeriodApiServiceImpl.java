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
    public Long periodApiCount() {
        return periodApiRepository.count();
    }

    @Override
    public List<PeriodApiEntity> generatePeriodApiPublicId(List<PeriodEntity> newPeriodEntities) {

        List<PeriodApiEntity> newPeriodApiEntities = new ArrayList<>();

        newPeriodEntities.forEach(p -> {
            PeriodApiEntity newPeriodApi = new PeriodApiEntity();
            newPeriodApi.setPeriod(p);
            newPeriodApi.setPeriodId(p.getId());
            newPeriodApi.setPeriodPublicId(this.generatePeriodApiPublicId());
            if (null != p.getCanRegisterOnline()) {
                newPeriodApi.setCanRegisterOnline(p.getCanRegisterOnline().trim());
            }
            if (null != p.getDeleteStatus() && p.getDeleteStatus().equals(1L)) {
                newPeriodApi.setDeleteTs(new Timestamp(new Date().getTime()));
            }
            if (null != p.getEditDate()) {
                newPeriodApi.setPeriodEditDate(p.getEditDate());
            }
            newPeriodApi.setCreateDateTs(new Timestamp(new Date().getTime()));
            newPeriodApiEntities.add(newPeriodApi);
        });

        newPeriodApiEntities.sort(Comparator.comparing(PeriodApiEntity::getPeriodId));

        periodApiRepository.saveAll(newPeriodApiEntities);

        return newPeriodApiEntities;
    }

    @Override
    public List<PeriodApiEntity> findAllByPeriodIdIn(List<Long> periodIds) {
        List<PeriodApiEntity> periodApis = periodApiRepository
                .findAllByPeriodIdIn(periodIds);
        return periodApis;
    }

    @Override
    public List<PeriodApiEntity> findAllByPeriodIdInAndPeriodPublicIdIsNotNull(List<Long> periodIds) {
        List<PeriodApiEntity> periodApis = periodApiRepository
                .findAllByPeriodIdInAndPeriodPublicIdIsNotNull(periodIds);
        return periodApis;
    }

    @Override
    public PeriodApiEntity selectLastRecord() {
        return periodApiRepository.findFirstByOrderByIdDesc();
    }

    private String generatePeriodApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
