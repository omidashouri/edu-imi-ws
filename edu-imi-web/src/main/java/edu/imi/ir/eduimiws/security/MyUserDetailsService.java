package edu.imi.ir.eduimiws.security;


import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.models.user.MyCurrentUser;
import edu.imi.ir.eduimiws.services.crm.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
// RM
//@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonServiceImpl personService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Try to find user and its roles, for example here we try to get it from database via a DAO object
        //Do not confuse this foo.bar.User with CurrentUser or spring User, this is a temporary object which holds user info stored in database
       /* omiddo: later correct this
       PersonEntity user = personService.findByUserNameFast(username);*/

        //Build user Authority. some how a convert from your custom roles which are in database to spring GrantedAuthority
        /*omiddo: after creating user role entity uncomment this part
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());*/


        PersonEntity user = new PersonEntity();
        user.setUsername("9057");
        user.setPassword("9057");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));


        //The magic is happen in this private method !
        return buildUserForAuthentication(user, authorities);
    }

    //Fill your extended User object (CurrentUser) here and return it
    private User buildUserForAuthentication(PersonEntity user,
                                            List<GrantedAuthority> authorities) {
        String username = user.getUsername();
        String password = user.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new MyCurrentUser(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
        //If your database has more information of user for example firstname,... You can fill it here
        //CurrentUser currentUser = new CurrentUser(....)
        //currentUser.setFirstName( user.getfirstName() );
        //.....
        //return currentUser ;

    }


/*    omiddo: create user role entity
    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }*/

}
