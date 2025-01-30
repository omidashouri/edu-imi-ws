package edu.imi.ir.eduimiws.repositories.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import edu.imi.ir.eduimiws.models.projections.edu.FieldOnly;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.QueryHint;
import java.util.List;
@Repository
public interface FieldRepository extends CrudRepository<FieldEntity, Long> {

    @EntityGraph(value = "FieldEntity.findFieldSubGraphLevelApiServiceAndEduCategoryApiService", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_MODE, value = "PUT"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
    })
    Page<FieldEntity> findAll(Pageable pageable);

//    ERROR No property readAll found for type FieldEntity!
/*    @EntityGraph(value = "FieldEntity.findFieldSubGraphLevelApiServiceAndEduCategoryApiService", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
    Page<FieldEntity> readAll(Pageable pageable);*/

    @EntityGraph(value = "FieldEntity.findFieldSubGraphLevelApiServiceAndEduCategoryApiService", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_MODE, value = "PUT"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
    })
    FieldEntity findByFieldApi_FieldPublicId(String fieldPublicId);

    @Cacheable("fieldDescriptiveLevel")
    @EntityGraph(value = "FieldEntity.findFieldSubGraphLevelApiServiceAndEduCategoryApiService", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_MODE, value = "PUT"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
    })
    Page<FieldEntity> findByFieldApiIsNotNullAndFieldApi_LevelPublicId(String levelPublicId, Pageable pageable);

    @Cacheable("fieldDescriptiveEduCategory")
    @EntityGraph(value = "FieldEntity.findFieldSubGraphLevelApiServiceAndEduCategoryApiService", type = EntityGraph.EntityGraphType.LOAD)
    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FLUSH_MODE, value = "AUTO"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHE_MODE, value = "PUT"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"),
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_COMMENT, value = "use cache for named query")
    })
    Page<FieldEntity> findByFieldApiIsNotNullAndFieldApi_EduCategoryPublicId(String eduCategoryPublicId, Pageable pageable);

    @EntityGraph(value = "FieldEntity.findFieldSubGraphLevelApiServiceAndEduCategoryApiService", type = EntityGraph.EntityGraphType.LOAD)
    FieldEntity readByFieldApi_FieldPublicId(String fieldPublicId);

    FieldEntity findFirstByOrderByIdDesc();

    FieldEntity findFirstByIdLessThanEqualOrderByIdDesc(Long id);

    @Query(name = "FieldEntity.selectAllFieldOnlyByIdBetween", nativeQuery = true)
    List<FieldOnly> findAllFieldOnlyByIdBetween(@Param("beginFieldId") Long beginFieldId,
                                                @Param("endFieldId") Long endFieldId);

    @Query(name = "FieldEntity.selectAllFieldOnly", nativeQuery = true)
/*    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)*/
    List<FieldOnly> findAllFieldOnly();

    @Query(name = "FieldEntity.selectCurrentSequenceNumber",nativeQuery = true)
    Long selectLastSequenceNumber();

    Long countByIdLessThanEqual(Long fieldId);

}
