package edu.imi.ir.eduimiws.security;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(2)
@EnableWebSecurity
public class RootUrlSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("**/swagger-ui/**","/swagger-ui/**","/v3/api-docs/**","/v3/api-docs","/v2/api-docs/**","/configuration/**","/swagger*/**","/webjars/**").permitAll()
                .antMatchers(HttpMethod.POST,"**/afterPaymentResponse").permitAll()
                .anyRequest().authenticated()
        ;
    }

}
