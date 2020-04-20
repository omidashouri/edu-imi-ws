package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonUserProjectionMapper;
import edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final PersonUserProjectionMapper personUserProjectionMapper;
    private final Utils utils;
//NU
/*    @Override
    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElseThrow(()-> new UserServiceException("person not found for "+id));
    }*/

    @Override
    public PersonEntity findByUserNameFast(String userName) {
        PersonEntity personEntity = personRepository.findByUsername(userName);
//        omiddo: check person is not null or person is not duplicate
        return personEntity;
    }

    @Override
    public Long personCount() {
        return personRepository.count();
    }

    @Override
    public PersonEntity selectLastRecord() {
        return personRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<PersonEntity> findPersonUserProjectionsByIdGreaterThan(Long id) {
        List<PersonUserProjection> personUserProjections =
                personRepository.findPersonUserProjectionsByIdGreaterThan(id);
        List<PersonEntity> persons = personUserProjectionMapper
                .toPersonEntitys(personUserProjections, new CycleAvoidingMappingContext());
        return persons;
    }

    @Override
    public List<PersonEntity> findAllPersonUserProjectionOrderById() {
        List<PersonUserProjection> personUserProjections = personRepository
                .findAllPersonUserProjection();
        personUserProjections.sort(Comparator.comparing(edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection::getId));
        List<PersonEntity> persons = personUserProjectionMapper
                .toPersonEntitys(personUserProjections, new CycleAvoidingMappingContext());
        return persons;
    }

    @Override
    public Long selectPersonLastSequenceNumber() {
        return personRepository.selectLastSequenceNumber();
    }

    @Override
    public PersonEntity findPersonEntityByPersonWebServicePublicId(String personPublicId) {
        PersonEntity person = personRepository
                .findByPersonWebServiceEntity_PersonPublicId(personPublicId);
        return person;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntityPages(Pageable pageable) {
        Page<PersonEntity> personPages = personRepository
                .findAll(pageable);
        return personPages;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntityPagesByUserName(Pageable pageable, String userName) {
        Page<PersonEntity> personPages = personRepository
                .findAllByUsername(pageable,userName);
        return personPages;
    }

    @Override
    public List<PersonEntity> findPersonsByNationalCode(String nationalCode) {
        List<PersonEntity> personEntities = personRepository
                .findPersonEntitiesByContact_NationCode(nationalCode);
        return personEntities;
    }

    @Override
    public List<PersonEntity> findAllPersonEntitiesByIdIn(List<Long> personIds) {
        List<PersonEntity> newPersons =
                personRepository.findAllPersonEntitiesByIdIn(personIds);
        return newPersons;
    }


//NU
/*    @Override
    public List<PersonEntity> findAllByUserNameContaining(String userName) {
        return personRepository.findAllByUserNameContaining(userName);
    }*/
//NU
/*    @Override
    public PersonEntity findByContactId(Long contactId) {
        return personRepository.findByContactId(contactId);
    }*/

    private String generatePublicId() {
        return utils.generateUniquePublicId();
    }

}
