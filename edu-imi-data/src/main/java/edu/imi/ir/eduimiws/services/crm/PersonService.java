package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;


public interface PersonService {
//NU
/*    PersonEntity findById(Long id);
//NU
    List<PersonEntity> findAllByUserNameContaining(String userName);
//NU
    PersonEntity findByContactId(Long contactId);*/

    PersonEntity findByUserNameFast(String userName);
}
