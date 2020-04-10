package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactWebServiceEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;

public interface ContactWebServiceService {
//NU
//    ContactWebServiceEntity saveContactWebServiceEntity(ContactWebServiceEntity contactWebServiceEntity);

    ContactWebServiceEntity saveContactWebServiceByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person);

    ContactWebServiceEntity findContactWebServiceEntityByContactEntityFast(ContactEntity contact);

    List<ContactWebServiceEntity> saveAllContactWebServices(List<ContactWebServiceEntity> contactWebServices);
}
