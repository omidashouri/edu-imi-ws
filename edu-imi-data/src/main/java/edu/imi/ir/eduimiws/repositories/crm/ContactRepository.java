package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity,Long> {
//NU
//    List<ContactEntity> findAllByPersonsIn(List<PersonEntity> personEntities);

      Long countByNationCode(String nationCode);

      @EntityGraph(value = "ContactEntity.findContactEntitiesByNationCode",type = EntityGraph.EntityGraphType.LOAD)
      List<ContactEntity> findContactEntitiesByNationCode(@Param("nationCode") String nationalCode);

      Page<ContactEntity> findAll(Pageable pageable);
}
