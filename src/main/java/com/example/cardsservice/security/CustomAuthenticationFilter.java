package com.example.cardsservice.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

//        try {
//            setUserPrincipalIfAllOk(httpServletRequest);
//        } catch (Exception e) {
//            System.out.println("Error");
//        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

/*    private void setUserPrincipalIfAllOk(HttpServletRequest request) {
        String authorization = request.getHeader(RestConstants.AUTHENTICATION_HEADER);

        if (authorization != null) {
            User user = getUserFromBearerToken(authorization);
            if (user != null) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
    }*/
/*

    public User getUserFromBearerToken(String token) {
        try {
            token = token.substring(RestConstants.BEARER_TOKEN_TYPE.length()).trim();
            if (jwtTokenProvider.validToken(token, true)) {
                String userId = jwtTokenProvider.getUserIdFromToken(token, true);
                User user = userService.getById(UUID.fromString(userId));

                if (!user.getTokenIssuedAt().equals(jwtTokenProvider.getIssuedAt(token)))
                    return null;

                return user;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }*/

}
