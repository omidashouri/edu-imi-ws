package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.domain.crm.*;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoSaveMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PersonApiFastDto;
import edu.imi.ir.eduimiws.models.dto.crm.UserFastDto;
import edu.imi.ir.eduimiws.services.crm.ContactService;
import edu.imi.ir.eduimiws.services.crm.ContactWebServiceService;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final PersonWebServiceFastDtoMapper personWebServiceFastMapper;
    private final PersonService personService;
    private final ContactService contactService;
    private final PersonWebServiceService personWebServiceService;
    private final ContactWebServiceService contactWebServiceService;
    private final UserFastDtoSaveMapper userFastDtoSaveMapper;
    private final Utils utils;

//    IMI eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5MDU3IiwiZXhwIjoxNTg3NzA0ODg3fQ.kIylwAPr1wk-eynP-wRdFgWefQKDSqEW0hmb1Q7LkKmheU1IYyFpYENeQtq_uGgYdu81uu-2GIsM9fdWcKu0YA

    @Override
    public PersonApiFastDto getUserFastDto(String userName) {

        PersonApiEntity user = personWebServiceService.findByUserNameFast(userName);

        if (null == user) {
            throw new UsernameNotFoundException("user name not found for " + userName);
        }

        PersonApiFastDto userFastDto = personWebServiceFastMapper.PersonWebServiceEntityToPersonWebServiceFastDto(user, new CycleAvoidingMappingContext());
        return userFastDto;
    }

    @Override
    public PersonEntity saveUserByUserFastDto(UserFastDto userFastDto) {
        PersonEntity newPerson = userFastDtoSaveMapper
                .toPersonForSaveFromUserRegister(userFastDto);

        if(newPerson.getSelectedLanguage()==null){
            LanguageEntity language = new LanguageEntity();
            language.setId(1l);
            newPerson.setSelectedLanguage(language);
        }

        if(newPerson.getCompany() == null){
            CompanyEntity company = new CompanyEntity();
            company.setId(4l);
            newPerson.setCompany(company);
        }

        ContactEntity newContact = new ContactEntity();
        newContact = userFastDtoSaveMapper
                .toContactForSaveFromUserRegister(userFastDto);

        if(newContact.getAccount()==null){
            AccountEntity account = new AccountEntity();
            account.setId(1l);
            newContact.setAccount(account);
        }

        if(newContact.getCompany()==null){
            CompanyEntity company = new CompanyEntity();
            company.setId(4l);
            newContact.setCompany(company);
        }

        ContactEntity savedContact = contactService.saveContact(newContact);

        newPerson.setContact(savedContact);
        PersonEntity savedPerson =  personService.savePerson(newPerson);

        return savedPerson;
    }

    @Override
    public List<PersonEntity> generateContactPersonPublicIdByPersons(List<PersonEntity> newPersons) {


        List<PersonEntity> savedPersons = new ArrayList<>();
        List<PersonEntity> distinctSavedPerson = new ArrayList<>();

        List<Long> personIds = newPersons
                .stream()
                .map(PersonEntity::getId)
                .distinct()
                .collect(Collectors.toList());

        newPersons = personService.findAllPersonEntitiesByIdIn(personIds);

        List<PersonEntity> needContactWebPersonWeb = newPersons
                .stream()
                .filter(Objects::nonNull)
                .filter(p -> Objects.isNull(p.getPersonApiEntity()))
                .filter(p -> Objects.nonNull(p.getContact()))
                .filter(p -> Objects.isNull(p.getContact().getContactWebService()))
                .collect(Collectors.toList());

        List<PersonEntity> needPersonWeb = newPersons
                .stream()
                .filter(Objects::nonNull)
                .filter(Predicate.not(needContactWebPersonWeb::contains))
                .filter(p -> Objects.isNull(p.getPersonApiEntity()))
                .collect(Collectors.toList());

        List<PersonEntity> needContactWeb = newPersons
                .stream()
                .filter(Objects::nonNull)
                .filter(Predicate.not(needContactWebPersonWeb::contains))
                .filter(p -> Objects.nonNull(p.getContact()))
                .filter(p -> Objects.isNull(p.getContact().getContactWebService()))
                .collect(Collectors.toList());


        if (!needContactWebPersonWeb.isEmpty() || needContactWebPersonWeb.size() > 0) {

            this.generateContactPublicIdByPersons(needContactWebPersonWeb)
                    .stream().forEachOrdered(savedPersons::add);

            this.generatePersonPublicIdByPersons(needContactWebPersonWeb)
                    .stream().forEachOrdered(savedPersons::add);

            distinctSavedPerson = this.distinctSortPersonsById(savedPersons);
        }

        if (!needContactWeb.isEmpty() || needContactWeb.size() > 0) {
            this.generateContactPublicIdByPersons(needContactWeb)
                    .stream()
                    .forEachOrdered(savedPersons::add);
            distinctSavedPerson = this.distinctSortPersonsById(savedPersons);
        }

        if (!needPersonWeb.isEmpty() || needPersonWeb.size() > 0) {
            this.generatePersonPublicIdByPersons(needPersonWeb)
                    .stream()
                    .forEachOrdered(savedPersons::add);
            distinctSavedPerson = this.distinctSortPersonsById(savedPersons);
        }

        return distinctSavedPerson;
    }

    @Override
    public List<PersonEntity> generatePersonPublicIdByPersons(List<PersonEntity> newPersons) {

        List<Long> personIds = newPersons
                .stream()
                .filter(Objects::nonNull)
                .map(PersonEntity::getId)
                .distinct()
                .collect(Collectors.toList());

        List<PersonEntity> persons = personService
                .findAllPersonEntitiesByIdIn(personIds);

        List<PersonApiEntity> savedPersonWebServices = personWebServiceService
                .generatePersonWebServicePublicId(persons);

        List<PersonEntity> savedPersons = savedPersonWebServices
                .stream()
                .map(PersonApiEntity::getPerson)
                .collect(Collectors.toList());

        return savedPersons;
    }

    @Override
    public List<PersonEntity> generateContactPublicIdByPersons(List<PersonEntity> newPersons) {
        List<Long> contactIds = newPersons
                .stream()
                .filter(Objects::nonNull)
                .map(PersonEntity::getContact)
                .filter(Objects::nonNull)
                .filter(c -> Objects.isNull(c.getContactWebService()))
                .map(ContactEntity::getId)
                .distinct()
                .collect(Collectors.toList());

        List<ContactEntity> newContacts = contactService
                .findCotactsByIds(contactIds);

        List<ContactApiEntity> savedContactWebServices = contactWebServiceService
                .generateContactWebServicePublicId(newContacts);

        List<PersonEntity> savedPersons =
                savedContactWebServices
                        .stream()
                        .map(p -> p.getContact())
                        .filter(Objects::nonNull)
                        .map(ContactEntity::getPersons)
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        return savedPersons;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        check username has public id -> if not generate public ID for contact and person

//        load user

        String publicContactId;
        String publicPersonId;

        ContactApiEntity contactApiEntity = new ContactApiEntity();

        PersonApiEntity newPersonApiEntity = new PersonApiEntity();

        PersonEntity user = personService.findByUserNameFast(username);

/*        if (users.isEmpty() || users.size() == 0) {
            throw new UsernameNotFoundException("user name not found for " + username);
        }*/

        if (null == user) {
            throw new UsernameNotFoundException("user name not found for " + username);
        }

        PersonApiEntity userWebServiceEntity = personWebServiceService.findByUserNameFast(username);

        if (null == userWebServiceEntity) {

            publicPersonId = generatePublicId();

            if (!existContactPublicIdInContactWebServiceEntity(user.getContact())) {
                publicContactId = generatePublicId();
                contactApiEntity =
                        contactWebServiceService
                                .saveContactWebServiceByPublicContactIdAndPersonEntity(publicContactId, user);
            } else {
                contactApiEntity = contactWebServiceService.findContactWebServiceEntityByContactEntityFast(user.getContact());
            }


            userWebServiceEntity = personWebServiceService
                    .savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(publicPersonId,
                            contactApiEntity.getContactPublicId(),
                            user);
        }

        if (null == userWebServiceEntity.getContactPublicId()) {

            publicContactId = generatePublicId();
            contactApiEntity =
                    contactWebServiceService
                            .saveContactWebServiceByPublicContactIdAndPersonEntity(publicContactId, user);
        }

        if (null == userWebServiceEntity.getPersonPublicId()) {
            publicPersonId = generatePublicId();
            userWebServiceEntity = personWebServiceService
                    .savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(publicPersonId,
                            contactApiEntity.getContactPublicId(),
                            user);
        }


//        let user login if user email is verified
        return new org.springframework.security.core.userdetails.User(userWebServiceEntity.getUserName(),
                userWebServiceEntity.getEncryptedPassword(),
                true,
                true,
                true,
                true,
                new ArrayList<>());
    }

