package com.lits.osbb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InformationPostDto {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String title;

    @NotNull
    @Size(max = 64)
    private String body;

    private Date beginDate;

    private Date endDate;

    private UserDto author;
}
