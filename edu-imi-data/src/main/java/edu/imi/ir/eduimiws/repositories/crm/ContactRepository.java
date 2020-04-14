package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity,Long> {
//NU
//    List<ContactEntity> findAllByPersonsIn(List<PersonEntity> personEntities);

      Long countByNationCode(String nationCode);

      @Query(value = " select c from ContactEntity c " +
              " left join fetch c.contactWebService cw " +
              " left join fetch c.persons p  where c.nationCode = :nationCode" ,
              countQuery = "select count(c) from ContactEntity c " +
                      " left join c.contactWebService cw " +
                      " left join c.persons p where c.nationCode = :nationCode"
      )
      List<ContactEntity> findContactEntitiesByNationCode(@Param("nationCode") String nationalCode);

      @Query(value = " select c from ContactEntity c " +
              " left join fetch c.contactWebService cw ",
              countQuery = "select count(c) from ContactEntity c " +
                      " left join c.contactWebService cw "
      )
      Page<ContactEntity> findAllContactEntityPages(Pageable pageable);
}
