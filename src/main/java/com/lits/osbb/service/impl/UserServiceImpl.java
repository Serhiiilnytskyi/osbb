package com.lits.osbb.service.impl;

import com.lits.osbb.dto.UserDto;
import com.lits.osbb.exception.UserNotFoundException;
import com.lits.osbb.model.User;
import com.lits.osbb.repository.UserRepository;
import com.lits.osbb.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    //TODO implement UserDto to service

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s)
                .orElseThrow(() -> new UserNotFoundException("User with name: " + s + " not found"));

        //todo add correct auth
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    public List<GrantedAuthority> getAuthority(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });

        return authorities;
    }

    @Override
    public UserDto findOne(Long id) {
        return userRepository.findById(id)
                .map(e -> modelMapper.map(e, UserDto.class))
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        return Optional.of(userDto)
                .map(e -> modelMapper.map(e, User.class))
                .map(e -> userRepository.save(e))
                .map(e -> modelMapper.map(e, UserDto.class))
                .orElseThrow(() -> new UserNotFoundException("UserDto Object is null. Nothing to save"));
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = Optional.of(userDto)
                .map(e -> modelMapper.map(e, User.class))
                .orElseThrow(() -> new UserNotFoundException("UserDto Object is null. Nothing to update"));
        user.setId(id);

        return Optional.of(userRepository.save(user))
                .map(e -> modelMapper.map(e, UserDto.class))
                .orElseThrow(() -> new UserNotFoundException("User not saved"));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
