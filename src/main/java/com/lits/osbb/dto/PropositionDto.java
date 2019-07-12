package com.lits.osbb.dto;

import com.lits.osbb.model.Vote;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PropositionDto {

    private Long id;

    private String title;

    private String body;

    private Set<Vote> votes;

}
