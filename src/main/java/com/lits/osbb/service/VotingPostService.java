package com.lits.osbb.service;

import com.lits.osbb.dto.VotingPostDto;

public interface VotingPostService {

    VotingPostDto save(VotingPostDto votingPostDto);

    VotingPostDto update(VotingPostDto votingPostDto);

    VotingPostDto delete(VotingPostDto votingPostDto);

    VotingPostDto getById(Long id);

    VotingPostDto getByTitleContains(String title);

    VotingPostDto getByAuthor(String title);


}
