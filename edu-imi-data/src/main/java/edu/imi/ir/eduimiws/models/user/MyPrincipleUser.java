package edu.imi.ir.eduimiws.models.user;

import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyPrincipleUser extends User {

    private PersonEntity person;

    public MyPrincipleUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyPrincipleUser(PersonApiEntity personApi) {
        this(personApi.getPerson().getUsername(),
                personApi.getPerson().getPassword(),
                        (personApi.getRoles() == null || personApi.getRoles().isEmpty()) ?
                                (Arrays.asList(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) :

                                (personApi.getRoles().stream().findFirst().get().getPrivileges() == null) ?
                                        (personApi
                                                .getRoles()
                                                .stream()
                                                .map(p -> new SimpleGrantedAuthority("READ_PRIVILEGES"))
                                                .collect(Collectors.toList())) :

                                        (personApi
                                                .getRoles()
                                                .stream()
                                                .flatMap(role -> role.getPrivileges().stream())
                                                .map(p -> new SimpleGrantedAuthority(p.getName()))
                                                .collect(Collectors.toList()))
        );
        this.person = personApi.getPerson();
    }

    public PersonEntity getPerson() {
        return person;
    }
}
