package edu.imi.ir.eduimiws.models.user;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.crm.PrivilegeApiEntity;
import edu.imi.ir.eduimiws.domain.crm.RoleApiEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


public class MyErpUser extends User {

    public MyErpUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MyErpUser(String username, String password, boolean enabled,
                     boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                     Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public MyErpUser(PersonEntity person) {
        this(person.getUsername(),
                person.getPassword(),
                person.getActivityStatus().equalsIgnoreCase("1") ? true : false,
                (person.getPersonApiEntity() == null) ? true :
                        (person.getPersonApiEntity().getAccountNonExpired() == null) ? true :
                                (person.getPersonApiEntity().getAccountNonExpired() == 0L) ? false :
                                        true,
                (person.getPersonApiEntity() == null) ? true :
                        (person.getPersonApiEntity().getCredentialsNonExpired() == null) ? true :
                                (person.getPersonApiEntity().getCredentialsNonExpired() == 0L) ? false :
                                        true,
                (person.getPersonApiEntity() == null) ? true :
                        (person.getPersonApiEntity().getCredentialsNonExpired() == null) ? true :
                                (person.getPersonApiEntity().getCredentialsNonExpired() == 0L) ? false :
                                        true,
                (person.getPersonApiEntity() == null) ?
                        new ArrayList<>() :

                        (person.getPersonApiEntity().getRoles() == null || person.getPersonApiEntity().getRoles().isEmpty()) ?
                                (Arrays.asList(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) :

                                (person.getPersonApiEntity().getRoles().stream().findFirst().get().getPrivileges() == null) ?
                                        (person
                                                .getPersonApiEntity()
                                                .getRoles()
                                                .stream()
                                                .map(p -> new SimpleGrantedAuthority("READ_PRIVILEGES"))
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
            this.setUserPublicId(person.getPersonApiEntity().getPersonPublicId());
            this.setContactPublicId(person.getPersonApiEntity().getContactPublicId());
            if (person.getPersonApiEntity().getRoles() != null && person.getPersonApiEntity().getRoles().size()>0 ) {
                this.setRoles(person.getPersonApiEntity().getRoles());
                if (person.getPersonApiEntity().getRoles().stream().findAny().get().getPrivileges() != null) {
                    this.setPrivileges(person
                            .getPersonApiEntity()
                            .getRoles()
                            .stream()
                            .flatMap(role -> role.getPrivileges().stream())
                            .distinct()
                            .collect(Collectors.toList()));
                }
            }
        }

        this.setUsername(super.getUsername());
        this.setPassword(super.getPassword());
        this.setAuthorities(super.getAuthorities());
        this.setFirstName(person.getFirstName());
        this.setLastName(person.getLastName());
        this.setFullName(new StringBuilder()
                .append(person.getFirstName())
                .append(" ")
                .append(person.getLastName())
                .toString());
        this.setAccountNonExpired(super.isAccountNonExpired());
        this.setAccountNonLocked(super.isAccountNonLocked());
        this.setCredentialsNonExpired(super.isCredentialsNonExpired());
        if (person.getContact() != null) {
            this.nationalCode = person.getContact().getNationCode();
        }
        if (person.getActivityStatus() != null) {
            switch (person.getActivityStatus()) {
                case "0":
                    this.setEnabled(false);
                    break;
                case "1":
                    this.setEnabled(true);
                    break;
                default:
                    this.setEnabled(true);
            }

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
    private Collection<RoleApiEntity> roles;
    private Collection<PrivilegeApiEntity> privileges;
    private Collection<GrantedAuthority> authorities;

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
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Collection<RoleApiEntity> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleApiEntity> roles) {
        this.roles = roles;
    }

    public Collection<PrivilegeApiEntity> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<PrivilegeApiEntity> privileges) {
        this.privileges = privileges;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getContactPublicId() {
        return contactPublicId;
    }

    public void setContactPublicId(String contactPublicId) {
        this.contactPublicId = contactPublicId;
    }
}
