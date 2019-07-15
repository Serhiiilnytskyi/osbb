package com.lits.osbb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity
public class VotingPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Date beginDate;

    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "votingPost", cascade = CascadeType.ALL)
    private List<Vote> votes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author")
    private User author;

}
