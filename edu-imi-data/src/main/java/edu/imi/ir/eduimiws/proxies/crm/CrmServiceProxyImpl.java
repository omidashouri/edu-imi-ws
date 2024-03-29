package edu.imi.ir.eduimiws.proxies.crm;

import edu.imi.ir.eduimiws.mapper.crm.PersonMapper;
import edu.imi.ir.eduimiws.mapper.crm.PersonUserProjectionMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.crm.UserFastDtoSaveMapper;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import edu.imi.ir.eduimiws.repositories.crm.specification.PersonRepositorySpecification;
import edu.imi.ir.eduimiws.services.crm.PersonService;
import edu.imi.ir.eduimiws.services.crm.PersonServiceImpl;
import edu.imi.ir.eduimiws.utilities.PublicIdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
@RequiredArgsConstructor
public class CrmServiceProxyImpl implements CrmServiceProxy {

    private final PersonRepository personRepository;
    private final PersonRepositorySpecification personRepositorySpecification;
    private final PersonUserProjectionMapper personUserProjectionMapper;
    private final UserFastDtoMapper userFastDtoMapper;
    private final UserFastDtoSaveMapper userFastDtoSaveMapper;
    private final PublicIdUtil publicIdUtil;
    private final PersonMapper personMapper;

    @Override
    public PersonService createPersonServiceProxyInstance() {
        PersonService personService = (PersonService) Proxy.newProxyInstance(
                PersonService.class.getClassLoader(), PersonServiceImpl.class.getInterfaces(),
                new PersonServiceInvocationHandler(
                        new PersonServiceImpl(personRepository, personRepositorySpecification,
                                personUserProjectionMapper, userFastDtoMapper, userFastDtoSaveMapper,
                                personMapper,publicIdUtil)
                )
        );
        return personService;
    }
}
