package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDto {

    private Long id;

    private Boolean isVote;

    private UserDto user;

    private PropositionDto proposition;

    private VotingPostDto votingPost;

}
