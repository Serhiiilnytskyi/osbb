package com.lits.osbb.model;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Affiche implements Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Date beginDate;

    private Date endDate;

    @ManyToOne
    private User author;
}
