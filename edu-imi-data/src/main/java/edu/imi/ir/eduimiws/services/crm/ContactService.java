package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@MappingUtil.ContactService
public interface ContactService {

//NU
/*    ContactEntity findContactEntityById(Long id);
//NU
    List<ContactEntity> findAllByPersons(List<PersonEntity> personEntities);*/

    List<ContactFastDto> findContactByNationalCode(String nationalCode);

    Page<ContactFastDto> findContactByNationalCodeForPaymentCode(String nationalCode, Pageable pageable);

    ContactFastDto updateContactForPaymentCode(ContactFastDto newContactFastDto, ContactEntity editableContact);

    ContactFastDto createContactForPaymentCode(ContactFastDto newContactFastDto);

    Long getContactNumberByNationalCode(String nationalCode);

    Page<ContactEntity> findAllContactEntityPages(Pageable pageable);

    ContactEntity findContactEntityByContactApiPublicId(String contactPublicId);

    @MappingUtil.ContactPublicIdToContactDto
    ContactDto findContactDtoByContactApiPublicId(String contactPublicId);

    List<ContactEntity> findCotactsByIds(List<Long> contactIds);

    ContactFastDto findContactById(Long contactId);

    ContactEntity saveContact(ContactEntity newContact);

    ContactEntity updateContact(ContactFastDto contactFastDto);

    Long countBySpecification(Specification<ContactEntity> specification);

    Page<ContactEntity> findAllBySpecification(Specification<ContactEntity> specification, Pageable pageable);

}
