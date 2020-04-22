package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.repositories.crm.ContactWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
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
public class ContactWebServiceServiceImpl implements ContactWebServiceService {


    private final ContactWebServiceRepository contactWebServiceRepository;
    private final Utils utils;
//NU
/*    @Override
    public ContactWebServiceEntity saveContactWebServiceEntity(ContactWebServiceEntity contactWebServiceEntity) {
        return contactWebServiceRepository.save(contactWebServiceEntity);
    }*/

    @Override
    public ContactWebServiceEntity saveContactWebServiceByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person) {
        ContactWebServiceEntity newContactWebService = new ContactWebServiceEntity();
        newContactWebService.setContactPublicId(publicContactId);
        newContactWebService.setContact(person.getContact());
        newContactWebService.setCreator(person);
//        newContactWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
        return contactWebServiceRepository.save(newContactWebService);
    }

    @Override
    public ContactWebServiceEntity findContactWebServiceEntityByContactEntityFast(ContactEntity contact) {
//        omiddo:add NamedEntityGraph later for contact
        return contactWebServiceRepository.findByContact(contact);
    }

    @Override
    public List<ContactWebServiceEntity> saveAllContactWebServices(List<ContactWebServiceEntity> contactWebServices) {
        Iterable<ContactWebServiceEntity> iterableContactWebServices = new ArrayList<>();
        contactWebServices.sort(Comparator.comparing(ContactWebServiceEntity::getContactId));
        iterableContactWebServices = contactWebServiceRepository
                .saveAll(contactWebServices);
        List<ContactWebServiceEntity> newContactWebServices = StreamSupport
                .stream(iterableContactWebServices.spliterator(), false)
                .collect(Collectors.toList());
        return newContactWebServices;
    }

    @Override
    public List<ContactWebServiceEntity> generateContactWebServicePublicId(List<ContactEntity> newContacts) {
        List<ContactWebServiceEntity> newContactWebServices = new ArrayList<>();

        newContacts
                .stream()
                .filter(Objects::nonNull)
                .forEach(c -> {
                            ContactWebServiceEntity newContactWebService = new ContactWebServiceEntity();
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
                .sort(Comparator.comparing(ContactWebServiceEntity::getContactId));

        Iterable<ContactWebServiceEntity> savedIterableContactWebService =
                contactWebServiceRepository.saveAll(newContactWebServices);

        List<ContactWebServiceEntity> savedContactWebServices = StreamSupport
                .stream(savedIterableContactWebService.spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));

        return savedContactWebServices;
    }

    private String generateUniqueContactWebServicePublicId() {
        return utils.generateUniquePublicId();
    }

}

