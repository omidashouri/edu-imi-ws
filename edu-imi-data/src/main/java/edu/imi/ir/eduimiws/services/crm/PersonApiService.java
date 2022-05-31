package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;

import java.util.Collection;
import java.util.List;

@MappingUtil.PersonApiService
public interface PersonApiService {
//NU
//    PersonApiEntity findByPersonEntity(PersonEntity personEntity);
//NU
//    Page<PersonApiEntity> findAllPageByPageAndSize(int page,int size);

    List<PersonApiEntity> findAllListByPageAndSize(int page, int size);

//    NU
    PersonApiEntity findByPersonId(Long personId);

    @MappingUtil.PersonIdToPersonPublicId
    String findPersonPublicIdByPersonId(Long personId);

    PersonApiEntity findByUserNameFast(String userName);

    PersonApiEntity findPersonApiEntityByUserPublicId(String userPublicId);

    PersonApiEntity savePersonApiEntity(PersonApiEntity personApiEntity);

    PersonApiEntity savePersonApiByPublicPersonIdAndPublicContactIdAndPersonEntity(String publicPersonId, String publicContactId, PersonEntity personEntity);

    PersonApiEntity findByPersonPublicIdWithPersonAndRole(String userPublicId);

//    NU
    List<PersonApiEntity> findAllPersonApiIdProjection();

    Long personApiCount();

    PersonApiEntity selectLastRecord();

    List<PersonApiEntity> generatePersonApiPublicId(List<PersonEntity> newPersons);

    List<PersonApiEntity> findAllByPersonIdIn(List<Long> personIds);

    PersonApiEntity updateByPersonApiAndRoleName(PersonApiEntity personApi, Collection<String> rolePublicIds);
}
