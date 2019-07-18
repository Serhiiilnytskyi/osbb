package com.lits.osbb.controller;

import com.lits.osbb.service.VotingPostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/votingposts")
public class VotingPostController {

private VotingPostService votingPostService;

    public VotingPostController(VotingPostService votingPostService) {
        this.votingPostService = votingPostService;
    }
}
