package com.lits.osbb.dto;


import com.lits.osbb.model.Address;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
public class OsbbDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Set<Address> address;
}