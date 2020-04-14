package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;

import java.util.List;

public interface ContactService {

//NU
/*    ContactEntity findContactEntityById(Long id);
//NU
    List<ContactEntity> findAllByPersons(List<PersonEntity> personEntities);*/

    List<ContactFastDto> findContactByNationalCode(String nationalCode);

    Long getContactNumberByNationalCode(String nationalCode);

}


