package com.lits.osbb.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Osbb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="osbb_addresses",
            joinColumns = {@JoinColumn(name="osbb_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="address_id", referencedColumnName="id")})
    private Set<Address> address;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="osbb_roles",
            joinColumns = {@JoinColumn(name="osbb_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")})
    private Set<Role> roles;
}
