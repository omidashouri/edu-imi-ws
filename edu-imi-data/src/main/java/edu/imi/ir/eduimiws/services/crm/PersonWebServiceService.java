package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;

public interface PersonWebServiceService  {
//NU
//    PersonApiEntity findByPersonEntity(PersonEntity personEntity);
//NU
//    Page<PersonApiEntity> findAllPageByPageAndSize(int page,int size);

    List<PersonApiEntity> findAllListByPageAndSize(int page, int size);

//    NU
    PersonApiEntity findByPersonId(Long personId);

    PersonApiEntity findByUserNameFast(String userName);

    PersonApiEntity findPersonWebServiceEntityByUserPublicId(String userPublicId);

    PersonApiEntity savePersonWebServiceEntity(PersonApiEntity personApiEntity);

    PersonApiEntity savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity);

//    NU
    List<PersonApiEntity> findAllPersonWebServiceIdProjection();

    Long personWebServiceCount();

    PersonApiEntity selectLastRecord();

    List<PersonApiEntity> generatePersonWebServicePublicId(List<PersonEntity> newPersons);
}
