package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.configurations.SpringApplicationContext;
import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.services.crm.PersonApiService;
import edu.imi.ir.eduimiws.utilities.AppProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    private final UserService userService = null;

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Autowired
    private AppProperties appProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        String header = request.getHeader(appProperties.getHeaderString());

        if (header == null || !header.startsWith(appProperties.getTokenPrefix())) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(appProperties.getHeaderString());

        if (token != null) {
            token = token.replace(appProperties.getTokenPrefix(), "");

            Claims claims = Jwts.parser()
                    .setSigningKey(appProperties.getTokenSecret())
                    .parseClaimsJws(token)
                    .getBody();
            String user = claims.getSubject();
            String userPublicId = String.valueOf(claims.get("userPublicId"));

/*            int i = token.lastIndexOf('.');
            String withoutSignature = token.substring(0, i + 1);
            Jwt<Header, Claims> jwsClaims = Jwts.parser().parseClaimsJwt(withoutSignature);
            Claims claims = jwsClaims.getBody();
            String subject = claims.getSubject();*/

            PersonApiService personApiService = (PersonApiService) SpringApplicationContext.getBean("personApiServiceImpl");
            PersonApiEntity personApi = personApiService.findByPersonPublicIdWithPersonAndRole(userPublicId);

            if (user != null) {
//                omiddo: later remove granted authority (user when chek method authority)
                List<? extends GrantedAuthority> authorities;
                if (personApi.getRoles() != null && personApi.getRoles().size()>0) {
                    authorities = personApi
                            .getRoles()
                            .stream()
                            .map(p -> new SimpleGrantedAuthority(p.getName()))
                            .distinct()
                            .collect(Collectors.toList());
                } else {
                    authorities = this.getAuthorities("ROLE_ANONYMOUS")
                            .stream()
                            .collect(Collectors.toList());
                }

                return new UsernamePasswordAuthenticationToken(new MyPrincipleUser(personApi), personApi.getPerson().getPassword(), authorities);
            }
            return null;
        }
        return null;
    }


    private Collection<? extends GrantedAuthority> getAuthorities(String role) { // RM
        return Arrays.asList(new SimpleGrantedAuthority(role));                 // RM
    }


}
