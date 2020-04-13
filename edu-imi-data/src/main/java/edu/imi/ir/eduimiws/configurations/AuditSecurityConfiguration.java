package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import org.springframework.data.domain.AuditorAware;

//comment annotation
/*@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")*/
public class AuditSecurityConfiguration {
//    comment annotation
//    @Bean
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
//        comment block here
/*                new AuditorAware<PersonEntity>() {
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