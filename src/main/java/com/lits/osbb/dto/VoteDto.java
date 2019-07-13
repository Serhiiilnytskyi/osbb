package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class VoteDto {

    private Long id;

    private Boolean isVote;

    private UserDto user;

    private PropositionDto proposition;

    private VotingPostDto votingPost;

}
