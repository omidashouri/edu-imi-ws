package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;

public interface PersonWebServiceService  {

    PersonWebServiceEntity findByPersonId(Long personId);

    PersonWebServiceEntity savePersonWebServiceEntity(PersonWebServiceEntity personWebServiceEntity);

    PersonWebServiceEntity savePersonWebServiceByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity);
}
