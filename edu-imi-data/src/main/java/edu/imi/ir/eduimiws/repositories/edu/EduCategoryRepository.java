package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.models.projections.edu.EduCategoryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EduCategoryRepository extends CrudRepository<EduCategoryEntity, Long> {

    Page<EduCategoryEntity> findAll(Pageable pageable);

//    we can remove it
//    Page<EduCategoryEntity> readAll(Pageable pageable);

    EduCategoryEntity findByEduCategoryApi_EduCategoryPublicId(String eduCategoryPublicId);

    //    we can remove it
//    EduCategoryEntity readByEduCategoryApi_EduCategoryPublicId(String eduCategoryPublicId);

    EduCategoryEntity findFirstByOrderByIdDesc();

    EduCategoryEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

    //    List<RegisterOnly>
    List<EduCategoryProjection> findAllByIdBetween(@Param("beginEduCategoryId") Long beginEduCategoryId,
                                                   @Param("endEduCategoryId") Long endEduCategoryId);

    List<EduCategoryEntity> findAllByTitleContains(String eduCategoryTitle);

//    List<RegisterOnly> Duplicate
//    List<EduCategoryEntity> findAllByEduCategory();

    List<EduCategoryProjection> findBy();

    @Query(name = "EduCategoryEntity.selectCurrentSequenceNumber", nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long eduCategoryId);
}
