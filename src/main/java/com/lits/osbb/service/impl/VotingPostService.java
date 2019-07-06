package com.lits.osbb.service.impl;

import com.lits.osbb.dto.VotingPostDto;

public interface VotingPostService {

    VotingPostDto save(VotingPostDto votingPostDto);

    VotingPostDto update(VotingPostDto votingPostDto);

    VotingPostDto delete(VotingPostDto votingPostDto);

    VotingPostDto findById(Long id);

    VotingPostDto findByTitleContains(String title);

    VotingPostDto findByAuthor(String title);


}
