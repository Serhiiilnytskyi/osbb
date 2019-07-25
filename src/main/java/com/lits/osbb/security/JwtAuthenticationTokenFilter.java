package com.lits.osbb.security;

import com.lits.osbb.model.User;
import com.lits.osbb.service.TokenService;
import com.lits.osbb.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    private static final String BEARER_TYPE = "Bearer";

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        Long accountId =  Optional
                .ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(this::containsBearerToken)
                .map(token -> token.substring(BEARER_TYPE.length() + 1))
                .map(token -> tokenService.parseToken(token)).orElse(null);

        log.info("checking authentication for user " + accountId);

        if (accountId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            JwtUser jwtUser = JwtUserFactory.create(accountId, userService.getAuthority(modelMapper.map(userService.findOne(accountId), User.class)));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            logger.info("authenticated user " + accountId + ", setting security context");
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
    private boolean containsBearerToken(String authHeader) {
        return Optional.ofNullable(authHeader).filter(e -> e.startsWith(BEARER_TYPE))
                .filter(e -> e.length() > BEARER_TYPE.length() + 1).isPresent();
    }

}
