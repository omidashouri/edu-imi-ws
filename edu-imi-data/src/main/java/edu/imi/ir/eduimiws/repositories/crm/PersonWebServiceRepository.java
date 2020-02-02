package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonWebServiceRepository extends PagingAndSortingRepository<PersonWebServiceEntity,Long> {

    PersonWebServiceEntity findByPersonId(Long personId);

    @EntityGraph("personWebServiceFastGraph")
    PersonWebServiceEntity findByUserName(String userName);

    PersonWebServiceEntity findByPersonPublicId(String personPublicId);

}
