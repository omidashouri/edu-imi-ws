package edu.imi.ir.eduimiws.services.crm;


import com.querydsl.core.types.Predicate;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.ContactForPaymentCodeProjectionContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.ContactMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactDto;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.models.projections.crm.ContactForPaymentCodeProjection;
import edu.imi.ir.eduimiws.repositories.crm.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
//    private final ContactQueryDslRepository contactQueryDslRepository;
    private final ContactFastDtoMapper contactFastDtoMapper;
    private final ContactForPaymentCodeProjectionContactFastDtoMapper contactForPaymentCodeProjectionContactFastDtoMapper;
    private final ContactMapper contactMapper;

    @Override
    public List<ContactFastDto> findContactByNationalCode(String nationalCode) {
        log.info("ContactService.findContactByNationalCode - nationalCode: {}", nationalCode);
        List<ContactEntity> contactEntities = contactRepository
                .findContactEntitiesByNationCode(nationalCode);

        List<ContactFastDto> contactFastDtos = contactFastDtoMapper
                .toContactFastDtos(contactEntities, new CycleAvoidingMappingContext());
        log.info("ContactService.findContactByNationalCode - resultSize: {}",
                contactFastDtos == null ? null : contactFastDtos.size());
        return contactFastDtos;
    }

    @Override
    public Page<ContactFastDto> findContactByNationalCodeForPaymentCode(String nationalCode, Pageable pageable) {
        log.info("ContactService.findContactByNationalCodeForPaymentCode - nationalCode: {}, pageable: {}",
                nationalCode, pageable);
        Page<ContactForPaymentCodeProjection> contactForPaymentCodeProjections = contactRepository
                .queryPageableContactForPaymentCodeProjection(null, null, nationalCode, null,
                        null, null, null, null, null, pageable);

        Page<ContactFastDto> result = contactForPaymentCodeProjections
                .map(contactForPaymentCodeProjectionContactFastDtoMapper::contactForPaymentCodeProjectionToContactFastDto);
        log.info("ContactService.findContactByNationalCodeForPaymentCode - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public ContactFastDto updateContactForPaymentCode(ContactFastDto newContactFastDto, ContactEntity editableContact) {
        log.info("ContactService.updateContactForPaymentCode - newContactFastDto: {}, editableContact: {}",
                newContactFastDto, editableContact);

        contactFastDtoMapper.updateContactByContactFactDtoForPaymentCode(newContactFastDto, editableContact);

        ContactEntity updatedContact = contactRepository.save(editableContact);

        ContactFastDto result = contactFastDtoMapper.toContactFastDto(updatedContact, new CycleAvoidingMappingContext());
        log.info("ContactService.updateContactForPaymentCode - result: {}", result);
        return result;

    }

    @Override
    public ContactFastDto createContactForPaymentCode(ContactFastDto newContactFastDto) {
        log.info("ContactService.createContactForPaymentCode - newContactFastDto: {}", newContactFastDto);

        ContactEntity newContact = contactFastDtoMapper
                .updateContactByContactFactDtoForPaymentCode(newContactFastDto);

        ContactEntity savedContact = contactRepository.save(newContact);

        ContactFastDto result = contactFastDtoMapper.toContactFastDto(savedContact, new CycleAvoidingMappingContext());
        log.info("ContactService.createContactForPaymentCode - result: {}", result);
        return result;
    }

    @Override
    public Long getContactNumberByNationalCode(String nationalCode) {
        log.info("ContactService.getContactNumberByNationalCode - nationalCode: {}", nationalCode);

        Long contactCount = contactRepository
                .countByNationCode(nationalCode);
        log.info("ContactService.getContactNumberByNationalCode - result: {}", contactCount);
        return contactCount;
    }

    @Override
    public Page<ContactEntity> findAllContactEntityPages(Pageable pageable) {
        log.info("ContactService.findAllContactEntityPages - pageable: {}", pageable);
        Page<ContactEntity> contactPages = contactRepository
                .findAll(pageable);
        log.info("ContactService.findAllContactEntityPages - resultSize: {}, totalElements: {}",
                contactPages == null ? null : contactPages.getNumberOfElements(),
                contactPages == null ? null : contactPages.getTotalElements());
        return contactPages;
    }

    @Override
    public ContactEntity findContactEntityByContactApiPublicId(String contactPublicId) {
        log.info("ContactService.findContactEntityByContactApiPublicId - contactPublicId: {}", contactPublicId);
        ContactEntity contact = contactRepository
                .findByContactWebService_ContactPublicId(contactPublicId);
        log.info("ContactService.findContactEntityByContactApiPublicId - result: {}", contact);
        return contact;
    }

    @Override
    public ContactDto findContactDtoByContactApiPublicId(String contactPublicId) {
        log.info("ContactService.findContactDtoByContactApiPublicId - contactPublicId: {}", contactPublicId);
        ContactDto result = contactMapper
                .toContactDto(this.findContactEntityByContactApiPublicId(contactPublicId),
                        new CycleAvoidingMappingContext());
        log.info("ContactService.findContactDtoByContactApiPublicId - result: {}", result);
        return result;
    }

    @Override
    public List<ContactEntity> findCotactsByIds(List<Long> contactIds) {
        log.info("ContactService.findCotactsByIds - contactIds: {}", contactIds);
        List<ContactEntity> contacts = contactRepository
                .findByIdIn(contactIds);
        log.info("ContactService.findCotactsByIds - resultSize: {}", contacts == null ? null : contacts.size());
        return contacts;
    }

    @Override
    public ContactFastDto findContactById(Long contactId) {
        log.info("ContactService.findContactById - contactId: {}", contactId);
        ContactEntity contact = contactRepository.readById(contactId);
        ContactFastDto contactFastDto = Optional.of(contact)
                .filter(Objects::nonNull)
                .map(ce -> contactFastDtoMapper.toContactFastDto(ce, new CycleAvoidingMappingContext()))
                .orElse(new ContactFastDto());
        log.info("ContactService.findContactById - result: {}", contactFastDto);
        return contactFastDto;
    }

    @Override
    public ContactEntity saveContact(ContactEntity newContact) {
        log.info("ContactService.saveContact - newContact: {}", newContact);
        ContactEntity result = contactRepository.save(newContact);
        log.info("ContactService.saveContact - result: {}", result);
        return result;
    }

    @Override
    public ContactEntity updateContact(ContactFastDto contactFastDto) {
        log.info("ContactService.updateContact - contactFastDto: {}", contactFastDto);
        ContactEntity contact;

        ContactEntity result = null;
        log.info("ContactService.updateContact - result: {}", result);
        return result;
    }

    @Override
    public Long countByPredicate(Predicate predicate) {
        log.info("ContactService.countByPredicate - predicate: {}", predicate);
//        Object o = contactQueryDslRepository.count(predicate);
//        Long contactCount = Long.valueOf(contactQueryDslRepository.count(predicate));
//        return contactCount != null ? contactCount.longValue() : null;
        Long result = null;
        log.info("ContactService.countByPredicate - result: {}", result);
        return result;
    }

    @Override
    public Page<ContactEntity> findAllByPredicate(Predicate predicate, Pageable pageable) {
        log.info("ContactService.findAllByPredicate - predicate: {}, pageable: {}", predicate, pageable);
//        later check usage
/*        Page<ContactEntity> contactPages = contactQueryDslRepository.findAll(predicate, pageable);
        return contactPages;*/
        Page<ContactEntity> result = null;
        log.info("ContactService.findAllByPredicate - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

//NU
/*    @Override
    public ContactEntity findContactEntityById(Long id) {
        return contactRepository.findById(id).orElseThrow(()-> new UserServiceException("contact not found"));
    }
//NU
    @Override
    public List<ContactEntity> findAllByPersons(List<PersonEntity> personEntities) {
        return contactRepository.findAllByPersonsIn(personEntities);
    }*/
}
