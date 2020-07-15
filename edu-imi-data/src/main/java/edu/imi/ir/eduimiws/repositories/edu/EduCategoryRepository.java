package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EduCategoryRepository extends CrudRepository<EduCategoryEntity, Long> {

    Page<EduCategoryEntity> findAll(Pageable pageable);

//    we can remove it
    Page<EduCategoryEntity> readAll(Pageable pageable);

    EduCategoryEntity findByEduCategoryApi_EduCategoryPublicId(String eduCategoryPublicId);

    //    we can remove it
    EduCategoryEntity readByEduCategoryApi_EduCategoryPublicId(String eduCategoryPublicId);

    EduCategoryEntity findFirstByOrderByIdDesc();

    EduCategoryEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

//    List<RegisterOnly>
    List<EduCategoryEntity> findAllByIdBetween(@Param("beginEduCategoryId") Long beginEduCategoryId,
                                                      @Param("endEduCategoryId") Long endEduCategoryId);

//    List<RegisterOnly> Duplicate
//    List<EduCategoryEntity> findAllByEduCategory();

    @Query(name = "EduCategoryEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long eduCategoryId);
}
