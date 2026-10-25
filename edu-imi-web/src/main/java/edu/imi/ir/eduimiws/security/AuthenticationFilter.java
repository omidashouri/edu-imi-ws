package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import edu.imi.ir.eduimiws.models.user.MyErpUser;
import edu.imi.ir.eduimiws.utilities.AppProperties;
import edu.imi.ir.eduimiws.utilities.JwtKeyUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
@Component
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager1;
    private final JsonMapper jsonMapper;

    public AuthenticationFilter(AuthenticationManager authenticationManager1, JsonMapper jsonMapper) {
        super(authenticationManager1);
        this.authenticationManager1 = authenticationManager1;
        this.jsonMapper = jsonMapper;
    }

    @Autowired
    private AppProperties appProperties;

    @PostConstruct
    public void init() {
        this.setFilterProcessesUrl("/api/users/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            UserLoginRequestModel creds = jsonMapper
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
            return authenticationManager1.authenticate(
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

        String token = JwtKeyUtil.sign(Jwts.builder()
                        .subject(userName)
                        .claim("userPublicId", userPublicId)
                        .expiration(Date.from(Instant.now().plusMillis(Long.parseLong(appProperties.getExpirationTime())))),
                appProperties.getTokenSecret())
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