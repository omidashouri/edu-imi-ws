package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.services.SwaggerCaptchaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Browser login for Swagger only. API requests stay on the stateless JWT chain.
 */
@Configuration
@Order(0)
@EnableWebSecurity
public class SwaggerDocsSecurity {

    private final AuthenticationProvider daoAuthenticationProvider;
    private final SwaggerCaptchaService swaggerCaptchaService;

    public SwaggerDocsSecurity(AuthenticationProvider daoAuthenticationProvider,
                               SwaggerCaptchaService swaggerCaptchaService) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
        this.swaggerCaptchaService = swaggerCaptchaService;
    }

    @Bean
    @Order(0)
    public SecurityFilterChain swaggerDocsSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher(
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/v2/api-docs/**",
                        "/configuration/**",
                        "/webjars/**",
                        "/swagger-login",
                        "/swagger-captcha",
                        "/swagger-session-end",
                        "/swagger-assets/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-login",
                                "/swagger-captcha",
                                "/swagger-session-end",
                                "/swagger-assets/**",
                                "/css/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/swagger-login")
                        .loginProcessingUrl("/swagger-login")
                        // tab=1 marks this browser tab as freshly authenticated (sessionStorage).
                        .defaultSuccessUrl("/swagger-ui/index.html?tab=1", true)
                        .failureUrl("/swagger-login?error")
                        .permitAll())
                .logout(AbstractHttpConfigurer::disable)
                // CSRF stays on the login form. Definition and UI GETs do not need it.
                .csrf(csrf -> csrf.ignoringRequestMatchers(
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/swagger-session-end"))
                .headers(headers -> headers.cacheControl(Customizer.withDefaults()))
                .authenticationProvider(daoAuthenticationProvider)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .addFilterBefore(new SwaggerCaptchaFilter(swaggerCaptchaService),
                        UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
