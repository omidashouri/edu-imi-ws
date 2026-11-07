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
        log.info("LevelService.countLevelByIdLessThanEqual - levelId: {}", levelId);
        Long result = levelRepository.countByIdLessThanEqual(levelId);
        log.info("LevelService.countLevelByIdLessThanEqual - result: {}", result);
        return result;
    }

    @Override
    public LevelEntity selectLastRecord() {
        log.info("LevelService.selectLastRecord - start");
        LevelEntity result = levelRepository.findFirstByOrderByIdDesc();
        log.info("LevelService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Page<LevelEntity> findAllByOrderPageable(Pageable pageable) {
        log.info("LevelService.findAllByOrderPageable - pageable: {}", pageable);
        Page<LevelEntity> result = levelRepository
                .readBy(pageable);
        log.info("LevelService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;

    }

    @Override
    public LevelEntity findByLevelPublicId(String levelPublicId) {
        log.info("LevelService.findByLevelPublicId - levelPublicId: {}", levelPublicId);
        LevelEntity result = levelRepository
                .findByLevelApi_LevelPublicId(levelPublicId);
        log.info("LevelService.findByLevelPublicId - result: {}", result);
        return result;
    }

    @Override
    public List<LevelEntity> findAllLevelProjectionByIdBetween(Long startId, Long endId) {
        log.info("LevelService.findAllLevelProjectionByIdBetween - startId: {}, endId: {}", startId, endId);
        List<LevelProjection> allLevelProjections = levelRepository
                .findAllByIdBetween(startId, endId);
        List<LevelDto> levelDtos = levelProjectionLevelDtoMapper
                .toLevelDtos(allLevelProjections, new CycleAvoidingMappingContext());
        List<LevelEntity> result = levelDtoMapper
                .toLevelEntities(levelDtos, new CycleAvoidingMappingContext());
        log.info("LevelService.findAllLevelProjectionByIdBetween - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<LevelEntity> selectAllLevelProjection() {
        log.info("LevelService.selectAllLevelProjection - start");
        List<LevelProjection> levelProjections = levelRepository
                .findBy();
        levelProjections.sort(Comparator.comparing(LevelProjection::getId));
        List<LevelDto> levelDtos = levelProjectionLevelDtoMapper
                .toLevelDtos(levelProjections, new CycleAvoidingMappingContext());
        List<LevelEntity> result = levelDtoMapper
                .toLevelEntities(levelDtos, new CycleAvoidingMappingContext());
        log.info("LevelService.selectAllLevelProjection - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public List<LevelEntity> findAllByLevelDescription(String levelDescription) {
        log.info("LevelService.findAllByLevelDescription - levelDescription: {}", levelDescription);
        List<LevelEntity> result = levelRepository
                .findAllByDescriptionContains(levelDescription);
        log.info("LevelService.findAllByLevelDescription - resultSize: {}", result == null ? null : result.size());
        return result;
    }

    @Override
    public LevelEntity findFirstByIdLessThanOrderByIdDesc(Long levelId) {
        log.info("LevelService.findFirstByIdLessThanOrderByIdDesc - levelId: {}", levelId);
        LevelEntity result = levelRepository
                .findFirstByIdLessThanEqualOrderByIdDesc(levelId);
        log.info("LevelService.findFirstByIdLessThanOrderByIdDesc - result: {}", result);
        return result;
    }

    @Override
    public Long selectLevelLastSequenceNumber() {
        log.info("LevelService.selectLevelLastSequenceNumber - start");
        Long result = levelRepository.selectLastSequenceNumber();
        log.info("LevelService.selectLevelLastSequenceNumber - result: {}", result);
        return result;
    }
}
