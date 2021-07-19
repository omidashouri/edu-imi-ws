package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    PersonEntity findPersonEntityByPersonApiPublicId(String personPublicId);

    @MappingUtil.PersonPublicIdToPersonDto
    PersonDto findPersonDtoByPersonApiPublicId(String personPublicId);

    Page<PersonEntity> findAllPersonEntityPages(Pageable pageable);

    Page<PersonEntity> findAllPersonEntityPagesByUserName(Pageable pageable,String userName);

    List<PersonEntity> findPersonsByNationalCode(String nationalCode);

    List<PersonEntity> findAllPersonEntitiesByIdIn(List<Long> personIds);

    PersonEntity savePerson(PersonEntity newPerson);

}
