package com.lits.osbb.service.impl;

import com.lits.osbb.model.User;
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
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String auth(String login, String pass) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login,
                        pass
                )
        );

        log.info("Attempting create token for user " + login);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(login);

        if (user == null || user.equals(new User())){
            log.warn("Got null or empty Person Object from repository after saving it");
        }

        return tokenService.createToken(user.getId());
    }
}
