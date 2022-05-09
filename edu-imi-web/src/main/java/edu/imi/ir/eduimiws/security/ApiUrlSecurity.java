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
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Order(1)
@EnableWebSecurity
@RequiredArgsConstructor
@ComponentScans({@ComponentScan("edu.imi.ir.eduimiws.*")})
public class ApiUrlSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final ErpPasswordEncoder bCryptPasswordEncoder;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final ApiUrlSecurityCredential apiUrlSecurityCredential;
    private final DigitalPaymentCredential digitalPayMentCredential;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .antMatcher("/api/**")
                .cors().and()

                .csrf().disable().authorizeRequests()

                .antMatchers(HttpMethod.POST, apiUrlSecurityCredential.getSignUpUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST, "/api/v1/reqres/**")
//                .antMatchers("/admin/**").access("hasRole('admin') and hasIpAddress('0:0:0:0:0:0:0:1')")
                .permitAll()

//                .antMatchers("/**/sabtahval/**")
//                .access(this.createHasIpRangeExpression())

                .antMatchers("/api/v1/reqres/**")
                .permitAll()

                .antMatchers("/api/v1/callback/sadad/**")
                .permitAll()

                .antMatchers(HttpMethod.GET, apiUrlSecurityCredential.getVerificationEmailUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST, apiUrlSecurityCredential.getPasswordResetRequestUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST, apiUrlSecurityCredential.getPasswordResetUrl())
                .permitAll()

//                .antMatchers(HttpMethod.POST, securityProperties.getBehpardakhtAfterPaymentResponseUrl())
                .antMatchers(HttpMethod.POST, digitalPayMentCredential.getBehpardakhtCredential().getAfterPaymentResponseUrl())
                .permitAll()
/*
                .antMatchers(appProperties.getH2Console())
                .permitAll()
*/

                .antMatchers(apiUrlSecurityCredential.getSwaggerUiAntMatchers())
                .permitAll()

//                or .hasAuthority("ADMIN")
//                .antMatchers("/delete/**").hasRole("ADMIN")
//                .antMatchers("/secure/**").access("hasRole('ADMIN')")
//                .antMatchers("/secure/**").access("hasAuthority('ROLE_ADMIN')")
//                .antMatchers("/secure/**").access("request.method == 'GET'")

                .anyRequest()
                .authenticated()

//                .and().logout().permitAll()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))

/*                .and().sessionManagement()
                .maximumSessions(1).sessionRegistry(sessionRegistry())
                .and().sessionFixation().none()*/

                .and()

                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)// handles bad credentials
                .accessDeniedHandler(customAccessDeniedHandler)
                .and()

                .addFilter(getAuthenticationFilter())

                .addFilter(new AuthorizationFilter(authenticationManager()))
/*                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .maximumSessions(2).sessionRegistry(sessionRegistry())
                .and().sessionFixation().none();*/
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.headers().frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
/*        authenticationManagerBuilder.userDetailsService(userService)
                //omiddo: do my implementation for password encoding
                .passwordEncoder(bCryptPasswordEncoder);*/

        authenticationManagerBuilder
                .authenticationProvider(daoAuthenticationProvider())
/*
//              omiddo: in future develop this part
               .inMemoryAuthentication()
               .withUser("admiin").password("{noop}admiin").roles("ADMIN")
               .and()
               .withUser("useer").password("{noop}useer").roles("USER")
*/
        ;
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
/*        filter.setAllowSessionCreation(true);
        filter.setSessionAuthenticationStrategy(sessionAuthenticationStrategy());*/
        filter.setFilterProcessesUrl("/api/users/login");
        return filter;
    }

/*    @Bean
    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(sessionRegistry());
    }*/

/*    public CsrfTokenRepository csrfTokenRepository() {
        return new LazyCsrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }*/

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        final DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();

//        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));

                corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));

//        corsConfiguration.setAllowedMethods(List.of("*"));

//      specify what we want to be displayed on the header
        corsConfiguration.setExposedHeaders(List.of("Authorization","userPublicId"));

//        corsConfiguration.setAllowCredentials(true);

//        corsConfiguration.setAllowedHeaders(List.of("*"));

        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter(urlBasedCorsConfigurationSource));
        filterRegistrationBean.setOrder(0);
        return urlBasedCorsConfigurationSource;
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

        public MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
            Map<String, List<ConfigAttribute>> methodMap = new HashMap<>();
            methodMap.put("edu.imi.ir.eduimiws.controllers.v1.ContactController.getContactCountByNationalCode*",
                    SecurityConfig.createList("ROLE_ADMIN"));
            return new MapBasedMethodSecurityMetadataSource(methodMap);
        }

    }

    //        join your comma separated ips into an expression for the .access() method
    private String createHasIpRangeExpression() {

        String ipRanges = apiUrlSecurityCredential.getIpRanges();
        List<String> validIps = Arrays.asList(ipRanges.split("\\s*,\\s*"));
        String hasIpRangeAccessExpresion = validIps.stream()
                .collect(Collectors.joining("') or hasIpAddress('", "hasIpAddress('", "') and isAuthenticated()"));
        return hasIpRangeAccessExpresion;
    }

}
