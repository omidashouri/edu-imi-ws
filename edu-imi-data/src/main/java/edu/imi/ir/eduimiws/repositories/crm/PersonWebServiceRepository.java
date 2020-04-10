package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.models.projections.crm.PersonWebServiceIdProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonWebServiceRepository extends CrudRepository<PersonWebServiceEntity,Long> {

    PersonWebServiceEntity findByPersonId(Long personId);

    @EntityGraph("personWebServiceFastGraph")
    PersonWebServiceEntity findByUserName(String userName);

    PersonWebServiceEntity findByPersonPublicId(String personPublicId);

    Page<PersonWebServiceEntity> findAll(Pageable pageable);

/*    @QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")},
            forCounting = true)*/
    @Query(name = "PersonWebServiceEntity.findAllPersonWebServiceIdProjection", nativeQuery = true)
    List<PersonWebServiceIdProjection> findAllPersonWebServiceIdProjection();

    PersonWebServiceEntity findFirstByOrderByIdDesc();
}
