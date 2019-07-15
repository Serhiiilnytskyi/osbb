package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class PropositionDto implements Serializable {

    private Long id;

    private String title;

    private String body;

    private Set<VoteDto> votes;

    private UserDto author;
}
