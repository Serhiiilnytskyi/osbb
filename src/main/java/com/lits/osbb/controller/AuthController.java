package com.lits.osbb.controller;

import com.lits.osbb.dto.AuthRequest;
import com.lits.osbb.dto.UserDto;
import com.lits.osbb.service.impl.AuthServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    private AuthServiceImpl authService;

    public AuthController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "login")
    @PostMapping(value = "/login")
    public ResponseEntity<?> auth(@Valid @RequestBody AuthRequest auth) {
        return ResponseEntity.ok(authService.auth(auth.getEmail(), auth.getPassword()));
    }

    @ApiOperation(value = "registration")
    @PostMapping(value = "/registration")
    public ResponseEntity<?> registration(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(authService.registration(userDto));
    }

}
