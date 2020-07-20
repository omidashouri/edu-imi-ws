package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EduCategoryApiRepository extends CrudRepository<EduCategoryApiEntity, Long> {

    List<EduCategoryApiEntity> findAll();

    EduCategoryApiEntity findFirstByOrderByIdDesc();

    List<EduCategoryApiEntity> findAllByEduCategoryIdIn(List<Long> eduCategoryIds);
}
