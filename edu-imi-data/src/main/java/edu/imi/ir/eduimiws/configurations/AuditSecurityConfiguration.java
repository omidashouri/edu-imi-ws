package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import org.springframework.data.domain.AuditorAware;

//remove comment from comment block 1 , 2 , 3
/*comment block 1
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")*/
public class AuditSecurityConfiguration {
/*    comment block 2
    @Bean */
    public AuditorAware<PersonEntity> auditorProvider(PersonRepository repo) {
        // Lookup Author instance corresponding to logged in user
/*        return () -> {
            Object principal =  Optional.ofNullable(SecurityContextHolder.getContext())
                    .map(SecurityContext::getAuthentication)
                    .filter(Authentication::isAuthenticated)
                    .map(Authentication::getPrincipal).get();
                    String userName = ((User) principal).getUsername();
                    PersonEntity person = repo.findByUsername(userName);
            return Optional.ofNullable(person);
        };*/

        return null;
/*        comment block 3
         return new AuditorAware<PersonEntity>() {
            @Override
            public Optional<PersonEntity> getCurrentAuditor() {
                if (SecurityContextHolder.getContext().getAuthentication() != null) {
                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    Object principal = auth.getPrincipal();
                    String userName = ((User) principal).getUsername();
                    PersonEntity person = repo.findByUsername(userName);
                    return Optional.ofNullable(person);
                } else {
                    return Optional.ofNullable(new PersonEntity());
                }
            }
        };*/

    }
}


/*

    note: for saving User:
    note: UserServiceImpl is class which implemented UserDetailsService
        PersonEntity person = new PersonRepository().findById(100160);
        final Authentication authentication = new UsernamePasswordAuthenticationToken(
                                                person,
                                                null,
                                                new UserServiceImpl().loadUserByUsername("9057").getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        note: now in save method:
        final Person person = (Person) SecurityContextHolder.getContext().getAuthentication().getPrinciple();
        person.setPassword(newPassword);
        new PersonService().save(person);

//for later use
        SecurityContextHolder.getContext().setAuthentication(authentication);
//        here User is org.springframework.security.core.userdetails.User
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 */

