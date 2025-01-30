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
        PersonEntity personEntity = personRepository.findByUsername(userName);
//        omiddo: check person is not null or person is not duplicate
        return personEntity;
    }

    @Override
    public Long personCount() {
        return personRepository.count();
    }

    @Override
    public PersonEntity selectLastRecord() {
        return personRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public List<PersonEntity> findPersonUserProjectionsByIdGreaterThan(Long id) {
        List<PersonUserProjection> personUserProjections =
                personRepository.findPersonUserProjectionsByIdGreaterThan(id);
        List<PersonEntity> persons = personUserProjectionMapper
                .toPersonEntitys(personUserProjections, new CycleAvoidingMappingContext());
        return persons;
    }

    @Override
    public List<PersonEntity> findAllPersonUserProjectionOrderById() {
        List<PersonUserProjection> personUserProjections = personRepository
                .findAllPersonUserProjection();
        personUserProjections.sort(Comparator.comparing(edu.imi.ir.eduimiws.models.projections.crm.PersonUserProjection::getId));
        List<PersonEntity> persons = personUserProjectionMapper
                .toPersonEntitys(personUserProjections, new CycleAvoidingMappingContext());
        return persons;
    }

    @Override
    public Long selectPersonLastSequenceNumber() {
        return personRepository.selectLastSequenceNumber();
    }

    @Override
    public PersonEntity findPersonEntityByPersonApiPublicId(String personPublicId) {
        PersonEntity person = personRepository
                .findByPersonApiEntity_PersonPublicId(personPublicId);
        return person;
    }

    @Override
    public PersonDto findPersonDtoByPersonApiPublicId(String personPublicId) {
        PersonDto newPersonDto = personMapper
                .personEntityToPersonDto(personRepository.readByPersonApiEntity_PersonPublicId(personPublicId),
                        new CycleAvoidingMappingContext());
        return newPersonDto;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntityPages(Pageable pageable) {
        Page<PersonEntity> personPages = personRepository
                .findAll(pageable);
        return personPages;
    }

    @Override
    public Page<PersonEntity> findAllPersonEntityPagesByUserName(Pageable pageable, String userName) {
        Page<PersonEntity> personPages = personRepository
                .findAllByUsername(pageable, userName);
        return personPages;
    }

    @Override
    public List<PersonEntity> findPersonsByNationalCode(String nationalCode) {
        List<PersonEntity> personEntities = personRepository
                .findPersonEntitiesByContact_NationCode(nationalCode);
        return personEntities;
    }

    @Override
    public List<PersonEntity> findAllPersonEntitiesByIdIn(List<Long> personIds) {
        List<PersonEntity> newPersons =
                personRepository.findAllPersonEntitiesByIdIn(personIds);
        return newPersons;
    }

    @Override
    public PersonEntity savePerson(PersonEntity newPerson) {
        return personRepository.save(newPerson);
    }

    @Override
    public Specification<PersonEntity> getPersonQuerySpecification(String firstName, String lastName) {
        return (root, query, criteriaBuilder) -> {
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
    }

    @Override
    public Page<PersonEntity> findAllPersonEntitySpecificationPages(Pageable pageable, Specification specification) {
        return personRepositorySpecification.findAll(specification, pageable);
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
