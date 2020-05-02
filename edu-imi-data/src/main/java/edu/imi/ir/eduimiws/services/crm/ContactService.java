package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {

//NU
/*    ContactEntity findContactEntityById(Long id);
//NU
    List<ContactEntity> findAllByPersons(List<PersonEntity> personEntities);*/

    List<ContactFastDto> findContactByNationalCode(String nationalCode);

    Long getContactNumberByNationalCode(String nationalCode);

    Page<ContactEntity> findAllContactEntityPages(Pageable pageable);

    ContactEntity findContactEntityByContactApiPublicId(String contactPublicId);

    List<ContactEntity> findCotactsByIds(List<Long> contactIds);

    ContactEntity saveContact(ContactEntity newContact);

}


