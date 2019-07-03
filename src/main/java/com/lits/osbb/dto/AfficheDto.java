package com.lits.osbb.dto;

import lombok.Data;
import org.apache.tomcat.jni.User;

import java.util.Date;

@Data
public class AfficheDto {

    private Long id;
    private String title;
    private String body;
    private Date beginDate;
    private Date endDate;
    private User author;
}
