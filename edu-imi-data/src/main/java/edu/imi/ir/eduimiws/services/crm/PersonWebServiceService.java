package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;

import java.util.List;

public interface PersonWebServiceService  {
//NU
//    PersonWebServiceEntity findByPersonEntity(PersonEntity personEntity);
//NU
//    Page<PersonWebServiceEntity> findAllPageByPageAndSize(int page,int size);

    List<PersonWebServiceEntity> findAllListByPageAndSize(int page,int size);

//    NU
    PersonWebServiceEntity findByPersonId(Long personId);

    PersonWebServiceEntity findByUserNameFast(String userName);

    PersonWebServiceEntity findPersonWebServiceEntityByUserPublicId(String userPublicId);

    PersonWebServiceEntity savePersonWebServiceEntity(PersonWebServiceEntity personWebServiceEntity);

    PersonWebServiceEntity savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity);

//    NU
    List<PersonWebServiceEntity> findAllPersonWebServiceIdProjection();

    Long personWebServiceCount();

    PersonWebServiceEntity selectLastRecord();

    List<PersonWebServiceEntity> generatePersonWebServicePublicId(List<PersonEntity> newPersons);
}
