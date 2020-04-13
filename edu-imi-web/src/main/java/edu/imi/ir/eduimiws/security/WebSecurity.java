package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.utilities.ErpPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final ErpPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .cors().and()

                .csrf().disable().authorizeRequests()

                .antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL)
                .permitAll()

                .antMatchers(HttpMethod.GET,SecurityConstants.VERIFICATION_EMAIL_URL)
                .permitAll()

                .antMatchers(HttpMethod.POST,SecurityConstants.PASSWORD_RESET_REQUEST_URL)
                .permitAll()

                .antMatchers(HttpMethod.POST,SecurityConstants.PASSWORD_RESET_URL)
                .permitAll()

                .antMatchers(SecurityConstants.H2_CONSOLE)
                .permitAll()

                .antMatchers("**/swagger-ui/**","/swagger-ui/**","/v3/api-docs/**","/v3/api-docs","/v2/api-docs/**","/configuration/**","/swagger*/**","/webjars/**")
                .permitAll()

//                or .hasAuthority("ADMIN")
//                .antMatchers("/delete/**").hasRole("ADMIN")

                .anyRequest()
                .authenticated()

//                .and().logout().permitAll()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))

        .and()

        .addFilter(getAuthenticationFilter())

        .addFilter(new AuthorizationFilter(authenticationManager()))

        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.headers().frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userService)
                //omiddo: do my implementation for password encoding
                .passwordEncoder(bCryptPasswordEncoder);
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception{
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/users/login");
        return filter;
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

}
