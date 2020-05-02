package edu.imi.ir.eduimiws.models.user;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MyCurrentUser extends User {

    public MyCurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyCurrentUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    //    do it later, handle building MyCurrentUser with person constructor
    public MyCurrentUser(PersonEntity person) {
/*        this(person.getUsername(), person.getPassword(), person.getPersonApiEntity() != null ?
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")) :
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));*/
        this(person.getUsername(),
                person.getPassword(),
                person.getActivityStatus().equalsIgnoreCase("1") ? true : false,
                true,
                true,
                true,
                (person.getPersonApiEntity() == null) ?
                        new ArrayList<>() :
                        (person.getPersonApiEntity().getRoles() == null) ?
                                (Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))) :
                                (person.getPersonApiEntity().getRoles().stream().findFirst().get().getPrivileges() == null) ?
                                        (person
                                                .getPersonApiEntity()
                                                .getRoles()
                                                .stream()
                                                .map(p -> new SimpleGrantedAuthority(p.getName()))
                                                .collect(Collectors.toList())) :
                                        (person
                                                .getPersonApiEntity()
                                                .getRoles()
                                                .stream()
                                                .flatMap(role -> role.getPrivileges().stream())
                                                .map(p -> new SimpleGrantedAuthority(p.getName()))
                                                .collect(Collectors.toList()))
        );

        if (person.getPersonApiEntity() != null) {
            authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            if (person.getPersonApiEntity().getRoles() != null) {
                this.authorities = person
                        .getPersonApiEntity()
                        .getRoles()
                        .stream()
                        .flatMap(role -> role.getPrivileges().stream())
                        .map(p -> new SimpleGrantedAuthority(p.getName()))
                        .collect(Collectors.toList());
            }
        }

        if (person.getPersonApiEntity() != null) {
            this.userPublicId = person.getPersonApiEntity().getPersonPublicId();
            this.contactPublicId = person.getPersonApiEntity().getContactPublicId();
        }
    }

    private String firstName;
    private String lastName;
    private String fullName;
    private String nationalCode;
    private String userPublicId;
    private String contactPublicId;
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private List<GrantedAuthority> authorities;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + ' ' + this.lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getUserPublicId() {
        return userPublicId;
    }

    public void setUserPublicId(String userPublicId) {
        this.userPublicId = userPublicId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getContactPublicId() {
        return contactPublicId;
    }

    public void setContactPublicId(String contactPublicId) {
        this.contactPublicId = contactPublicId;
    }
}
