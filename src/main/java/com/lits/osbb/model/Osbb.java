package com.lits.osbb.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "osbb")
public class Osbb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
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
