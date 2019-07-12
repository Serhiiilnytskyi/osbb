package com.lits.osbb.dto;

import com.lits.osbb.model.Address;
import com.lits.osbb.model.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private String password;

    private Set<Address> address;

    private Set<Role> roles;

}
