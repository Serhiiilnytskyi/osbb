package com.lits.osbb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

    @Entity
    @Table(name = "user")
    @Data
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

<<<<<<< HEAD
        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "second_name", nullable = false)
=======
        @Column(name = "first_name")
        private String firstName;

        @Column(name = "second_name")
>>>>>>> 5509e1cccfa6a21302b31e8070e16eaaedcad674
        private String secondName;

        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "password")
        private String password;

        @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
        @JoinTable(name="user_addresses",
                joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
                inverseJoinColumns = {@JoinColumn(name="address_id", referencedColumnName="id")})
        private Set<Address> address;

        @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
        @JoinTable(name="user_roles",
                joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
                inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")})
        private Set<Role> roles;


    }
