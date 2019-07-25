package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VoteDto {

    private Long id;

    private Boolean isVote;

    @NotNull
    private UserDto user;

    private PropositionDto proposition;

    private VotingPostDto votingPost;

}
