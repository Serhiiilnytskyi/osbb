package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
