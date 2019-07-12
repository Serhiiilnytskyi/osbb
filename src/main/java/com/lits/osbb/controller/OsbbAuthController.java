package com.lits.osbb.controller;

import com.lits.osbb.dto.AuthRequest;
import com.lits.osbb.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/osbb")
public class OsbbAuthController {

    @Autowired
    @Qualifier(value = "authServiceOsbb")
    private AuthService authServiceOsbb;

    @Autowired
    public OsbbAuthController(@Qualifier(value = "authServiceOsbb")AuthService authServiceOsbb) {
        this.authServiceOsbb = authServiceOsbb;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> auth(@RequestBody AuthRequest auth){
        return ResponseEntity.ok(authServiceOsbb.auth(auth.getEmail(), auth.getPassword()));
    }

}