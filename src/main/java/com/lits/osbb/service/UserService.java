package com.lits.osbb.service;

import com.lits.osbb.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findOne(Long id);

    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    void delete(Long id);
}
