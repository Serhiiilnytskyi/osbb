package com.lits.osbb.dto;

import com.lits.osbb.model.Address;
import com.lits.osbb.model.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class UserDto {

    private Long id;

    private String firstName;

    private String secondName;

    private String email;

    private String password;

    private Set<Address> address;

    private Set<Role> roles;

}
