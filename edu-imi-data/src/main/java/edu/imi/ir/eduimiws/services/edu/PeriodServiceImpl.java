package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodOnlyMapper;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodOnly;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;
    private final PeriodOnlyMapper periodOnlyMapper;

    @Override
    public Long PeriodCount() {
        return periodRepository.count();
    }


    /*        oldPeriods = periodRepository.findByIdIn(periodIds);
        oldPeriods = periodRepository.findPeriodEntitiesByIdIn(periodIds);
        oldPeriods = periodRepository.findByCreatorNotIn(personEntities);

        //Ids that are not in PeriodWebService but search among data that selected query get from database
         newPeriods = periodRepository.findAllByPeriodWebService_IdNotIn(periodWebServiceIds);
*/
    @Override
    public List<PeriodEntity> findNewPeriodNotInPeriodWebService(List<PeriodWebServiceEntity> periodWebServiceEntities) {
        List<PeriodOnly> allPeriodOnlyList = new ArrayList<>();
        List<PeriodOnly> newPeriodOnlyList ;
        List<PeriodEntity> newPeriods = new ArrayList<>();
        List<Long> oldPeriodIds = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriodId).collect(Collectors.toList());

        allPeriodOnlyList = periodRepository.findBy();

        Map<Long,List<PeriodOnly>>  allPeriodOnlyMap = allPeriodOnlyList.stream().collect(Collectors.groupingBy(PeriodOnly::getId));

        Map<Long, List<PeriodOnly>> newPeriodOnlyMap = allPeriodOnlyMap
                .entrySet()
                .stream()
                .filter(Objects::nonNull)
                .filter(e->!oldPeriodIds.stream().collect(Collectors.toSet()).contains(e.getKey()))
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

        newPeriodOnlyList = newPeriodOnlyMap.values().stream().flatMap(List::stream).collect(Collectors.toList());

        newPeriods = periodOnlyMapper.PeriodOnliesToPeriodEntities(newPeriodOnlyList,new CycleAvoidingMappingContext());

        return newPeriods;
    }


}
