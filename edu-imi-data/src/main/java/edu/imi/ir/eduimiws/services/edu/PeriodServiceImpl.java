package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodIdDelStatCanRegOnlineOnly;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    @Override
    public Long PeriodCount() {
        return periodRepository.count();
    }

    @Override
    public List<PeriodEntity> findNewPeriodNotInPeriodWebService(List<PeriodWebServiceEntity> periodWebServiceEntities) {
        List<PeriodIdDelStatCanRegOnlineOnly> allPeriodIdDelStatCanRegOnlineOnly;
        List<Long> allPeriodIds;
        List<Long> newPeriodIds = new ArrayList<>();
        List<PeriodEntity> newPeriods = new ArrayList<>();
        List<PeriodEntity> oldPeriods = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriod).collect(Collectors.toList());
        List<PeriodEntity> periods = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriod).collect(Collectors.toList());
        List<Long> periodWebServiceIds = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getId).collect(Collectors.toList());
        List<Long> periodIds = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriod).map(PeriodEntity::getId).collect(Collectors.toList());
        List<PersonEntity> personEntities = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriod).map(PeriodEntity::getCreator)
                .collect(Collectors.toList());


/*        oldPeriods = periodRepository.findByIdIn(periodIds);
        oldPeriods = periodRepository.findPeriodEntitiesByIdIn(periodIds);
        oldPeriods = periodRepository.findByCreatorNotIn(personEntities);
        oldPeriods = periodRepository.findAllByPeriodWebService_IdIn(periodWebServiceIds);*/

        allPeriodIdDelStatCanRegOnlineOnly = periodRepository.findBy();
        StreamSupport
                .stream(allPeriodIdDelStatCanRegOnlineOnly.spliterator(),false)
                .filter(oldPeriods.stream().map(PeriodEntity::getId).collect(Collectors.toSet())::contains)
                .map(PeriodIdDelStatCanRegOnlineOnly::getId)
                .map(newPeriodIds::add);

        for(Long id : newPeriodIds){
            PeriodEntity newPeriodEntity = new PeriodEntity();
            newPeriodEntity.setId(id);
            newPeriods.add(newPeriodEntity);
        }

        newPeriods = periodRepository.findAllByPeriodWebService_IdNotIn(periodWebServiceIds);


        return newPeriods;//newPeriods oldPeriods
    }
}
