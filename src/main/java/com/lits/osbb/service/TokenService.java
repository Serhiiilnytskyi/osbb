package com.lits.osbb.service;

public interface TokenService {

    Long parseToken(String token);

    String createToken(Long id);
}