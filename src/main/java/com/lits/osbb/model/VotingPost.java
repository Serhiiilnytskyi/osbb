package com.lits.osbb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class VotingPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Date beginDate;
    private Date endDate;
    private List<Vote> voteList;
    @ManyToOne
    private User author;
}
