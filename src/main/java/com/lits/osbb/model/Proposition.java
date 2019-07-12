package com.lits.osbb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Proposition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proposition", cascade = CascadeType.ALL)
    private Set<Vote> votes;

}
