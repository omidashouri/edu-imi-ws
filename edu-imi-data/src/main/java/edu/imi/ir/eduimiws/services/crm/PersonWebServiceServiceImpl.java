package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceMapper;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<PersonWebServiceEntity> findAllListByPageAndSize(int page, int size) {

        if (page > 0) {
            page--;
        }
        Pageable pageable = PageRequest.of(page,size);

        Page<PersonWebServiceEntity> pagedResult = personWebServiceRepository.findAll(pageable);

        if(pagedResult.hasContent()) {
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
}
