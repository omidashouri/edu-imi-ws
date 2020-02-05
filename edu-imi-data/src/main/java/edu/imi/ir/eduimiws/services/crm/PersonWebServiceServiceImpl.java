package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.PersonWebServiceMapper;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PersonWebServiceServiceImpl implements PersonWebServiceService{

    private final PersonWebServiceMapper personWebServiceMapper;
    private final PersonWebServiceRepository personWebServiceRepository;
    private final PersonService personService;
    private final Utils utils;

    private final ContactServiceImpl contactService;


    @Override
    public PersonWebServiceEntity findByPersonId(Long personId) {

        PersonWebServiceEntity personWebServiceEntity = personWebServiceRepository.findByPersonId(personId);
        return personWebServiceEntity;
    }

    @Override
    public PersonWebServiceEntity findByPersonEntity(PersonEntity personEntity) {
        return  this.findByPersonId(personEntity.getId());
    }

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
}