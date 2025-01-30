package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonApiIdProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.QueryHint;
import java.util.List;

@Repository
public interface PersonApiRepository extends CrudRepository<PersonApiEntity,Long> {

    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    PersonApiEntity findByPersonId(Long personId);

    @EntityGraph("PersonApiEntity.personApiFastGraph")
    PersonApiEntity findByUserName(String userName);

    PersonApiEntity findByPersonPublicId(String personPublicId);

    @EntityGraph(value = "PersonApiEntity.findPersonApiWithPersonRolePrivilegeSubGraph",
            type = EntityGraph.EntityGraphType.FETCH)
    @QueryHints(@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_READONLY, value = "true"))
    PersonApiEntity readByPersonPublicId(String personPublicId);

    Page<PersonApiEntity> findAll(Pageable pageable);

/*    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)*/
    @Query(name = "PersonApiEntity.findAllPersonApiIdProjection", nativeQuery = true)
    List<PersonApiIdProjection> findAllPersonApiIdProjection();

    PersonApiEntity findFirstByOrderByIdDesc();

    List<PersonApiEntity> findAllByPersonIdIn(List<Long> personIds);
}