/*    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        role = "ROLE_ADMIN";
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }*/

    private PersonApiEntity savePersonWebService(String publicPersonId, String publicContactId, PersonEntity user) {
        PersonApiEntity newPersonWebService = new PersonApiEntity();
//        newPersonWebService.setContactId(user.getContactId());
        newPersonWebService.setContactPublicId(publicContactId);
        newPersonWebService.setPersonPublicId(publicPersonId);
        newPersonWebService.setUserName(user.getUsername());
        newPersonWebService.setPerson(user);
        newPersonWebService.setEncryptedPassword(user.getPassword());
        return personWebServiceService.savePersonWebServiceEntity(newPersonWebService);
    }

    private boolean existContactPublicIdInContactWebServiceEntity(ContactEntity contactEntity) {
        boolean exist = true;

        ContactApiEntity contactApiEntity = contactWebServiceService.findContactWebServiceEntityByContactEntityFast(contactEntity);

        if (null == contactApiEntity) {
            exist = false;
        }

        return exist;
    }


    private String generatePublicId() {
        return utils.generateUniquePublicId();
    }

    private List<PersonEntity> distinctSortPersonsById(List<PersonEntity> persons) {
        return  persons.stream()
                .distinct()
                .sorted(Comparator.comparing(PersonEntity::getId))
        .collect(Collectors.toList());
    }


}
