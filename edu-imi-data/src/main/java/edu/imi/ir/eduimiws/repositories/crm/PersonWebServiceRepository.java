package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonWebServiceRepository extends CrudRepository<PersonWebServiceEntity,Long> {

    PersonWebServiceEntity findByPersonId(Long personId);

    @EntityGraph("personWebServiceFastGraph")
    PersonWebServiceEntity findByUserName(String userName);

    PersonWebServiceEntity findByPersonPublicId(String personPublicId);

    Page<PersonWebServiceEntity> findAll(Pageable pageable);

}
