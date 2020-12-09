package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LevelService {

    Long countLevelByIdLessThanEqual(Long eduCategoryId);

    LevelEntity selectLastRecord();

    Page<LevelEntity> findAllByOrderPageable(Pageable pageable);

    LevelEntity findByLevelPublicId(String levelPublicId);

    List<LevelEntity> findAllLevelProjectionByIdBetween(Long startId, Long endId);

    List<LevelEntity> selectAllLevelProjection();

    List<LevelEntity> findAllByLevelDescription(String levelDescription);

    LevelEntity findFirstByIdLessThanOrderByIdDesc(Long levelId);

    Long selectLevelLastSequenceNumber();
}
