package com.lits.osbb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VotingPostDto {

    private Long id;

    private String title;

    private String body;

    private Date beginDate;

    private Date endDate;

    private List<VoteDto> votes;

    private UserDto author;

}
