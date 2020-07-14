package edu.imi.ir.eduimiws.repositories.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactApiRepository extends CrudRepository<ContactApiEntity,Long> {


    @EntityGraph("contactApiUserGraph")
    ContactApiEntity findByContact(ContactEntity contact);
//    ContactApiEntity saveContactWebServiceByPublicContactIdAndPersonEntity

}
