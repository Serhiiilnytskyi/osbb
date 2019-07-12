package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.User;

import java.util.Date;

@Getter
@Setter
public class InformationPostDto {

    private Long id;

    private String title;

    private String body;

    private Date beginDate;

    private Date endDate;

    private User author;
}
