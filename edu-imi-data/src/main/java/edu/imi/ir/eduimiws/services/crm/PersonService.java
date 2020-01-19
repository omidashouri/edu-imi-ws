package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;


public interface PersonService {

    PersonEntity findByUserName(String userName);

    PersonEntity findByContactId(Long contactId);
}
