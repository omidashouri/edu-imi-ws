package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonUserProjectionMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoSaveMapper;
import edu.imi.ir.eduimiws.models.dto.crm.PersonDto;
import edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import edu.imi.ir.eduimiws.repositories.crm.specification.PersonRepositorySpecification;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonRepositorySpecification personRepositorySpecification;
    private final PersonUserProjectionMapper personUserProjectionMapper;
    private final UserFastDtoMapper userFastDtoMapper;
    private final UserFastDtoSaveMapper userFastDtoSaveMapper;
    private final PersonMapper personMapper;
    private final PublicIdUtil publicIdUtil;
//NU
/*    @Override
    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElseThrow(()-> new UserServiceException("person not found for "+id));
    }*/

    @Override
    public PersonEntity findByUserNameFast(String userName) {
        log.info("PersonService.findByUserNameFast - userName: {}", userName);
        PersonEntity personEntity = personRepository.findByUsername(userName);
//        omiddo: check person is not null or person is not duplicate
        log.info("PersonService.findByUserNameFast - result: {}", personEntity);
        return personEntity;
    }

    @Override
    public Long personCount() {
        log.info("PersonService.personCount - start");
        Long result = personRepository.count();
        log.info("PersonService.personCount - result: {}", result);
        return result;
    }

    @Override
    public PersonEntity selectLastRecord() {
        log.info("PersonService.selectLastRecord - start");
        PersonEntity result = personRepository.findFirstByOrderByIdDesc();
        log.info("PersonService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public List<PersonEntity> findPersonUserProjectionsByIdGreaterThan(Long id) {
        log.info("PersonService.findPersonUserProjectionsByIdGreaterThan - id: {}", id);
        List<PersonUserProjection> personUserProjections =
                personRepository.findPersonUserProjectionsByIdGreaterThan(id);
        List<PersonEntity> persons = personUserProjectionMapper
                .toPersonEntitys(personUserProjections, new CycleAvoidingMappingContext());
        log.info("PersonService.findPersonUserProjectionsByIdGreaterThan - resultSize: {}",
                persons == null ? null : persons.size());
        return persons;
    }

    @Override
    public List<PersonEntity> findAllPersonUserProjectionOrderById() {
        log.info("PersonService.findAllPersonUserProjectionOrderById - start");
        List<PersonUserProjection> personUserProjections = personRepository
                .findAllPersonUserProjection();
        personUserProjections.sort(Comparator.comparing(edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection::getId));
        List<PersonEntity> persons = personUserProjectionMapper
                .toPersonEntitys(personUserProjections, new CycleAvoidingMappingContext());
        log.info("PersonService.findAllPersonUserProjectionOrderById - resultSize: {}",
                persons == null ? null : persons.size());
        return persons;
    }

    @Override
    public Long selectPersonLastSequenceNumber() {
        log.info("PersonService.selectPersonLastSequenceNumber - start");
        Long result = personRepository.selectLastSequenceNumber();
        log.info("PersonService.selectPersonLastSequenceNumber - result: {}", result);
        return result;
    }

    @Override
    public PersonEntity findPersonEntityByPersonApiPublicId(String personPublicId) {
        log.info("PersonService.findPersonEntityByPersonApiPublicId - personPublicId: {}", personPublicId);
        PersonEntity person = personRepository
                .findByPersonApiEntity_PersonPublicId(personPublicId);
        log.info("PersonService.findPersonEntityByPersonApiPublicId - result: {}", person);
        return person;
    }

    @Override
    public PersonDto findPersonDtoByPersonApiPublicId(String personPublicId) {
        log.info("PersonService.findPersonDtoByPersonApiPublicId - personPublicId: {}", personPublicId);
        PersonDto newPersonDto = personMapper
                .personEntityToPersonDto(personRepository.readByPersonApiEntity_PersonPublicId(personPublicId),
                        new CycleAvoidingMappingContext());
        log.info("PersonService.findPersonDtoByPersonApiPublicId - result: {}", newPersonDto);
        return newPersonDto;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntityPages(Pageable pageable) {
        log.info("PersonService.findAllPersonEntityPages - pageable: {}", pageable);
        Page<PersonEntity> personPages = personRepository
                .findAll(pageable);
        log.info("PersonService.findAllPersonEntityPages - resultSize: {}, totalElements: {}",
                personPages == null ? null : personPages.getNumberOfElements(),
                personPages == null ? null : personPages.getTotalElements());
        return personPages;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntityPagesByUserName(Pageable pageable, String userName) {
        log.info("PersonService.findAllPersonEntityPagesByUserName - pageable: {}, userName: {}", pageable, userName);
        Page<PersonEntity> personPages = personRepository
                .findAllByUsername(pageable, userName);
        log.info("PersonService.findAllPersonEntityPagesByUserName - resultSize: {}, totalElements: {}",
                personPages == null ? null : personPages.getNumberOfElements(),
                personPages == null ? null : personPages.getTotalElements());
        return personPages;
    }

    @Override
    public List<PersonEntity> findPersonsByNationalCode(String nationalCode) {
        log.info("PersonService.findPersonsByNationalCode - nationalCode: {}", nationalCode);
        List<PersonEntity> personEntities = personRepository
                .findPersonEntitiesByContact_NationCode(nationalCode);
        log.info("PersonService.findPersonsByNationalCode - resultSize: {}",
                personEntities == null ? null : personEntities.size());
        return personEntities;
    }

    @Override
    public List<PersonEntity> findAllPersonEntitiesByIdIn(List<Long> personIds) {
        log.info("PersonService.findAllPersonEntitiesByIdIn - personIds: {}", personIds);
        List<PersonEntity> newPersons =
                personRepository.findAllPersonEntitiesByIdIn(personIds);
        log.info("PersonService.findAllPersonEntitiesByIdIn - resultSize: {}",
                newPersons == null ? null : newPersons.size());
        return newPersons;
    }

    @Override
    public PersonEntity savePerson(PersonEntity newPerson) {
        log.info("PersonService.savePerson - newPerson: {}", newPerson);
        PersonEntity result = personRepository.save(newPerson);
        log.info("PersonService.savePerson - result: {}", result);
        return result;
    }

    @Override
    public Specification<PersonEntity> getPersonQuerySpecification(String firstName, String lastName) {
        log.info("PersonService.getPersonQuerySpecification - firstName: {}, lastName: {}", firstName, lastName);
        Specification<PersonEntity> result = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

           /* predicates.add(criteriaBuilder.equal(root.get("domainId"), domainId));
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), startDate));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), endDate));
*/
            if (firstName != null) {
                predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
            }

            if (lastName != null) {
                predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
            }



            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        log.info("PersonService.getPersonQuerySpecification - result: {}", result);
        return result;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntitySpecificationPages(Pageable pageable, Specification specification) {
        log.info("PersonService.findAllPersonEntitySpecificationPages - pageable: {}, specification: {}", pageable, specification);
        Page<PersonEntity> result = personRepositorySpecification.findAll(specification, pageable);
        log.info("PersonService.findAllPersonEntitySpecificationPages - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }


//NU
/*    @Override
    public List<PersonEntity> findAllByUserNameContaining(String userName) {
        return personRepository.findAllByUserNameContaining(userName);
    }*/
//NU
/*    @Override
    public PersonEntity findByContactId(Long contactId) {
        return personRepository.findByContactId(contactId);
    }*/

    private String generatePublicId() {
        return publicIdUtil.generateUniquePublicId();
    }

}
