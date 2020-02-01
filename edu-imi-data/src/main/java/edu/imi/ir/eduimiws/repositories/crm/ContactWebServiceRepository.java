package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactWebServiceRepository extends PagingAndSortingRepository<ContactWebServiceEntity,Long> {


    @EntityGraph("contactWebServiceUserGraph")
    ContactWebServiceEntity findByContact(ContactEntity contact);
//    ContactWebServiceEntity saveContactWebServiceByPublicContactIdAndPersonEntity

}
