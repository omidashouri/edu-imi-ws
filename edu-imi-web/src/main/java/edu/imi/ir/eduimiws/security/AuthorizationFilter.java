package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.configurations.SpringApplicationContext;
import edu.imi.ir.eduimiws.domain.crm.PersonApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.ExpiredJwtTokenException;
import edu.imi.ir.eduimiws.models.user.MyPrincipleUser;
import edu.imi.ir.eduimiws.services.UserService;
import edu.imi.ir.eduimiws.services.crm.PersonApiService;
import edu.imi.ir.eduimiws.utilities.AppProperties;
import edu.imi.ir.eduimiws.utilities.JwtKeyUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorizationFilter extends BasicAuthenticationFilter {

    private static final String BEARER_PREFIX = "Bearer ";

    private final AppProperties appProperties;
    private final PersonApiService personApiService;

    public AuthorizationFilter(@Lazy AuthenticationManager authenticationManager1, AppProperties appProperties, PersonApiService personApiService) {
        super(authenticationManager1);
        this.appProperties = appProperties;
        this.personApiService = personApiService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        if (contextPath != null && !contextPath.isEmpty() && path.startsWith(contextPath)) {
            path = path.substring(contextPath.length());
        }
        if (path == null || !path.startsWith("/api/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader(appProperties.getHeaderString());

        if (header == null || resolveTokenPrefix(header) == null) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(appProperties.getHeaderString());

        if (token != null) {
            String prefix = resolveTokenPrefix(token);
            if (prefix == null) {
                return null;
            }
            token = token.substring(prefix.length()).trim();

            Claims claims;

            try {
                claims = JwtKeyUtil.parser(appProperties.getTokenSecret())
                        .parseSignedClaims(token)
                        .getPayload();
            } catch (ExpiredJwtException expiredJwtException) {
                throw new ExpiredJwtTokenException(expiredJwtException.getHeader(),
                        expiredJwtException.getClaims(), expiredJwtException.getMessage());
            }

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

    /**
     * Accepts the legacy v1 prefix ({@code IMI }) and the v2 {@code Bearer } scheme.
     */
    private String resolveTokenPrefix(String authorizationHeader) {
        String legacyPrefix = appProperties.getTokenPrefix();
        if (legacyPrefix != null && authorizationHeader.startsWith(legacyPrefix)) {
            return legacyPrefix;
        }
        if (authorizationHeader.startsWith(BEARER_PREFIX)) {
            return BEARER_PREFIX;
        }
        return null;
    }

}
