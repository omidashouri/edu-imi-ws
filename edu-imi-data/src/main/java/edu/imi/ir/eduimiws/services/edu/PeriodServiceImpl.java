package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.domain.edu.PeriodWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodOnlyMapperOld;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodFastDto;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;
    private final PeriodOnlyMapperOld periodOnlyMapperOld;
    private final PeriodMapper periodMapper;
    private final PeriodFastDtoMapper periodFastDtoMapper;

    @Override
    public Long PeriodCount() {
        return periodRepository.count();
    }

    @Override
    public PeriodEntity selectLastRecord() {
        return periodRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable) {
        Page<PeriodEntity> periodPages = periodRepository
                .findAllPeriodEntityPagesOrderByCreateDateDesc(pageable);;
        return periodPages;
    }

    @Override
    public PeriodEntity findPeriodEntityByPeriodWebServicePublicId(String periodPublicId) {

        PeriodEntity period = periodRepository.findByPeriodWebService_PeriodPublicId(periodPublicId);
        return period;
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
        List<PeriodOnly> newPeriodOnlyList;
        List<PeriodEntity> newPeriods = new ArrayList<>();
        List<Long> oldPeriodIds = periodWebServiceEntities.stream().map(PeriodWebServiceEntity::getPeriodId).collect(Collectors.toList());

        allPeriodOnlyList = periodRepository.findBy();

        Map<Long, List<PeriodOnly>> allPeriodOnlyMap = allPeriodOnlyList.stream().collect(Collectors.groupingBy(PeriodOnly::getId));

        Map<Long, List<PeriodOnly>> newPeriodOnlyMap = allPeriodOnlyMap
                .entrySet()
                .stream()
                .filter(Objects::nonNull)
                .filter(e -> !oldPeriodIds.stream().collect(Collectors.toSet()).contains(e.getKey()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        newPeriodOnlyList = newPeriodOnlyMap.values().stream().flatMap(List::stream).collect(Collectors.toList());

        newPeriods = periodOnlyMapperOld.PeriodOnliesToPeriodEntities(newPeriodOnlyList, new CycleAvoidingMappingContext());

        return newPeriods;
    }

    @Override
    public List<PeriodFastDto> findAllPeriodFastDtoByIds(List<Long> periodIds) {

        List<PeriodFastDto> periodFastDtos;
        List<PeriodEntity> periodEntities = StreamSupport
                .stream(periodRepository.findAllById(periodIds).spliterator(),false)
                .collect(Collectors.toList());

        periodFastDtos = periodFastDtoMapper.PeriodEntitiesToPeriodFastDtoes(periodEntities,new CycleAvoidingMappingContext());

        return periodFastDtos;
    }

/*    @Override
    public Page<PeriodDto> findAllPeriodsPageable(Pageable pageable) {

        Page<PeriodEntity> periodPageable = periodRepository.findAll(pageable);
        Page<PeriodDto> periodDtoPageable;

        periodDtoPageable = periodPageable.map(period -> periodMapper.PeriodEntityToPeriodDto(period, new CycleAvoidingMappingContext()));

        return periodDtoPageable;
    }*/

    public List<PeriodEntity> findAllPeriodOnly() {
        List<PeriodOnly> allPeriodOnlies = periodRepository.findAllPeriodOnly();
        allPeriodOnlies.sort(Comparator.comparing(PeriodOnly::getId));
        List<PeriodEntity> allPeriods = periodOnlyMapperOld.PeriodOnliesToPeriodEntities(allPeriodOnlies, new CycleAvoidingMappingContext());
        return allPeriods;
    }

    @Override
    public List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id) {
        List<PeriodOnly> allPeriodOnlines = periodRepository.findPeriodOnlyByIdGreaterThan(id);
        List<PeriodEntity> allPeriods = periodOnlyMapperOld.PeriodOnliesToPeriodEntities(allPeriodOnlines, new CycleAvoidingMappingContext());
        return allPeriods;
    }


}
