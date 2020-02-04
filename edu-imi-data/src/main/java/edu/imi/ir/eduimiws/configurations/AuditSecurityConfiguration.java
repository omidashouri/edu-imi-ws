package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.repositories.crm.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditSecurityConfiguration {
    @Bean
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
        };

    }
}