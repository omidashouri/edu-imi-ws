package edu.imi.ir.eduimiws.services.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodOnlyMapper;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import edu.imi.ir.eduimiws.repositories.edu.PeriodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

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

    public List<PeriodEntity> findAllPeriodOnly() {
        List<PeriodOnly> allPeriodOnlys = periodRepository.findAllPeriodOnly();
        allPeriodOnlys.sort(Comparator.comparing(PeriodOnly::getId));
        List<PeriodEntity> allPeriods = periodOnlyMapper.PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        return allPeriods;
    }

    @Override
    public List<PeriodEntity> findAllPeriodOnlyByIdGreaterThan(Long id) {
        List<PeriodOnly> allPeriodOnlys = periodRepository.findPeriodOnlyByIdGreaterThan(id);
        List<PeriodEntity> allPeriods = periodOnlyMapper.PeriodOnliesToPeriodEntities(allPeriodOnlys, new CycleAvoidingMappingContext());
        return allPeriods;
    }

    @Override
    public Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNull() {
        Iterable<PeriodEntity> periodEntities =
                periodRepository.findAllByDeleteStatusIsNotNullAndExecuterIsNotNull();
        return periodEntities;
    }

    @Override
    public Page<PeriodEntity> findAllPageableByExecutorPublicId(Pageable pageable,String executorPublicId) {
        Page<PeriodEntity> pageablePeriods =
                periodRepository
                        .findByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonWebServiceEntity_PersonPublicId
                                (pageable,executorPublicId);
        return pageablePeriods;
    }


}
