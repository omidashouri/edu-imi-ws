package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity,Long> {
//NU
//    List<ContactEntity> findAllByPersonsIn(List<PersonEntity> personEntities);

      Long countByNationCode(String nationCode);

      List<ContactEntity> findContactEntitiesByNationCode(String nationalCodes);
}
