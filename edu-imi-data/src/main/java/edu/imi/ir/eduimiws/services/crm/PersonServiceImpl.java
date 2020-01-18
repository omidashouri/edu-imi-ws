package edu.imi.ir.eduimiws.services.crm;

import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

}
