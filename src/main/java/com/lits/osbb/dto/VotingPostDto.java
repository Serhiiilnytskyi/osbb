package com.lits.osbb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VotingPostDto {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String title;

    @NotNull
    @Size(max = 256)
    private String body;

    private Date beginDate;

    private Date endDate;

    private List<VoteDto> votes;

    private UserDto author;

}
