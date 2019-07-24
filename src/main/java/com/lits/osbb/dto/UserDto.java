package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private String password;

    private UserDto osbbId;

    private Set<RoleDto> roles;
}
