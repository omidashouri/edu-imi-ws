package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterApiRepository extends CrudRepository<RegisterApiEntity, Long> {

    List<RegisterApiEntity> findAll();

    RegisterApiEntity findFirstByOrderByIdDesc();
}
