package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomOne;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomTwo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface PeriodRepository extends CrudRepository<PeriodEntity, Long> {


    @Cacheable("period")
    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApiAndLevelAndEduCategoryAndExecutor",
            type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
//            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_REGION,value = "period"),
//            @QueryHint(name = org.hibernate.jpa.QueryHints.SPEC_HINT_TIMEOUT,value = "5000"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_MODE, value = "PUT"), //VERY IMPORTANT
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
    })
    Page<PeriodEntity>
    readAllByDeleteStatusIsNotNullAndDeleteStatusEqualsAndNameContains(Long deleteStatus,
                                                                       String periodName,
                                                                       Pageable pageable);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonApi",
            type = EntityGraph.EntityGraphType.LOAD)
    Page<PeriodEntity> findAllByDeleteStatusIsNotNullAndDeleteStatusEquals(Long deleteStatus, Pageable pageable);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApi", type = EntityGraph.EntityGraphType.LOAD)
//    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<PeriodEntity> findAllByPeriodApi_FieldPublicId(String fieldPublicId, Pageable pageable);

    @Query(value = "select p from PeriodEntity p " +
            " left join fetch p.executer ex left join fetch ex.personApiEntity pw " +
            " where p.deleteStatus = 1L ",
            countQuery = "select count(p) from PeriodEntity p " +
                    " left join p.executer ex left join ex.personApiEntity pw " +
                    " where p.deleteStatus = 1L "
    )
    Page<PeriodEntity> findAllPeriodEntityPagesOrderByCreateDateDesc(Pageable pageable);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonApi",
            type = EntityGraph.EntityGraphType.LOAD)
    PeriodEntity findByPeriodApi_PeriodPublicId(String periodPublicId);

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApi",
            type = EntityGraph.EntityGraphType.LOAD)
    List<PeriodEntity> findAllByIdIn(List<Long> periodIds);

    @Query(name = "PeriodEntity.selectAllPeriodOnly", nativeQuery = true)
    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)
    List<PeriodOnly> findAllPeriodOnly();

