package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceIdProjectionMapper;
import edu.imi.ir.eduimiws.models.projections.crm.PersonWebServiceIdProjection;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
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
    private final PublicIdUtil publicIdUtil;


    @Override
    public List<PersonApiEntity> findAllListByPageAndSize(int page, int size) {

        if (page > 0) {
            page--;
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<PersonApiEntity> pagedResult = personWebServiceRepository.findAll(pageable);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<PersonApiEntity>();
        }
    }
//NU
/*    @Override
    public Page<PersonApiEntity> findAllPageByPageAndSize(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);

        Page<PersonApiEntity> pagedResult = personWebServiceRepository.findAll(pageable);

        if(pagedResult.hasContent()) {
            return pagedResult;
        } else {
            return new PageImpl<>(new ArrayList<>());
        }
    }*/

    @Override
    public PersonApiEntity findByPersonId(Long personId) {

        PersonApiEntity personApiEntity = personWebServiceRepository.findByPersonId(personId);
        return personApiEntity;
    }
//NU
/*    @Override
    public PersonApiEntity findByPersonEntity(PersonEntity personEntity) {
        return  this.findByPersonId(personEntity.getId());
    }*/

    @Override
    public PersonApiEntity findByUserNameFast(String userName) {
        PersonApiEntity personApiEntity = personWebServiceRepository.findByUserName(userName);
        return personApiEntity;
    }

    @Override
    public PersonApiEntity findPersonWebServiceEntityByUserPublicId(String userPublicId) {
        PersonApiEntity userWS = personWebServiceRepository.findByPersonPublicId(userPublicId);
        if (null == userWS) {
            throw new UsernameNotFoundException("user can not found for " + userPublicId);
        }

        return userWS;
    }

    @Override
    public PersonApiEntity savePersonWebServiceEntity(PersonApiEntity personApiEntity) {
        return personWebServiceRepository.save(personApiEntity);
    }

    @Override
    public PersonApiEntity savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity) {
        PersonApiEntity newPersonWebService = new PersonApiEntity();
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
    public List<PersonApiEntity> findAllPersonWebServiceIdProjection() {

        List<PersonWebServiceIdProjection> personWebServiceIdProjections =
                personWebServiceRepository.findAllPersonWebServiceIdProjection();

        List<PersonApiEntity> personWebServiceEntities =
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
    public PersonApiEntity selectLastRecord() {
        return personWebServiceRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<PersonApiEntity> generatePersonWebServicePublicId(List<PersonEntity> newPersons) {
        List<PersonApiEntity> newPersonWebServices = new ArrayList<>();

        newPersons
                .stream()
                .filter(Objects::nonNull)
                .forEach(p->{
                    PersonApiEntity newPersonWebService = new PersonApiEntity();
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
                    p.setPersonApiEntity(newPersonWebService);
        });

        newPersonWebServices = newPersons
                .stream()
                .map(PersonEntity::getPersonApiEntity)
                .collect(Collectors.toList());

        newPersonWebServices
                .sort(Comparator.comparing(PersonApiEntity::getPersonId));

        Iterable<PersonApiEntity> savedIterablePersonWebService =
                    personWebServiceRepository.saveAll(newPersonWebServices);

        List<PersonApiEntity> savedPersonWebServices = StreamSupport
                                    .stream(savedIterablePersonWebService.spliterator(),false)
                                    .collect(Collectors.toCollection(ArrayList::new));

        return savedPersonWebServices;
    }

    @Override
    public List<PersonApiEntity> findAllByPersonIdIn(List<Long> personIds) {
        List<PersonApiEntity> personApis = personWebServiceRepository
                .findAllByPersonIdIn(personIds);
        return personApis;
    }

    private String generateUniquePersonWebServicePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }
}
