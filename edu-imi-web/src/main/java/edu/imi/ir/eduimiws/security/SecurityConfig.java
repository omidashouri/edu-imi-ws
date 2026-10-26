package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@Configuration
public class SecurityConfig {

    @Autowired
    UserService userService;

    @Autowired
    ErpPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public AuthenticationManager authenticationManager1(AuthenticationProvider daoAuthenticationProvider) {
        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }

    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    /**
     * These filters are {@code @Component} beans and would otherwise register on {@code /*}.
     * Keep them only inside {@link ApiUrlSecurity}'s {@code /api/**} chain.
     */
    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilterRegistration(
            AuthenticationFilter authenticationFilter) {
        FilterRegistrationBean<AuthenticationFilter> registration =
                new FilterRegistrationBean<>(authenticationFilter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilterRegistration(
            AuthorizationFilter authorizationFilter) {
        FilterRegistrationBean<AuthorizationFilter> registration =
                new FilterRegistrationBean<>(authorizationFilter);
        registration.setEnabled(false);
        return registration;
    }

}
