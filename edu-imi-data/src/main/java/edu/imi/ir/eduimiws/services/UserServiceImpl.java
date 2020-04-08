package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonWebServiceFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PersonWebServiceFastDto;
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

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final PersonWebServiceFastDtoMapper personWebServiceFastMapper;
    private final PersonService personService;
    private final PersonWebServiceService personWebServiceService;
    private final ContactWebServiceService contactWebServiceService;
    private final Utils utils;


    @Override
    public PersonWebServiceFastDto getUserFastDto(String userName) {

        PersonWebServiceEntity user = personWebServiceService.findByUserNameFast(userName);

        if (null == user) {
            throw new UsernameNotFoundException("user name not found for " + userName);
        }

        PersonWebServiceFastDto userFastDto = personWebServiceFastMapper.PersonWebServiceEntityToPersonWebServiceFastDto(user,new CycleAvoidingMappingContext());
        return userFastDto;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        check username has public id -> if not generate public ID for contact and person

//        load user

        String publicContactId;
        String publicPersonId;

        ContactWebServiceEntity contactWebServiceEntity = new ContactWebServiceEntity();

        PersonWebServiceEntity newPersonWebServiceEntity = new PersonWebServiceEntity();

        PersonEntity user = personService.findByUserNameFast(username);

/*        if (users.isEmpty() || users.size() == 0) {
            throw new UsernameNotFoundException("user name not found for " + username);
        }*/

        if (null==user) {
            throw new UsernameNotFoundException("user name not found for " + username);
        }

        PersonWebServiceEntity userWebServiceEntity = personWebServiceService.findByUserNameFast(username);

        if (null == userWebServiceEntity) {

            publicPersonId = generatePublicId();

            if(!existContactPublicIdInContactWebServiceEntity(user.getContact())){
                publicContactId = generatePublicId();
                contactWebServiceEntity =
                        contactWebServiceService
                                .saveContactWebServiceByPublicContactIdAndPersonEntity(publicContactId, user);
            } else{
                contactWebServiceEntity = contactWebServiceService.findContactWebServiceEntityByContactEntityFast(user.getContact());
            }


            userWebServiceEntity = personWebServiceService
                    .savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(publicPersonId,
                            contactWebServiceEntity.getContactPublicId(),
                            user);
        }

        if (null == userWebServiceEntity.getContactPublicId()) {

            publicContactId = generatePublicId();
            contactWebServiceEntity =
                    contactWebServiceService
                            .saveContactWebServiceByPublicContactIdAndPersonEntity(publicContactId, user);
        }

        if (null == userWebServiceEntity.getPersonPublicId()) {
            publicPersonId = generatePublicId();
            userWebServiceEntity = personWebServiceService
                    .savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(publicPersonId,
                            contactWebServiceEntity.getContactPublicId(),
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

    private PersonWebServiceEntity savePersonWebService(String publicPersonId, String publicContactId, PersonEntity user) {
        PersonWebServiceEntity newPersonWebService = new PersonWebServiceEntity();
//        newPersonWebService.setContactId(user.getContactId());
        newPersonWebService.setContactPublicId(publicContactId);
        newPersonWebService.setPersonPublicId(publicPersonId);
        newPersonWebService.setUserName(user.getUsername());
        newPersonWebService.setPerson(user);
        newPersonWebService.setEncryptedPassword(user.getPassword());
        return personWebServiceService.savePersonWebServiceEntity(newPersonWebService);
    }

    private boolean existContactPublicIdInContactWebServiceEntity(ContactEntity contactEntity){
        boolean exist = true;

        ContactWebServiceEntity contactWebServiceEntity = contactWebServiceService.findContactWebServiceEntityByContactEntityFast(contactEntity);

        if(null==contactWebServiceEntity){
            exist=false;
        }

        return exist;
    }


    private String generatePublicId() {
        return utils.generateUniquePublicId();
    }


}
