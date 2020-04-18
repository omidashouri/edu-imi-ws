package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceIdProjectionMapper;
import edu.imi.ir.eduimiws.models.projections.crm.PersonWebServiceIdProjection;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class PersonWebServiceServiceImpl implements PersonWebServiceService {

    private final PersonWebServiceRepository personWebServiceRepository;
    private final PersonWebServiceIdProjectionMapper personWebServiceIdProjectionMapper;
//    private final ContactWebServiceService contactWebServiceService;
    private final Utils utils;


    @Override
    public List<PersonWebServiceEntity> findAllListByPageAndSize(int page, int size) {

        if (page > 0) {
            page--;
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<PersonWebServiceEntity> pagedResult = personWebServiceRepository.findAll(pageable);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<PersonWebServiceEntity>();
        }
    }
//NU
/*    @Override
    public Page<PersonWebServiceEntity> findAllPageByPageAndSize(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);

        Page<PersonWebServiceEntity> pagedResult = personWebServiceRepository.findAll(pageable);

        if(pagedResult.hasContent()) {
            return pagedResult;
        } else {
            return new PageImpl<>(new ArrayList<>());
        }
    }*/

    @Override
    public PersonWebServiceEntity findByPersonId(Long personId) {

        PersonWebServiceEntity personWebServiceEntity = personWebServiceRepository.findByPersonId(personId);
        return personWebServiceEntity;
    }
//NU
/*    @Override
    public PersonWebServiceEntity findByPersonEntity(PersonEntity personEntity) {
        return  this.findByPersonId(personEntity.getId());
    }*/

    @Override
    public PersonWebServiceEntity findByUserNameFast(String userName) {
        PersonWebServiceEntity personWebServiceEntity = personWebServiceRepository.findByUserName(userName);
        return personWebServiceEntity;
    }

    @Override
    public PersonWebServiceEntity findPersonWebServiceEntityByUserPublicId(String userPublicId) {
        PersonWebServiceEntity userWS = personWebServiceRepository.findByPersonPublicId(userPublicId);
        if (null == userWS) {
            throw new UsernameNotFoundException("user can not found for " + userPublicId);
        }

        return userWS;
    }

    @Override
    public PersonWebServiceEntity savePersonWebServiceEntity(PersonWebServiceEntity personWebServiceEntity) {
        return personWebServiceRepository.save(personWebServiceEntity);
    }

    @Override
    public PersonWebServiceEntity savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity) {
        PersonWebServiceEntity newPersonWebService = new PersonWebServiceEntity();
        newPersonWebService.setContactId(personEntity.getContactId());
        newPersonWebService.setContact(personEntity.getContact());
        newPersonWebService.setContactPublicId(publicContactId);
        newPersonWebService.setPersonPublicId(publicPersonId);
        newPersonWebService.setPerson(personEntity);
        newPersonWebService.setUserName(personEntity.getUsername());
        newPersonWebService.setEncryptedPassword(personEntity.getPassword());
        newPersonWebService.setCreator(personEntity);
//        newPersonWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
        return personWebServiceRepository.save(newPersonWebService);
    }

    @Override
    public List<PersonWebServiceEntity> findAllPersonWebServiceIdProjection() {

        List<PersonWebServiceIdProjection> personWebServiceIdProjections =
                personWebServiceRepository.findAllPersonWebServiceIdProjection();

        List<PersonWebServiceEntity> personWebServiceEntities =
                personWebServiceIdProjectionMapper
                        .toPersonWebServiceEntitys(personWebServiceIdProjections,
                                new CycleAvoidingMappingContext());
        return personWebServiceEntities;
    }

    @Override
    public Long personWebServiceCount() {
        return personWebServiceRepository.count();
    }

    @Override
    public PersonWebServiceEntity selectLastRecord() {
        return personWebServiceRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<PersonWebServiceEntity> generatePersonWebServicePublicId(List<PersonEntity> newPersons) {
        List<PersonWebServiceEntity> newPersonWebServices = new ArrayList<>();

        newPersons
                .stream()
                .filter(Objects::nonNull)
                .forEach(p->{
                    PersonWebServiceEntity newPersonWebService = new PersonWebServiceEntity();
                    newPersonWebService.setPerson(p);
                    newPersonWebService.setPersonId(p.getId());
                    if(p.getUsername() != null){
                        newPersonWebService.setUserName(p.getUsername());
                    }
                    if(p.getPassword() != null){
                        newPersonWebService.setEncryptedPassword(p.getPassword());
                    }
                    newPersonWebService.setCreateDateTs(new Timestamp(new Date().getTime()));
                    newPersonWebService.setPersonPublicId(this.generateUniquePersonWebServicePublicId());
                    if(!Hibernate.isInitialized(p.getContact())) {
                        p.setContact(null);
                    }
                    if(p.getContact()!=null){
                        newPersonWebService.setContact(p.getContact());
                        newPersonWebService.setContactId(p.getContactId());
                        if(p.getContact().getContactWebService()!=null){
                            newPersonWebService.setContactPublicId(p.getContact().getContactWebService().getContactPublicId());
                        }
                    }
                    p.setPersonWebServiceEntity(newPersonWebService);
        });

        newPersonWebServices = newPersons
                .stream()
                .map(PersonEntity::getPersonWebServiceEntity)
                .collect(Collectors.toList());

        newPersonWebServices
                .sort(Comparator.comparing(PersonWebServiceEntity::getPersonId));

        Iterable<PersonWebServiceEntity> savedIterablePersonWebService =
                    personWebServiceRepository.saveAll(newPersonWebServices);

        List<PersonWebServiceEntity> personWebServiceEntities = StreamSupport
                                    .stream(savedIterablePersonWebService.spliterator(),false)
                                    .collect(Collectors.toCollection(ArrayList::new));

        return personWebServiceEntities;
    }

    private String generateUniquePersonWebServicePublicId() {
        return utils.generateUniquePublicId();
    }
}
