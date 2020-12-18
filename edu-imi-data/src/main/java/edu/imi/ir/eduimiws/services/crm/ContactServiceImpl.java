package edu.imi.ir.eduimiws.services.crm;


import com.google.common.collect.Iterables;
import com.querydsl.core.types.Predicate;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactFastDto;
import edu.imi.ir.eduimiws.repositories.crm.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactFastDtoMapper contactFastDtoMapper;

    @Override
    public List<ContactFastDto> findContactByNationalCode(String nationalCode) {
        List<ContactEntity> contactEntities = contactRepository
                .findContactEntitiesByNationCode(nationalCode);
        List<ContactFastDto> contactFastDtos = contactFastDtoMapper
                .toContactFastDtos(contactEntities, new CycleAvoidingMappingContext());
        return contactFastDtos;
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
    public List<ContactEntity> findCotactsByIds(List<Long> contactIds) {
        List<ContactEntity> contacts = contactRepository
                .findByIdIn(contactIds);
        return contacts;
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
//    containsIc(ContactEntity.firstName,omid)   eqIc(contactEntity.firstName,omid)
//true = true && eqIc(contactEntity.firstName,omid) eqIc(contactEntity.firstName,omid)
    @Override
    public Long countByPredicate(Predicate predicate) {
        Object o = contactRepository.count(predicate);
        Long contactCount = Long.valueOf(contactRepository.count(predicate));
        return contactCount != null ? contactCount.longValue() : null;
    }

    @Override
    public List<ContactEntity> findAllByPredicate(Predicate predicate) {
        List<ContactEntity> contacts = new ArrayList<>();
        if (Iterables.size(contactRepository.findAll(predicate)) > 0) {
            contacts = StreamSupport.stream(contactRepository.findAll(predicate).spliterator(), false).
                    collect(Collectors.toList());
        }
        return contacts;
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
