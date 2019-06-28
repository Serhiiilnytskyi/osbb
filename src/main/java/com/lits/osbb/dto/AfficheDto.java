package com.lits.osbb.dto;

import lombok.Data;
import org.apache.tomcat.jni.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class AfficheDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private Date beginDate;

    @Column
    private Date endDate;

    @Column
    private User author;
}
