package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.utilities.AppProperties;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import lombok.RequiredArgsConstructor;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Order(1)
@EnableWebSecurity
@RequiredArgsConstructor
@ComponentScans({@ComponentScan("edu.imi.ir.eduimiws.*")})
public class ApiUrlSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final ErpPasswordEncoder bCryptPasswordEncoder;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private AppProperties appProperties;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .antMatcher("/api/**")
                .cors().and()

                .csrf().disable().authorizeRequests()

                .antMatchers(HttpMethod.POST,appProperties.getSignUpUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST,"/api/v1/reqres/**")
                .permitAll()

                .antMatchers("/api/v1/reqres/**")
                .permitAll()

                .antMatchers(HttpMethod.GET,appProperties.getVerificationEmailUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST,appProperties.getPasswordResetRequestUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST,appProperties.getPasswordResetUrl())
                .permitAll()

                .antMatchers(HttpMethod.POST,appProperties.getBehpardakhtAfterPaymentResponseUrl())
                .permitAll()
/*
                .antMatchers(appProperties.getH2Console())
                .permitAll()
*/

                .antMatchers("**/swagger-ui/**","/swagger-ui/**","/v3/api-docs/**","/v3/api-docs","/v2/api-docs/**","/configuration/**","/swagger*/**","/webjars/**")
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
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
/*        authenticationManagerBuilder.userDetailsService(userService)
                //omiddo: do my implementation for password encoding
                .passwordEncoder(bCryptPasswordEncoder);*/

        authenticationManagerBuilder
                .authenticationProvider(daoAuthenticationProvider())

        .inMemoryAuthentication()
                .withUser("admiin").password("{noop}admiin").roles("ADMIN")
                .and()
                .withUser("useer").password("{noop}useer").roles("USER");
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception{
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
    public AuthenticationProvider daoAuthenticationProvider(){
        final DaoAuthenticationProvider daoAuthenticationProvider =
                                                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        final CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));

        corsConfiguration.setAllowedMethods(Arrays.asList("*"));

        corsConfiguration.setAllowCredentials(true);

        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return urlBasedCorsConfigurationSource;
        }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl() ;
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

}