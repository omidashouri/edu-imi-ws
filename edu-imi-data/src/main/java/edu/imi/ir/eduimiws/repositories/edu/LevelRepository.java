package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.LevelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LevelRepository extends CrudRepository<LevelEntity, Long> {

    Page<LevelEntity> findAll(Pageable pageable);

//    No property readAll found for type LevelEntity!
    //    we can remove it
//    Page<LevelEntity> readAll(Pageable pageable);

    LevelEntity findByLevelApi_LevelPublicId(String levelPublicId);

    //    we can remove it
    LevelEntity readByLevelApi_LevelPublicId(String levelPublicId);

    LevelEntity findFirstByOrderByIdDesc();

    LevelEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

    //    List<RegisterOnly>
    List<LevelEntity> findAllByIdBetween(@Param("beginLevelId") Long beginLevelId,
                                               @Param("endLevelId") Long endLevelId);

//    List<RegisterOnly> Duplicate
//    List<LevelEntity> findAllByLevel();

    @Query(name = "LevelEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long levelId);
}
