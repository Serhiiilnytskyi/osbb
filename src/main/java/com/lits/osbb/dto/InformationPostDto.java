package com.lits.osbb.dto;

import com.lits.osbb.model.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InformationPostDto implements Post {

    private Long id;

    private String title;

    private String body;

    private Date beginDate;

    private Date endDate;

    private UserDto author;
}
