package com.lits.osbb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class PropositionDto {

    private Long id;

    @NotNull
    @Size(max = 64)
    private String title;

    @NotNull
    @Size(max = 256)
    private String body;

    private Set<VoteDto> votes;

    private UserDto author;
}
