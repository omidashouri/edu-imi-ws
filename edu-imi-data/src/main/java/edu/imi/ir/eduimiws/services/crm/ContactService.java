package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;


public interface ContactService {


    ContactEntity findContactEntityById(Long id);

    List<ContactEntity> findAllByPersons(List<PersonEntity> personEntities);


}


