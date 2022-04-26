package edu.imi.ir.eduimiws.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import edu.imi.ir.eduimiws.models.user.MyErpUser;
import edu.imi.ir.eduimiws.utilities.AppProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //    this class is import with extending  UsernamePasswordAuthenticationFilter
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    private AppProperties appProperties;
    //omiddo:    remove later myUserDetailsService
    MyUserDetailsService myUserDetailsService = new MyUserDetailsService();//RM


    private String contentType;

    //    this method is used for authenticating user when request come to server
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {

            contentType = req.getHeader("Accept");

//            our class model for reading username and password
            UserLoginRequestModel creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserLoginRequestModel.class);

/*
            //omiddo:later remove this
            if (creds.getUsername().equalsIgnoreCase("admin") && // RM
                    creds.getPassword().equalsIgnoreCase("admin")) {     // RM
                UserDetails userDetails = myUserDetailsService.loadUserByUsername("9057"); // RM

                Authentication authentication = new UsernamePasswordAuthenticationToken(    // RM
                        userDetails,                                        // RM
                        userDetails,                                        //RM
                        getAuthorities("ROLE_ADMIN"));                      // RM
                return authentication;                                      // RM
            }                                                               // RM
*/


//            use the method we implement in our service to identify user
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            creds.getRole() != null ? getAuthorities(creds.getRole()) : getAuthorities("ROLE_ANONYMOUS"))
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //  if username and password is correct  this method is called, set token in header
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String userName = ((User) auth.getPrincipal()).getUsername();
        String userPublicId = ((MyErpUser) auth.getPrincipal()).getUserPublicId();

        String token = Jwts
                .builder()
                .setSubject(userName)
                .claim("userPublicId", userPublicId)
                .setExpiration(Date.from(Instant.now().plusMillis(Long.valueOf(appProperties.getExpirationTime()))))
                .signWith(SignatureAlgorithm.HS512, appProperties.getTokenSecret())
                .compact();

//        new Date(System.currentTimeMillis() + Long.valueOf(appProperties.getExpirationTime()).intValue())
//    get bean from context, bean name is name of class start with lowercase
//        UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");

//    use for adding public user id to response header
//        PersonApiFastDto userWSFastDto = userService.getUserFastDto(userName);

//    add token to response header
        res.addHeader(appProperties.getHeaderString(), appProperties.getTokenPrefix() + token);

//    add public user id to response header
//        res.addHeader("userPublicId", userWSFastDto.getPersonPublicId());
        res.addHeader("userPublicId", userPublicId);
    }


    private Collection<? extends GrantedAuthority> getAuthorities(String role) { // RM
        return Arrays.asList(new SimpleGrantedAuthority(role));                 // RM
    }                                                                           // RM

}