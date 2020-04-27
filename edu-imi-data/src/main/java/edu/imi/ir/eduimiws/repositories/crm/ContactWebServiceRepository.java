package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactWebServiceRepository extends CrudRepository<ContactApiEntity,Long> {


    @EntityGraph("contactWebServiceUserGraph")
    ContactApiEntity findByContact(ContactEntity contact);
//    ContactApiEntity saveContactWebServiceByPublicContactIdAndPersonEntity

}
