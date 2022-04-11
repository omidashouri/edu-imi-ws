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
import edu.imi.ir.eduimiws.repositories.crm.querydsl.ContactQueryDslRepository;
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
    private final ContactQueryDslRepository contactQueryDslRepository;
    private final ContactFastDtoMapper contactFastDtoMapper;
    private final ContactForPaymentCodeProjectionContactFastDtoMapper contactForPaymentCodeProjectionContactFastDtoMapper;
    private final ContactMapper contactMapper;

    @Override
    public List<ContactFastDto> findContactByNationalCode(String nationalCode) {
        List<ContactEntity> contactEntities = contactRepository
                .findContactEntitiesByNationCode(nationalCode);

        List<ContactFastDto> contactFastDtos = contactFastDtoMapper
                .toContactFastDtos(contactEntities, new CycleAvoidingMappingContext());
        return contactFastDtos;
    }

    @Override
    public Page<ContactFastDto> findContactByNationalCodeForPaymentCode(String nationalCode, Pageable pageable) {
        Page<ContactForPaymentCodeProjection> contactForPaymentCodeProjections = contactRepository
                .queryPageableContactForPaymentCodeProjection(null, null, nationalCode, null,
                        null, null, null, null, null, pageable);

        return contactForPaymentCodeProjections
                .map(contactForPaymentCodeProjectionContactFastDtoMapper::contactForPaymentCodeProjectionToContactFastDto);
    }

    @Override
    public ContactFastDto updateContactForPaymentCode(ContactFastDto newContactFastDto, ContactEntity editableContact) {

        contactFastDtoMapper.updateContactByContactFactDtoForPaymentCode(newContactFastDto, editableContact);

        ContactEntity updatedContact = contactRepository.save(editableContact);

        return contactFastDtoMapper.toContactFastDto(updatedContact, new CycleAvoidingMappingContext());

    }

    @Override
    public ContactFastDto createContactForPaymentCode(ContactFastDto newContactFastDto) {

        ContactEntity newContact = contactFastDtoMapper
                .updateContactByContactFactDtoForPaymentCode(newContactFastDto);

        ContactEntity savedContact = contactRepository.save(newContact);

        return contactFastDtoMapper.toContactFastDto(savedContact, new CycleAvoidingMappingContext());
    }

    @Override
    public Long getContactNumberByNationalCode(String nationalCode) {

        Long contactCount = contactRepository
                .countByNationCode(nationalCode);
        return contactCount;
    }

    @Override
    public Page<ContactEntity> findAllContactEntityPages(Pageable pageable) {
        Page<ContactEntity> contactPages = contactRepository
                .findAll(pageable);
        return contactPages;
    }

    @Override
    public ContactEntity findContactEntityByContactApiPublicId(String contactPublicId) {
        ContactEntity contact = contactRepository
                .findByContactWebService_ContactPublicId(contactPublicId);
        return contact;
    }

    @Override
    public ContactDto findContactDtoByContactApiPublicId(String contactPublicId) {
        return contactMapper
                .toContactDto(this.findContactEntityByContactApiPublicId(contactPublicId),
                        new CycleAvoidingMappingContext());
    }

    @Override
    public List<ContactEntity> findCotactsByIds(List<Long> contactIds) {
        List<ContactEntity> contacts = contactRepository
                .findByIdIn(contactIds);
        return contacts;
    }

    @Override
    public ContactFastDto findContactById(Long contactId) {
        ContactEntity contact = contactRepository.readById(contactId);
        ContactFastDto contactFastDto = Optional.of(contact)
                .filter(Objects::nonNull)
                .map(ce -> contactFastDtoMapper.toContactFastDto(ce, new CycleAvoidingMappingContext()))
                .orElse(new ContactFastDto());
        return contactFastDto;
    }

    @Override
    public ContactEntity saveContact(ContactEntity newContact) {
        return contactRepository.save(newContact);
    }

    @Override
    public ContactEntity updateContact(ContactFastDto contactFastDto) {
        ContactEntity contact;

        return null;
    }

    @Override
    public Long countByPredicate(Predicate predicate) {
        Object o = contactQueryDslRepository.count(predicate);
        Long contactCount = Long.valueOf(contactQueryDslRepository.count(predicate));
        return contactCount != null ? contactCount.longValue() : null;
    }

    @Override
    public Page<ContactEntity> findAllByPredicate(Predicate predicate, Pageable pageable) {
        Page<ContactEntity> contactPages = contactQueryDslRepository.findAll(predicate, pageable);
        return contactPages;
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
