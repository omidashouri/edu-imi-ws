package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.LevelDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.LevelProjectionLevelDtoMapper;
import edu.imi.ir.eduimiws.models.dto.edu.LevelDto;
import edu.imi.ir.eduimiws.models.projections.edu.LevelProjection;
import edu.imi.ir.eduimiws.repositories.edu.LevelRepository;
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
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final LevelDtoMapper levelDtoMapper;
    private final LevelProjectionLevelDtoMapper levelProjectionLevelDtoMapper;

    @Override
    public Long countLevelByIdLessThanEqual(Long levelId) {
        Long levelCount = levelRepository.countByIdLessThanEqual(levelId);
        return levelCount;
    }

    @Override
    public LevelEntity selectLastRecord() {
        return levelRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Page<LevelEntity> findAllByOrderPageable(Pageable pageable) {
        Page<LevelEntity> levelPages = levelRepository
                .readBy(pageable);
        return levelPages;

    }

    @Override
    public LevelEntity findByLevelPublicId(String levelPublicId) {
        LevelEntity level = levelRepository
                .findByLevelApi_LevelPublicId(levelPublicId);
        return level;
    }

    @Override
    public List<LevelEntity> findAllLevelProjectionByIdBetween(Long startId, Long endId) {
        List<LevelProjection> allLevelProjections = levelRepository
                .findAllByIdBetween(startId, endId);
        List<LevelDto> levelDtos = levelProjectionLevelDtoMapper
                .toLevelDtos(allLevelProjections, new CycleAvoidingMappingContext());
        List<LevelEntity> allLevels = levelDtoMapper
                .toLevelEntities(levelDtos, new CycleAvoidingMappingContext());
        return allLevels;
    }

    @Override
    public List<LevelEntity> selectAllLevelProjection() {
        List<LevelProjection> levelProjections = levelRepository
                .findBy();
        levelProjections.sort(Comparator.comparing(LevelProjection::getId));
        List<LevelDto> levelDtos = levelProjectionLevelDtoMapper
                .toLevelDtos(levelProjections, new CycleAvoidingMappingContext());
        List<LevelEntity> allLevels = levelDtoMapper
                .toLevelEntities(levelDtos, new CycleAvoidingMappingContext());
        return allLevels;
    }

    @Override
    public List<LevelEntity> findAllByLevelDescription(String levelDescription) {
        List<LevelEntity> levels = levelRepository
                .findAllByDescriptionContains(levelDescription);
        return levels;
    }

    @Override
    public LevelEntity findFirstByIdLessThanOrderByIdDesc(Long levelId) {
        LevelEntity level = levelRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(levelId);
        return level;
    }

    @Override
    public Long selectLevelLastSequenceNumber() {
        return levelRepository.selectLastSequenceNumber();
    }
}
