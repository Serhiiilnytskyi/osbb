package com.lits.osbb.dto;

import com.lits.osbb.model.Vote;
import lombok.Data;

import java.util.Set;

@Data
public class PropositionDto {

    private Long id;

    private String title;

    private String body;

    private Set<Vote> votes;

}
