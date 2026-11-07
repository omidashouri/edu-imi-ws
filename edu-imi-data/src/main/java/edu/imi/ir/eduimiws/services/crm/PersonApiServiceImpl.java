package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
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
    private final PersonRoleApiService personRoleApiService;
//    private final ContactApiService contactWebServiceService;
    private final PublicIdUtil publicIdUtil;
    private final PersonApiMapper personApiMapper;


    @Override
    public List<PersonApiEntity> findAllListByPageAndSize(int page, int size) {
        log.info("PersonApiService.findAllListByPageAndSize - page: {}, size: {}", page, size);

        if (page > 0) {
            page--;
        }
        Pageable pageable = PageRequest.of(page, size);

        Page<PersonApiEntity> pagedResult = personApiRepository.findAll(pageable);

        List<PersonApiEntity> result;
        if (pagedResult.hasContent()) {
            result = pagedResult.getContent();
        } else {
            result = new ArrayList<PersonApiEntity>();
        }
        log.info("PersonApiService.findAllListByPageAndSize - resultSize: {}", result == null ? null : result.size());
        return result;
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
        log.info("PersonApiService.findByPersonId - personId: {}", personId);

        PersonApiEntity personApiEntity = personApiRepository.findByPersonId(personId);
        log.info("PersonApiService.findByPersonId - result: {}", personApiEntity);
        return personApiEntity;
    }

    @Override
    public String findPersonPublicIdByPersonId(Long personId) {
        log.info("PersonApiService.findPersonPublicIdByPersonId - personId: {}", personId);
        String result = this.findByPersonId(personId).getPersonPublicId();
        log.info("PersonApiService.findPersonPublicIdByPersonId - result: {}", result);
        return result;
    }
//NU
/*    @Override
    public PersonApiEntity findByPersonEntity(PersonEntity personEntity) {
        return  this.findByPersonId(personEntity.getId());
    }*/

    @Override
    public PersonApiEntity findByUserNameFast(String userName) {
        log.info("PersonApiService.findByUserNameFast - userName: {}", userName);
        PersonApiEntity personApiEntity = personApiRepository.findByUserName(userName);
        log.info("PersonApiService.findByUserNameFast - result: {}", personApiEntity);
        return personApiEntity;
    }

    @Override
    public PersonApiEntity findPersonApiEntityByUserPublicId(String userPublicId) {
        log.info("PersonApiService.findPersonApiEntityByUserPublicId - userPublicId: {}", userPublicId);
        PersonApiEntity userWS = personApiRepository.findByPersonPublicId(userPublicId);
        if (null == userWS) {
            throw new UsernameNotFoundException("user can not found for " + userPublicId);
        }

        log.info("PersonApiService.findPersonApiEntityByUserPublicId - result: {}", userWS);
        return userWS;
    }

    @Override
    public PersonApiEntity savePersonApiEntity(PersonApiEntity personApiEntity) {
        log.info("PersonApiService.savePersonApiEntity - personApiEntity: {}", personApiEntity);
        PersonApiEntity result = personApiRepository.save(personApiEntity);
        log.info("PersonApiService.savePersonApiEntity - result: {}", result);
        return result;
    }

    @Override
    public PersonApiEntity savePersonApiByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity) {
        log.info("PersonApiService.savePersonApiByPublicPersonIdAndPublicContactIdAndPersonEntity - publicPersonId: {}, publicContactId: {}, personEntity: {}",
                publicPersonId, publicContactId, personEntity);
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
        PersonApiEntity result = personApiRepository.save(newPersonWebService);
        log.info("PersonApiService.savePersonApiByPublicPersonIdAndPublicContactIdAndPersonEntity - result: {}", result);
        return result;
    }

    @Override
    public PersonApiEntity findByPersonPublicIdWithPersonAndRole(String userPublicId) {
        log.info("PersonApiService.findByPersonPublicIdWithPersonAndRole - userPublicId: {}", userPublicId);
        PersonApiEntity personApi = personApiRepository.readByPersonPublicId(userPublicId);
        log.info("PersonApiService.findByPersonPublicIdWithPersonAndRole - result: {}", personApi);
        return personApi;
    }

    @Override
    public List<PersonApiEntity> findAllPersonApiIdProjection() {
        log.info("PersonApiService.findAllPersonApiIdProjection - start");

        List<PersonApiIdProjection> personApiIdProjections =
                personApiRepository.findAllPersonApiIdProjection();

        List<PersonApiEntity> personWebServiceEntities =
                personApiIdProjectionMapper
                        .toPersonWebServiceEntitys(personApiIdProjections,
                                new CycleAvoidingMappingContext());
        log.info("PersonApiService.findAllPersonApiIdProjection - resultSize: {}",
                personWebServiceEntities == null ? null : personWebServiceEntities.size());
        return personWebServiceEntities;
    }

    @Override
    public Long personApiCount() {
        log.info("PersonApiService.personApiCount - start");
        Long result = personApiRepository.count();
        log.info("PersonApiService.personApiCount - result: {}", result);
        return result;
    }

    @Override
    public PersonApiEntity selectLastRecord() {
        log.info("PersonApiService.selectLastRecord - start");
        PersonApiEntity result = personApiRepository.findFirstByOrderByIdDesc();
        log.info("PersonApiService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public List<PersonApiEntity> generatePersonApiPublicId(List<PersonEntity> newPersons) {
        log.info("PersonApiService.generatePersonApiPublicId - newPersonsSize: {}",
                newPersons == null ? null : newPersons.size());
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

        log.info("PersonApiService.generatePersonApiPublicId - resultSize: {}",
                savedPersonApies == null ? null : savedPersonApies.size());
        return savedPersonApies;
    }

    @Override
    public List<PersonApiEntity> findAllByPersonIdIn(List<Long> personIds) {
        log.info("PersonApiService.findAllByPersonIdIn - personIds: {}", personIds);
        List<PersonApiEntity> personApis = personApiRepository
                .findAllByPersonIdIn(personIds);
        log.info("PersonApiService.findAllByPersonIdIn - resultSize: {}", personApis == null ? null : personApis.size());
        return personApis;
    }

    @Override
    public PersonApiEntity updateByPersonApiAndRoleName(PersonApiEntity personApi, Collection<String> rolePublicIds) {
        log.info("PersonApiService.updateByPersonApiAndRoleName - personApi: {}, rolePublicIds: {}", personApi, rolePublicIds);
        PersonApiEntity result = personRoleApiService.replaceRoles(personApi, rolePublicIds);
        log.info("PersonApiService.updateByPersonApiAndRoleName - result: {}", result);
        return result;
    }

    private String generateUniquePersonWebServicePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }
}
