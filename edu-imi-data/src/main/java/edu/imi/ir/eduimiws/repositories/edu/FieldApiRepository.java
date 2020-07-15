package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldApiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FieldApiRepository extends CrudRepository<FieldApiEntity, Long> {

    List<FieldApiEntity> findAll();

    FieldApiEntity findFirstByOrderByIdDesc();
}
