package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import edu.imi.ir.eduimiws.domain.edu.LevelEntity;

import java.util.List;

public interface LevelApiService {

    LevelApiEntity selectLastRecord();

    Long levelApiCount();

    List<LevelApiEntity> generateLevelApiPublicId(List<LevelEntity> newLevelEntities);

    List<LevelApiEntity> findAllByLevelIdIn(List<Long> levelIds);
}
