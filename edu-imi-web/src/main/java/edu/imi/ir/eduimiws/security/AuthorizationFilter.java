package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.utilities.AppProperties;
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
            token = token.replace(appProperties.getTokenPrefix(),"");

            String user = Jwts.parser()
                    .setSigningKey(appProperties.getTokenSecret())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

/*            int i = token.lastIndexOf('.');
            String withoutSignature = token.substring(0, i + 1);
            Jwt<Header, Claims> jwsClaims = Jwts.parser().parseClaimsJwt(withoutSignature);
            Claims claims = jwsClaims.getBody();
            String subject = claims.getSubject();*/


            if(user !=null){
//                omiddo: later remove granted authority (user when chek method authority)
                List<? extends GrantedAuthority> grantedAuths = this.getAuthorities("ROLE_ADMIN")
                        .stream().collect(Collectors.toList());

                return new UsernamePasswordAuthenticationToken(user,null,grantedAuths);
            }
            return null;
        }
        return null;
    }


    private Collection<? extends GrantedAuthority> getAuthorities(String role){ // RM
        return Arrays.asList(new SimpleGrantedAuthority(role));                 // RM
    }


}
