package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.repositories.crm.ContactApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactApiServiceImpl implements ContactApiService {


    private final ContactApiRepository contactApiRepository;
    private final PublicIdUtil publicIdUtil;
//NU
/*    @Override
    public ContactApiEntity saveContactWebServiceEntity(ContactApiEntity contactWebServiceEntity) {
        return contactWebServiceRepository.save(contactWebServiceEntity);
    }*/

    @Override
    public ContactApiEntity saveContactApiByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person) {
        ContactApiEntity newContactApi = new ContactApiEntity();
        newContactApi.setContactPublicId(publicContactId);
        newContactApi.setContact(person.getContact());
        newContactApi.setCreator(person);
//        newContactApi.setCreateDateTs(new Timestamp(new Date().getTime()));
        return contactApiRepository.save(newContactApi);
    }

    @Override
    public ContactEntity findContactByContactPublicId(String contactPublicId) {
        return contactApiRepository
                .findByContactPublicId(contactPublicId)
                .filter(Objects::nonNull)
                .map(ContactApiEntity::getContact)
                .orElse(new ContactEntity());
    }

    @Override
    public Long findContactIdByContactPublicId(String contactPublicId) {
        return Optional
                .of(this.findContactByContactPublicId(contactPublicId))
                .filter(Objects::nonNull)
                .map(ContactEntity::getId)
                .orElse(null);
    }

    @Override
    public ContactApiEntity findContactApiEntityByContactEntityFast(ContactEntity contact) {
//        omiddo:add NamedEntityGraph later for contact
        return contactApiRepository.findByContact(contact);
    }

    @Override
    public List<ContactApiEntity> saveAllContactApi(List<ContactApiEntity> contactApis) {
        Iterable<ContactApiEntity> iterableContactApis = new ArrayList<>();
        contactApis.sort(Comparator.comparing(ContactApiEntity::getContactId));
        iterableContactApis = contactApiRepository
                .saveAll(contactApis);
        List<ContactApiEntity> newContactApis = StreamSupport
                .stream(iterableContactApis.spliterator(), false)
                .collect(Collectors.toList());
        return newContactApis;
    }

    @Override
    public List<ContactApiEntity> generateContactApiPublicId(List<ContactEntity> newContacts) {
        List<ContactApiEntity> newContactApis = new ArrayList<>();

        newContacts
                .stream()
                .filter(Objects::nonNull)
                .forEach(c -> {
                    ContactApiEntity newContactApi = new ContactApiEntity();
                    newContactApi.setContact(c);
                    newContactApi.setContactId(c.getId());
                    newContactApi.setCreateDateTs(new Timestamp(new Date().getTime()));
                    newContactApi.setContactPublicId(this.generateUniqueContactApiPublicId());
                    c.setContactWebService(newContactApi);
                });

        newContactApis = newContacts
                .stream()
                .map(ContactEntity::getContactWebService)
                .collect(Collectors.toList());

        newContactApis
                .sort(Comparator.comparing(ContactApiEntity::getContactId));

        Iterable<ContactApiEntity> savedIterableContactApi =
                contactApiRepository.saveAll(newContactApis);

        List<ContactApiEntity> savedContactApis = StreamSupport
                .stream(savedIterableContactApi.spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));

        return savedContactApis;
    }

    private String generateUniqueContactApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}

