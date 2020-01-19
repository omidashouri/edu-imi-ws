package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactWebServiceRepository extends PagingAndSortingRepository<ContactWebServiceEntity,Long> {


//    ContactWebServiceEntity saveContactWebServiceByPublicContactIdAndPersonEntity

}
