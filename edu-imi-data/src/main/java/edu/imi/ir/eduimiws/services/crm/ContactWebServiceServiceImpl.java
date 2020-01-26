package edu.imi.ir.eduimiws.services.crm;


import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.repositories.crm.ContactWebServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactWebServiceServiceImpl implements ContactWebServiceService {


    private final ContactWebServiceRepository contactWebServiceRepository;

    @Override
    public ContactWebServiceEntity saveContactWebServiceEntity(ContactWebServiceEntity contactWebServiceEntity) {
        return contactWebServiceRepository.save(contactWebServiceEntity);
    }

    @Override
    public ContactWebServiceEntity saveContactWebServiceByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person) {
        ContactWebServiceEntity newContactWebService = new ContactWebServiceEntity();
        newContactWebService.setContactPublicId(publicContactId);
        newContactWebService.setContactId(person.getContactId());
        return contactWebServiceRepository.save(newContactWebService);
    }

    @Override
    public ContactWebServiceEntity findContactWebServiceEntityByContactEntity(ContactEntity contactEntity) {
        return contactWebServiceRepository.findByContactId(contactEntity);
    }
}
