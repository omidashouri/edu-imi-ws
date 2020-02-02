package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;


public interface PersonService {

    PersonEntity findById(Long id);

    PersonEntity findByUserNameFast(String userName);

    List<PersonEntity> findAllByUserNameContaining(String userName);

    PersonEntity findByContactId(Long contactId);
}
