package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EduCategoryApiRepository extends CrudRepository<EduCategoryApiEntity, Long> {

    List<EduCategoryApiEntity> findAll();

    EduCategoryApiEntity findFirstByOrderByIdDesc();
}
