package com.lits.osbb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "proposition_id", nullable = false)
    Proposition proposition;

}
