package com.lits.osbb.controller;

import com.lits.osbb.dto.AuthRequest;
import com.lits.osbb.dto.UserDto;
import com.lits.osbb.service.AuthService;
import com.lits.osbb.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    private AuthServiceImpl authService;

    @Autowired
    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> auth(@RequestBody AuthRequest auth){
        return ResponseEntity.ok(authService.auth(auth.getEmail(), auth.getPassword()));
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> registration(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authService.registration(userDto));
    }

}
