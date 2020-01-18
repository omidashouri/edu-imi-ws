package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonWebServiceRepository extends PagingAndSortingRepository<PersonWebServiceEntity,Long> {


}
