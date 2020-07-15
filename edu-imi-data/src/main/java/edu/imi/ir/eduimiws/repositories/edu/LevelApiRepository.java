package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelApiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LevelApiRepository extends CrudRepository<LevelApiEntity, Long> {

    List<LevelApiEntity> findAll();

    LevelApiEntity findFirstByOrderByIdDesc();
}