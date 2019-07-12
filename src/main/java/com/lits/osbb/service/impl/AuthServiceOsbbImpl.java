package com.lits.osbb.service.impl;

import com.lits.osbb.model.Osbb;
import com.lits.osbb.model.User;
import com.lits.osbb.repository.OsbbRepository;
import com.lits.osbb.repository.UserRepository;
import com.lits.osbb.service.AuthService;
import com.lits.osbb.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "authServiceOsbb")
public class AuthServiceOsbbImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private OsbbRepository osbbRepository;

    @Override
    public String auth(String login, String pass) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        pass
                )
        );

        log.info("Attempting create token for osbb " + login);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Osbb osbb = osbbRepository.findByEmail(login);

        if (osbb == null || osbb.equals(new Osbb())){
            log.warn("Got null or empty Osbb Object from repository after saving it");
        }

        return tokenService.createToken(osbb.getId());
    }
}
