package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.LevelApiLevelEntityHandlePublicIdMapper;
import edu.imi.ir.eduimiws.repositories.edu.LevelApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LevelApiServiceImpl implements LevelApiService{

    private final LevelApiRepository levelApiRepository;
    private final LevelApiLevelEntityHandlePublicIdMapper levelApiLevelEntityHandlePublicIdMapper;


    @Override
    public LevelApiEntity selectLastRecord() {
        log.info("LevelApiService.selectLastRecord - start");
        LevelApiEntity result = levelApiRepository.findFirstByOrderByIdDesc();
        log.info("LevelApiService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Long levelApiCount() {
        log.info("LevelApiService.levelApiCount - start");
        Long result = levelApiRepository.count();
        log.info("LevelApiService.levelApiCount - result: {}", result);
        return result;
    }

    @Override
    public List<LevelApiEntity> generateLevelApiPublicId(List<LevelEntity> newLevelEntities) {
        log.info("LevelApiService.generateLevelApiPublicId - newLevelEntities: {}", newLevelEntities);
        List<LevelApiEntity> newLevelApis = new ArrayList<>();
        newLevelApis = levelApiLevelEntityHandlePublicIdMapper
                .toLevelApis(newLevelEntities, new CycleAvoidingMappingContext());
        newLevelApis.sort(Comparator.comparing(LevelApiEntity::getLevelId));
        levelApiRepository.saveAll(newLevelApis);
        log.info("LevelApiService.generateLevelApiPublicId - resultSize: {}", newLevelApis == null ? null : newLevelApis.size());
        return newLevelApis;
    }

    @Override
    public List<LevelApiEntity> findAllByLevelIdIn(List<Long> levelIds) {
        log.info("LevelApiService.findAllByLevelIdIn - levelIds: {}", levelIds);
        List<LevelApiEntity> result = levelApiRepository
                .findAllByLevelIdIn(levelIds);
        log.info("LevelApiService.findAllByLevelIdIn - resultSize: {}", result == null ? null : result.size());
        return result;
    }
}
