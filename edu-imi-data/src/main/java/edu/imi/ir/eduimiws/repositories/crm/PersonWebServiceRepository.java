package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonWebServiceIdProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonWebServiceRepository extends CrudRepository<PersonApiEntity,Long> {

    PersonApiEntity findByPersonId(Long personId);

    @EntityGraph("personWebServiceFastGraph")
    PersonApiEntity findByUserName(String userName);

    PersonApiEntity findByPersonPublicId(String personPublicId);

    Page<PersonApiEntity> findAll(Pageable pageable);

/*    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)*/
    @Query(name = "PersonApiEntity.findAllPersonWebServiceIdProjection", nativeQuery = true)
    List<PersonWebServiceIdProjection> findAllPersonWebServiceIdProjection();

    PersonApiEntity findFirstByOrderByIdDesc();

    List<PersonApiEntity> findAllByPersonIdIn(List<Long> personIds);
}
