package com.lits.osbb.service;

import com.lits.osbb.dto.VotingPostDto;

import java.util.List;

public interface VotingPostService {

    VotingPostDto findOne(Long id);

    VotingPostDto findOneByTitle(String title);

    VotingPostDto findOneByAuthor(String author);

    List<VotingPostDto> findAll ();

    VotingPostDto save(VotingPostDto votingPostDto);

    VotingPostDto update(VotingPostDto votingPostDto);

    void delete(VotingPostDto votingPostDto);
}