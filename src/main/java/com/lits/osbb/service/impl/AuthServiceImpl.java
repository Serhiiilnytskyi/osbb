package com.lits.osbb.service.impl;

import com.lits.osbb.dto.UserDto;
import com.lits.osbb.exception.UserNotFoundException;
import com.lits.osbb.model.User;
import com.lits.osbb.repository.UserRepository;
import com.lits.osbb.service.AuthService;
import com.lits.osbb.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "authService")
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

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
        User user = userRepository.findByEmail(login)
                .map(e -> modelMapper.map(e, User.class ))
                .orElseThrow(() -> new UserNotFoundException("User not found with login: " + login));

         return tokenService.createToken(user.getId());
    }

    public String registration(UserDto userDto) {
        return null;
        //todo complete method
    }

}
