package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.ContactApiEntity;
import edu.imi.ir.eduimiws.domain.crm.ContactEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;

public interface ContactApiService {
//NU
//    ContactApiEntity saveContactWebServiceEntity(ContactApiEntity contactWebServiceEntity);

    ContactApiEntity saveContactWebServiceByPublicContactIdAndPersonEntity(String publicContactId, PersonEntity person);

    ContactApiEntity findContactWebServiceEntityByContactEntityFast(ContactEntity contact);

    List<ContactApiEntity> saveAllContactWebServices(List<ContactApiEntity> contactWebServices);

    List<ContactApiEntity> generateContactWebServicePublicId(List<ContactEntity> newContacts);
}
