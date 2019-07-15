package com.lits.osbb.dto;

import com.lits.osbb.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
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
