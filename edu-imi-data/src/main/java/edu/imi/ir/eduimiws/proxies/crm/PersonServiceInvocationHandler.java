package edu.imi.ir.eduimiws.proxies.crm;

import edu.imi.ir.eduimiws.services.crm.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Component
public class PersonServiceInvocationHandler implements InvocationHandler {

    private final PersonService personService;

    @Autowired
    public PersonServiceInvocationHandler(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before " + method.getName());
        Object result = method.invoke(personService, args);
        System.out.println("after " + method.getName());
        return result;
    }
}
