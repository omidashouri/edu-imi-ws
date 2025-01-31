package edu.imi.ir.eduimiws.security;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Order(2)
@EnableWebSecurity
public class WebUrlSecurity {
    @Bean
    public SecurityFilterChain webSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/web/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/web/sadad/**").permitAll()
                        .requestMatchers("**/swagger-ui/**", "/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs", "/v2/api-docs/**", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }
}
