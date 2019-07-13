package com.lits.osbb.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OsbbDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private String password;

    private Set<RoleDto> roles;
}
