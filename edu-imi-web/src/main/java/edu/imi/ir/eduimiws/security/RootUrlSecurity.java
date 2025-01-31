package edu.imi.ir.eduimiws.security;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Order(3)
@EnableWebSecurity
public class RootUrlSecurity {

    @Bean
    public SecurityFilterChain rootSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .securityMatcher("/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("**/swagger-ui/**", "/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs", "/v2/api-docs/**", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "**/afterPaymentResponse").permitAll()
                        .requestMatchers(HttpMethod.POST, "**/v1/callback/sadad/publicId/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }
}
