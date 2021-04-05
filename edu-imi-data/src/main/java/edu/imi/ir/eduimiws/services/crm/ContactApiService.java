package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;

public interface ContactApiService {
//NU
//    ContactApiEntity saveContactWebServiceEntity(ContactApiEntity contactWebServiceEntity);

    ContactApiEntity saveContactApiByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person);

    ContactEntity findContactByContactPublicId(String contactPublicId);

    Long findContactIdByContactPublicId(String contactPublicId);

    ContactApiEntity findContactApiEntityByContactEntityFast(ContactEntity contact);

    List<ContactApiEntity> saveAllContactApi(List<ContactApiEntity> contactApis);

    List<ContactApiEntity> generateContactApiPublicId(List<ContactEntity> newContacts);
}
