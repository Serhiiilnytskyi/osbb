package com.lits.osbb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table
public class Proposition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proposition", cascade = CascadeType.ALL)
    private Set<Vote> votes;

}
