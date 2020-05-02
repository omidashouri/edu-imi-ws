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
        ContactApiEntity newContactWebService = new ContactApiEntity();
        newContactWebService.setContactPublicId(publicContactId);
        newContactWebService.setContact(person.getContact());
        newContactWebService.setCreator(person);
//        newContactWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
        return contactApiRepository.save(newContactWebService);
    }

    @Override
    public ContactApiEntity findContactApiEntityByContactEntityFast(ContactEntity contact) {
//        omiddo:add NamedEntityGraph later for contact
        return contactApiRepository.findByContact(contact);
    }

    @Override
    public List<ContactApiEntity> saveAllContactApi(List<ContactApiEntity> contactWebServices) {
        Iterable<ContactApiEntity> iterableContactWebServices = new ArrayList<>();
        contactWebServices.sort(Comparator.comparing(ContactApiEntity::getContactId));
        iterableContactWebServices = contactApiRepository
                .saveAll(contactWebServices);
        List<ContactApiEntity> newContactWebServices = StreamSupport
                .stream(iterableContactWebServices.spliterator(), false)
                .collect(Collectors.toList());
        return newContactWebServices;
    }

    @Override
    public List<ContactApiEntity> generateContactApiPublicId(List<ContactEntity> newContacts) {
        List<ContactApiEntity> newContactWebServices = new ArrayList<>();

        newContacts
                .stream()
                .filter(Objects::nonNull)
                .forEach(c -> {
                            ContactApiEntity newContactWebService = new ContactApiEntity();
                            newContactWebService.setContact(c);
                            newContactWebService.setContactId(c.getId());
                            newContactWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
                            newContactWebService.setContactPublicId(this.generateUniqueContactWebServicePublicId());
                            c.setContactWebService(newContactWebService);
                        });

        newContactWebServices = newContacts
                                .stream()
                                .map(ContactEntity::getContactWebService)
                                .collect(Collectors.toList());

        newContactWebServices
                .sort(Comparator.comparing(ContactApiEntity::getContactId));

        Iterable<ContactApiEntity> savedIterableContactWebService =
                contactApiRepository.saveAll(newContactWebServices);

        List<ContactApiEntity> savedContactWebServices = StreamSupport
                .stream(savedIterableContactWebService.spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));

        return savedContactWebServices;
    }

    private String generateUniqueContactWebServicePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}

