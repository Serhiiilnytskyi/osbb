package com.lits.osbb.dto;


import com.lits.osbb.model.Address;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class OsbbDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Set<Address> address;
}
