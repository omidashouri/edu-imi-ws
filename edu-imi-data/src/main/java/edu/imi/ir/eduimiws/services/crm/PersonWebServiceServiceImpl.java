package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.PersonWebServiceMapper;
import edu.imi.ir.eduimiws.repositories.crm.PersonWebServiceRepository;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import edu.imi.ir.eduimiws.utilities.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonWebServiceServiceImpl implements PersonWebServiceService{

    private final PersonWebServiceMapper personWebServiceMapper;
    private final PersonWebServiceRepository personWebServiceRepository;
    private final PersonService personService;
    private final ErpPasswordEncoder erpPasswordEncoder;
    private final Utils utils;


    @Override
    public PersonWebServiceEntity findByPersonId(Long personId) {

        PersonWebServiceEntity personWebServiceEntity = personWebServiceRepository.findByPersonId(personId);
        return personWebServiceEntity;
    }

    @Override
    public PersonWebServiceEntity savePersonWebServiceEntity(PersonWebServiceEntity personWebServiceEntity) {
        return personWebServiceRepository.save(personWebServiceEntity);
    }

    @Override
    public PersonWebServiceEntity savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity) {
        PersonWebServiceEntity newPersonWebService = new PersonWebServiceEntity();
        newPersonWebService.setContactId(personEntity.getContactId());
        newPersonWebService.setContactPublicId(publicContactId);
        newPersonWebService.setPersonPublicId(publicPersonId);
        newPersonWebService.setPersonId(personEntity);
        newPersonWebService.setEncryptedPassword(personEntity.getPassword());
        return personWebServiceRepository.save(newPersonWebService);
    }
}
