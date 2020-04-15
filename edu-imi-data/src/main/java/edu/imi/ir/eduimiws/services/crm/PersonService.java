package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;

import java.util.List;


public interface PersonService {
//NU
/*    PersonEntity findById(Long id);
//NU
    List<PersonEntity> findAllByUserNameContaining(String userName);
//NU
    PersonEntity findByContactId(Long contactId);*/

    PersonEntity findByUserNameFast(String userName);

    Long personCount();

    PersonEntity selectLastRecord();

    List<PersonEntity> findPersonUserProjectionsByIdGreaterThan(Long id);

    List<PersonEntity> findAllPersonUserProjectionOrderById();

    Long selectPersonLastSequenceNumber();

    PersonEntity findPersonEntityByPersonWebServicePublicId(String personPublicId);

}
