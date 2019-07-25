package com.lits.osbb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InformationPostDto {

    private Long id;

    private String title;

    private String body;

    private Date beginDate;

    private Date endDate;

    private UserDto author;
}
