package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LevelApiRepository extends CrudRepository<LevelApiEntity, Long> {

    List<LevelApiEntity> findAll();

    LevelApiEntity findFirstByOrderByIdDesc();

    List<LevelApiEntity> findAllByLevelIdIn(List<Long> levelIds);
}