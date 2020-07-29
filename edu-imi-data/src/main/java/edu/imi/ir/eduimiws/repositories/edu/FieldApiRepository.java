package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FieldApiRepository extends CrudRepository<FieldApiEntity, Long> {

    List<FieldApiEntity> findAll();

    FieldApiEntity findFirstByOrderByIdDesc();

    List<FieldApiEntity> findAllByFieldIdIn(List<Long> fieldIds);
}
