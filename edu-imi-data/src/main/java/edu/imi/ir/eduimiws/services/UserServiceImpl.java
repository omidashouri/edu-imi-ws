package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.PersonWebServiceMapper;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.services.crm.ContactService;
import edu.imi.ir.eduimiws.services.crm.ContactWebServiceService;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final PersonWebServiceMapper personWebServiceMapper;
    private final PersonWebServiceRepository personWebServiceRepository;
    private final PersonService personService;
    private final PersonWebServiceService personWebServiceService;
    private final ContactService contactService;
    private final ContactWebServiceService contactWebServiceService;
    private final ErpPasswordEncoder erpPasswordEncoder;
    private final Utils utils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        check username has public id -> if not generate public ID for contact and person

//        load user

        String publicContactId;
        String publicPersonId;

        ContactWebServiceEntity contactWebServiceEntity = new ContactWebServiceEntity();

        PersonWebServiceEntity newPersonWebServiceEntity = new PersonWebServiceEntity();


        PersonEntity user = personService.findByUserName(username);

        if (null == user) {
            throw new UsernameNotFoundException("user name not found for " + username);
        }


        PersonWebServiceEntity personWebServiceEntity = personWebServiceService.findByPersonId(user.getId());

        if (null == personWebServiceEntity) {

            publicContactId = generatePublicId();
            publicPersonId = generatePublicId();

            ContactWebServiceEntity savedContactWebServiceEntity =
                    contactWebServiceService
                            .saveContactWebServiceByPublicContactIdAndPersonEntity(publicContactId, user);

            personWebServiceService
                    .savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(publicPersonId,
                            savedContactWebServiceEntity.getContactPublicId(),
                            user);


//                omiddo: generate exception if publicContactId or publicPersonId is null
//            generate public_person_id and public_contact_id
        }



        /*

        User user = users.get(0);

//        let user to login without checking email verification, empty array list is for granted authorities
*//*        return new org.springframework.security.core.userdetails.User(user.getEmail()
                , user.getEncryptedPassword()
                , new ArrayList<>());*//*

//        let user login if user email is verified
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getEncryptedPassword(),
                user.getEmailVerificationStatus(),
                true,
                true,
                true,
                new ArrayList<>());



        return null;*/

        return null;
    }

    private PersonWebServiceEntity savePersonWebService(String publicPersonId, String publicContactId, PersonEntity user) {
        PersonWebServiceEntity newPersonWebService = new PersonWebServiceEntity();
        newPersonWebService.setContactId(user.getContactId());
        newPersonWebService.setContactPublicId(publicContactId);
        newPersonWebService.setPersonPublicId(publicPersonId);
        newPersonWebService.setPersonId(user);
        newPersonWebService.setEncryptedPassword(user.getPassword());
        return personWebServiceService.savePersonWebServiceEntity(newPersonWebService);
    }


    private String generatePublicId() {
        return utils.generateUniquePublicUserId();
    }


}
