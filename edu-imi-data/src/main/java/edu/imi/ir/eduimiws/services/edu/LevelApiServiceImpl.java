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
        return levelApiRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Long levelApiCount() {
        return levelApiRepository.count();
    }

    @Override
    public List<LevelApiEntity> generateLevelApiPublicId(List<LevelEntity> newLevelEntities) {
        List<LevelApiEntity> newLevelApis = new ArrayList<>();
        newLevelApis = levelApiLevelEntityHandlePublicIdMapper
                .toLevelApis(newLevelEntities, new CycleAvoidingMappingContext());
        newLevelApis.sort(Comparator.comparing(LevelApiEntity::getLevelId));
        levelApiRepository.saveAll(newLevelApis);
        return newLevelApis;
    }

    @Override
    public List<LevelApiEntity> findAllByLevelIdIn(List<Long> levelIds) {
        List<LevelApiEntity> levelApis = levelApiRepository
                .findAllByLevelIdIn(levelIds);
        return levelApis;
    }
}