/*    @Query(name = "PeriodEntity.selectAllPeriodOnlyById", nativeQuery = true)
    @QueryHints(forCounting = true)
    List<PeriodOnly> findAllPeriodOnlyById(@Param("periodIds") List<Long> periodIds);*/

    @Query(name = "PeriodEntity.selectPeriodOnlyByIdGreaterThan", nativeQuery = true)
    List<PeriodOnly> findPeriodOnlyByIdGreaterThan(@Param("periodId") Long id);

    PeriodEntity findFirstByOrderByIdDesc();

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphExecutorPersonApi", type = EntityGraph.EntityGraphType.LOAD)
    Iterable<PeriodEntity> findAllByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntityIsNull();

    @EntityGraph(value = "PeriodEntity.findPeriodSubGraphFieldApiAndLevelAndEduCategoryAndExecutor",
            type = EntityGraph.EntityGraphType.LOAD)
    Page<PeriodEntity>
    findByDeleteStatusIsNotNullAndExecuterIsNotNullAndExecuter_PersonApiEntity_PersonPublicId
            (Pageable pageable, String executorPublicId);

    @Query(name = "PeriodEntity.selectAllPeriodOnlyByIdBetween", nativeQuery = true)
    List<PeriodOnly> findAllPeriodOnlyByIdBetween(@Param("beginPeriodId") Long beginPeriodId,
                                                  @Param("endPeriodId") Long endPeriodId);

    @Query(name = "PeriodEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long periodId);

    PeriodEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

    @Query(name = "PeriodEntity.querySelectAllPeriodCustomOne",
            countName = "PeriodEntity.querySelectAllPeriodCustomOne.count",
            nativeQuery = true)
    List<PeriodProjectionCustomOne> queryAllPeriodCustomOne(@Param("fieldPublicId") String fieldPublicId,
                                                            @Param("eduCategoryPublicId") String eduCategoryPublicId,
                                                            @Param("marja") String fieldCode,
                                                            @Param("nobat") Long periodOfferNumber,
                                                            @Param("periodName") String periodName,
                                                            @Param("fieldName") String fieldName,
                                                            @Param("eduCategoryName") String eduCategoryName,
                                                            @Param("periodStartDate") String periodStartDate,
                                                            @Param("periodEndDate") String periodEndDate,
                                                            @Param("registerStartDate") String registerStartDate,
                                                            @Param("registerEndDate") String registerEndDate,
                                                            @Param("periodMaxCapacity") Long periodMaxCapacity,
                                                            @Param("attendanceType") String periodHoldingType,
                                                            @Param("registerOnLine") String periodCanRegisterOnline,
                                                            @Param("termicType") String periodType,
                                                            @Param("periodFee") Long periodFee,
                                                            @Param("periodSchedule") String periodSchedule,
                                                            @Param("periodActivityStatus") Long periodActivityStatus,
                                                            @Param("periodDeleteStatus") Long periodDeleteStatus,
                                                            @Param("periodExecutorFirstName") String periodExecutorFirstName,
                                                            @Param("periodExecutorLastName") String periodExecutorLastName,
                                                            @Param("periodExecutorFullName") String periodExecutorFullName);


//    make periodPublicId mandatory
    @Query(name = "PeriodEntity.querySelectAllPeriodCustomOne",
            countName = "PeriodEntity.querySelectAllPeriodCustomOne.count",
            nativeQuery = true)
    PeriodProjectionCustomOne queryPeriodCustomOne(@Param("fieldPublicId") String fieldPublicId,
                                                            @Param("eduCategoryPublicId") String eduCategoryPublicId,
                                                            @Param("marja") String fieldCode,
                                                            @Param("nobat") Long periodOfferNumber,
                                                            @Param("periodName") String periodName,
                                                            @Param("fieldName") String fieldName,
                                                            @Param("eduCategoryName") String eduCategoryName,
                                                            @Param("periodStartDate") String periodStartDate,
                                                            @Param("periodEndDate") String periodEndDate,
                                                            @Param("registerStartDate") String registerStartDate,
                                                            @Param("registerEndDate") String registerEndDate,
                                                            @Param("periodMaxCapacity") Long periodMaxCapacity,
                                                            @Param("attendanceType") String periodHoldingType,
                                                            @Param("registerOnLine") String periodCanRegisterOnline,
                                                            @Param("termicType") String periodType,
                                                            @Param("periodFee") Long periodFee,
                                                            @Param("periodSchedule") String periodSchedule,
                                                            @Param("periodActivityStatus") Long periodActivityStatus,
                                                            @Param("periodDeleteStatus") Long periodDeleteStatus,
                                                            @Param("periodExecutorFirstName") String periodExecutorFirstName,
                                                            @Param("periodExecutorLastName") String periodExecutorLastName,
                                                            @Param("periodExecutorFullName") String periodExecutorFullName);


    @Query(name = "PeriodEntity.queryAllPeriodCustomTwo")
    Page<PeriodProjectionCustomTwo> queryAllPeriodCustomTwo(@Param("fieldPublicId") String fieldPublicId,
                                                            @Param("eduCategoryPublicId") String eduCategoryPublicId,
                                                            @Param("levelPublicId") String levelPublicId,
                                                            @Param("fieldCode") String fieldCode, //marja
                                                            @Param("periodOfferNumber") Long periodOfferNumber, //nobat
                                                            @Param("periodName") String periodName,
                                                            @Param("levelDescription") String levelDescription,
                                                            @Param("fieldName") String fieldName,
                                                            @Param("eduCategoryTitle") String eduCategoryTitle,
                                                            @Param("periodStartDate") String periodStartDate,
                                                            @Param("periodEndDate") String periodEndDate,
                                                            @Param("registerStartDate") String registerStartDate,
                                                            @Param("registerEndDate") String registerEndDate,
                                                            @Param("periodMaxCapacity") Long periodMaxCapacity,
                                                            @Param("periodHoldingType") String periodHoldingType,
                                                            @Param("periodCanRegisterOnline") String periodCanRegisterOnline,
                                                            @Param("periodType") String periodType, //termicType
                                                            @Param("periodFee") Long periodFee,
                                                            @Param("periodSchedule") String periodSchedule,
                                                            @Param("periodActivityStatus") Long periodActivityStatus,
                                                            @Param("periodDeleteStatus") Long periodDeleteStatus,
                                                            @Param("periodExecutorFirstName") String periodExecutorFirstName,
                                                            @Param("periodExecutorLastName") String periodExecutorLastName,
                                                            @Param("periodExecutorFullName") String periodExecutorFullName,
                                                            Pageable pageable);


}
