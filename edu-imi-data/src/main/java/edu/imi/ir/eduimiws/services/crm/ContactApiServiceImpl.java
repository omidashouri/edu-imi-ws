package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.ContactApiMapper;
import edu.imi.ir.eduimiws.models.dto.crm.ContactApiDto;
import edu.imi.ir.eduimiws.repositories.crm.ContactApiRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContactApiServiceImpl implements ContactApiService {


    private final ContactApiRepository contactApiRepository;
    private final ContactApiMapper contactApiMapper;
    private final PublicIdUtil publicIdUtil;

    @Override
    public ContactApiEntity saveContactApiByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person) {
        log.info("ContactApiService.saveContactApiByPublicContactIdAndPersonEntity - publicContactId: {}, person: {}",
                publicContactId, person);
        ContactApiEntity newContactApi = new ContactApiEntity();
        newContactApi.setContactPublicId(publicContactId);
        newContactApi.setContact(person.getContact());
        newContactApi.setCreator(person);
        ContactApiEntity result = contactApiRepository.save(newContactApi);
        log.info("ContactApiService.saveContactApiByPublicContactIdAndPersonEntity - result: {}", result);
        return result;
    }

    @Override
    public ContactEntity findContactByContactPublicId(String contactPublicId) {
        log.info("ContactApiService.findContactByContactPublicId - contactPublicId: {}", contactPublicId);
        ContactEntity result = contactApiRepository
                .findByContactPublicId(contactPublicId)
                .filter(Objects::nonNull)
                .map(ContactApiEntity::getContact)
                .orElse(new ContactEntity());
        log.info("ContactApiService.findContactByContactPublicId - result: {}", result);
        return result;
    }

    @Override
    public ContactApiDto findContactApiDtoByContactPublicId(String contactPublicId) {
        log.info("ContactApiService.findContactApiDtoByContactPublicId - contactPublicId: {}", contactPublicId);
        ContactApiDto result = contactApiRepository
                .findByContactPublicId(contactPublicId)
                .filter(Objects::nonNull)
                .map(ca-> contactApiMapper.contactApiEntityToContactApiDto(ca,new CycleAvoidingMappingContext()))
                .orElse(null);
        log.info("ContactApiService.findContactApiDtoByContactPublicId - result: {}", result);
        return result;
    }

    @Override
    public Long findContactIdByContactPublicId(String contactPublicId) {
        log.info("ContactApiService.findContactIdByContactPublicId - contactPublicId: {}", contactPublicId);
        Long result = Optional
                .of(this.findContactByContactPublicId(contactPublicId))
                .filter(Objects::nonNull)
                .map(ContactEntity::getId)
                .orElse(null);
        log.info("ContactApiService.findContactIdByContactPublicId - result: {}", result);
        return result;
    }

    @Override
    public ContactApiEntity findContactApiEntityByContactEntityFast(ContactEntity contact) {
        log.info("ContactApiService.findContactApiEntityByContactEntityFast - contact: {}", contact);
        ContactApiEntity result = contactApiRepository.findByContact(contact);
        log.info("ContactApiService.findContactApiEntityByContactEntityFast - result: {}", result);
        return result;
    }

    @Override
    public List<ContactApiEntity> saveAllContactApi(List<ContactApiEntity> contactApis) {
        log.info("ContactApiService.saveAllContactApi - contactApisSize: {}",
                contactApis == null ? null : contactApis.size());
        contactApis.sort(Comparator.comparing(ContactApiEntity::getContactId));
        List<ContactApiEntity> newContactApis = StreamSupport
                .stream(contactApiRepository.saveAll(contactApis).spliterator(), false)
                .toList();
        log.info("ContactApiService.saveAllContactApi - resultSize: {}",
                newContactApis == null ? null : newContactApis.size());
        return newContactApis;
    }

    @Override
    public List<ContactApiEntity> generateContactApiPublicId(List<ContactEntity> newContacts) {
        log.info("ContactApiService.generateContactApiPublicId - newContactsSize: {}",
                newContacts == null ? null : newContacts.size());

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

        List<ContactApiEntity> newContactApis = newContacts
                .stream()
                .map(ContactEntity::getContactWebService)
                .sorted(Comparator.comparing(ContactApiEntity::getContactId))
                .toList();

        List<ContactApiEntity> savedContactApis = StreamSupport
                .stream(contactApiRepository.saveAll(newContactApis).spliterator(), false)
                .toList();

        log.info("ContactApiService.generateContactApiPublicId - resultSize: {}",
                savedContactApis == null ? null : savedContactApis.size());
        return savedContactApis;
    }

    private String generateUniqueContactApiPublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
