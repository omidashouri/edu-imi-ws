package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.exceptions.UserServiceException;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public PersonEntity findById(Long id) {
        return personRepository.findById(id).orElseThrow(()-> new UserServiceException("person not found for "+id));
    }

    @Override
    public PersonEntity findByUserName(String userName) {
        PersonEntity personEntity = personRepository.findByUsername(userName);
//        omiddo: check person is not null or person is not duplicate
        return personEntity;
    }

    @Override
    public List<PersonEntity> findAllByUserNameContaining(String userName) {
        return personRepository.findAllByUserNameContaining(userName);
    }

    @Override
    public PersonEntity findByContactId(Long contactId) {
        return personRepository.findByContactId(contactId);
    }


}
