package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonApiIdProjectionMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonApiMapper;
import edu.imi.ir.eduimiws.models.projections.crm.PersonApiIdProjection;
import edu.imi.ir.eduimiws.repositories.crm.PersonApiRepository;
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
public class PersonApiServiceImpl implements PersonApiService {

    private final PersonApiRepository personApiRepository;
    private final PersonApiIdProjectionMapper personApiIdProjectionMapper;
    private final RoleApiService roleApiService;
//    private final ContactApiService contactWebServiceService;
    private final PublicIdUtil publicIdUtil;
    private final PersonApiMapper personApiMapper;


    @Override
    public List<PersonApiEntity> findAllListByPageAndSize(int page, int size) {

        if (page > 0) {
            page--;
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<PersonApiEntity> pagedResult = personApiRepository.findAll(pageable);

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

        Page<PersonApiEntity> pagedResult = personWebServiceRepository.findAllAndDeleteDateTsIsNull(pageable);

        if(pagedResult.hasContent()) {
            return pagedResult;
        } else {
            return new PageImpl<>(new ArrayList<>());
        }
    }*/

    @Override
    public PersonApiEntity findByPersonId(Long personId) {

        PersonApiEntity personApiEntity = personApiRepository.findByPersonId(personId);
        return personApiEntity;
    }

    @Override
    public String findPersonPublicIdByPersonId(Long personId) {
        return this.findByPersonId(personId).getPersonPublicId();
    }
//NU
/*    @Override
    public PersonApiEntity findByPersonEntity(PersonEntity personEntity) {
        return  this.findByPersonId(personEntity.getId());
    }*/

    @Override
    public PersonApiEntity findByUserNameFast(String userName) {
        PersonApiEntity personApiEntity = personApiRepository.findByUserName(userName);
        return personApiEntity;
    }

    @Override
    public PersonApiEntity findPersonApiEntityByUserPublicId(String userPublicId) {
        PersonApiEntity userWS = personApiRepository.findByPersonPublicId(userPublicId);
        if (null == userWS) {
            throw new UsernameNotFoundException("user can not found for " + userPublicId);
        }

        return userWS;
    }

    @Override
    public PersonApiEntity savePersonApiEntity(PersonApiEntity personApiEntity) {
        return personApiRepository.save(personApiEntity);
    }

    @Override
    public PersonApiEntity savePersonApiByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity) {
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
        return personApiRepository.save(newPersonWebService);
    }

    @Override
    public PersonApiEntity findByPersonPublicIdWithPersonAndRole(String userPublicId) {
        PersonApiEntity personApi = personApiRepository.readByPersonPublicId(userPublicId);
        return personApi;
    }

    @Override
    public List<PersonApiEntity> findAllPersonApiIdProjection() {

        List<PersonApiIdProjection> personApiIdProjections =
                personApiRepository.findAllPersonApiIdProjection();

        List<PersonApiEntity> personWebServiceEntities =
                personApiIdProjectionMapper
                        .toPersonWebServiceEntitys(personApiIdProjections,
                                new CycleAvoidingMappingContext());
        return personWebServiceEntities;
    }

    @Override
    public Long personApiCount() {
        return personApiRepository.count();
    }

    @Override
    public PersonApiEntity selectLastRecord() {
        return personApiRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<PersonApiEntity> generatePersonApiPublicId(List<PersonEntity> newPersons) {
        List<PersonApiEntity> newPersonApies = new ArrayList<>();

        newPersons
                .stream()
                .filter(Objects::nonNull)
                .forEach(p -> {
                    PersonApiEntity newPersonApi = new PersonApiEntity();
                    newPersonApi.setPerson(p);
                    newPersonApi.setPersonId(p.getId());
                    if (p.getUsername() != null) {
                        newPersonApi.setUserName(p.getUsername());
                    }
                    if (p.getPassword() != null) {
                        newPersonApi.setEncryptedPassword(p.getPassword());
                    }
                    newPersonApi.setCreateDateTs(new Timestamp(new Date().getTime()));
                    newPersonApi.setPersonPublicId(this.generateUniquePersonWebServicePublicId());
                    if (!Hibernate.isInitialized(p.getContact())) {
                        p.setContact(null);
                    }
                    if (p.getContact() != null) {
                        newPersonApi.setContact(p.getContact());
                        newPersonApi.setContactId(p.getContactId());
                        if (p.getContact().getContactWebService() != null) {
                            newPersonApi.setContactPublicId(p.getContact().getContactWebService().getContactPublicId());
                        }
                    }
                    p.setPersonApiEntity(newPersonApi);
        });

        newPersonApies = newPersons
                .stream()
                .map(PersonEntity::getPersonApiEntity)
                .collect(Collectors.toList());

        newPersonApies
                .sort(Comparator.comparing(PersonApiEntity::getPersonId));

        Iterable<PersonApiEntity> savedIterablePersonWebService =
                personApiRepository.saveAll(newPersonApies);

        List<PersonApiEntity> savedPersonApies = StreamSupport
                .stream(savedIterablePersonWebService.spliterator(), false)
                .collect(Collectors.toCollection(ArrayList::new));

        return savedPersonApies;
    }

    @Override
    public List<PersonApiEntity> findAllByPersonIdIn(List<Long> personIds) {
        List<PersonApiEntity> personApis = personApiRepository
                .findAllByPersonIdIn(personIds);
        return personApis;
    }

    @Override
    public PersonApiEntity updateByPersonApiAndRoleName(PersonApiEntity personApi, Collection<String> rolePublicIds) {

        Collection<RoleApiEntity> newRoles = roleApiService
                .findAllByRolePublicIdsIn(rolePublicIds.stream().collect(Collectors.toList()));

        personApi.setRoles(newRoles);
        PersonApiEntity savedPersonApi =  personApiRepository.save(personApi);
        return savedPersonApi;
    }

    private String generateUniquePersonWebServicePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }
}
