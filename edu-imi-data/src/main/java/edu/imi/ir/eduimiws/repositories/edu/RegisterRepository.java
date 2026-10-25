package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import edu.imi.ir.eduimiws.models.projections.edu.RegisterOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterEntity, Long> {

//    @EntityGraph(attributePaths = {"registerApi"})
    Page<RegisterEntity> findAllByDeleteStatusIsNotNull(Pageable pageable);

    @EntityGraph(attributePaths = {"registerApi"})
    List<RegisterEntity> findTop10ByDeleteStatusIsNotNull();

    @RestResource(path = "findAllByDeleteStatusIsNotNullList", rel = "findAllByDeleteStatusIsNotNullList")
    @EntityGraph(attributePaths = {"registerApi"})
    List<RegisterEntity> findAllByDeleteStatusIsNotNull();

    @EntityGraph(value = "RegisterEntity.findRegisterSubGraphStudentApiServiceAndPeriodApiService",
            type = EntityGraph.EntityGraphType.LOAD)
    Page<RegisterEntity> readAllByDeleteStatusIsNotNull(Pageable pageable);

    RegisterEntity findByRegisterApi_RegisterPublicIdAndDeleteStatusNotNull(String studentPublicId);

    @EntityGraph(value = "RegisterEntity.findRegisterSubGraphStudentApiServiceAndPeriodApiService",
            type = EntityGraph.EntityGraphType.LOAD)
    RegisterEntity readByRegisterApi_RegisterPublicIdAndDeleteStatusNotNull(String studentPublicId);

    RegisterEntity findFirstByOrderByIdDesc();

    RegisterEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

    @Query(name = "RegisterEntity.selectAllRegisterOnlyByIdBetween", nativeQuery = true)
    List<RegisterOnly> findAllRegisterOnlyByIdBetween(@Param("beginRegisterId") Long beginRegisterId,
                                                           @Param("endRegisterId") Long endRegisterId);

    @Query(name = "RegisterEntity.selectAllRegisterOnly", nativeQuery = true)
    List<RegisterOnly> findAllRegisterOnly();

    @Query(name = "RegisterEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long registerId);

}
