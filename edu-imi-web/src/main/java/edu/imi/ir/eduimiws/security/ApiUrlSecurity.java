package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Order(1)
@EnableWebSecurity
@RequiredArgsConstructor
@ComponentScans({@ComponentScan("edu.imi.ir.eduimiws.*")})
public class ApiUrlSecurity {

/*    private final UserService userService;
    private final ErpPasswordEncoder bCryptPasswordEncoder;*/
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final ApiUrlSecurityCredential apiUrlSecurityCredential;
    private final AuthenticationFilter authenticationFilter;
    private final AuthorizationFilter authorizationFilter;
    private final DigitalPaymentCredential digitalPayMentCredential;




    @Bean
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/api/**")
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // Permit all for signup and various POST endpoints
                        .requestMatchers("/**").permitAll()
                        .requestMatchers(HttpMethod.POST, apiUrlSecurityCredential.getSignUpUrl()).permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/reqres/**").permitAll()
                        .requestMatchers("/api/v1/callback/sadad/**").permitAll()
                        .requestMatchers(HttpMethod.GET, apiUrlSecurityCredential.getVerificationEmailUrl()).permitAll()
                        .requestMatchers(HttpMethod.POST, apiUrlSecurityCredential.getPasswordResetRequestUrl()).permitAll()
                        .requestMatchers(HttpMethod.POST, apiUrlSecurityCredential.getPasswordResetUrl()).permitAll()
                        .requestMatchers(HttpMethod.POST, digitalPayMentCredential.getBehpardakhtCredential().getAfterPaymentResponseUrl()).permitAll()

                        // Permit Swagger UI and docs URLs
                        .requestMatchers(apiUrlSecurityCredential.getSwaggerUiAntMatchers()).permitAll()

                        // All other requests should be authenticated
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(customAuthenticationEntryPoint)
                        .accessDeniedHandler(customAccessDeniedHandler)
                )
                .addFilter(authenticationFilter)
                .addFilter(authorizationFilter)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.headers(headers -> headers.frameOptions(Customizer. withDefaults()));  // Disable frame options for H2 console if needed
/*        httpSecurity.headers(headers -> headers
                .frameOptions(frame -> frame.disable())
        );*/
        return httpSecurity.build();
    }

    // Define the AuthenticationProvider for the DaoAuthenticationProvider


    // Define the CORS configuration source
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
        //      specify what we want to be displayed on the header
        corsConfiguration.setExposedHeaders(List.of("Authorization", "userPublicId"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    // Enable method-level security
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
        public MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
            Map<String, List<ConfigAttribute>> methodMap = new HashMap<>();
            methodMap.put("edu.imi.ir.eduimiws.controllers.v1.ContactController.getContactCountByNationalCode*",
                    SecurityConfig.createList("ROLE_ADMIN"));
            return new MapBasedMethodSecurityMetadataSource(methodMap);
        }
    }

    //join your comma separated ips into an expression for the .access() method
    // Helper function to handle IP range validation (if needed)
    private String createHasIpRangeExpression() {
        String ipRanges = apiUrlSecurityCredential.getIpRanges();
        List<String> validIps = Arrays.asList(ipRanges.split("\\s*,\\s*"));
        return validIps.stream()
                .collect(Collectors.joining("') or hasIpAddress('", "hasIpAddress('", "') and isAuthenticated()"));
    }

}
