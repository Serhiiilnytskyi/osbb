package com.lits.osbb.service.impl;

import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.exception.IdNotFoundException;
import com.lits.osbb.model.VotingPost;
import com.lits.osbb.repository.VotingPostRepository;
import com.lits.osbb.service.VotingPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingPostServiceImpl implements VotingPostService {

    @Autowired
    private VotingPostRepository votingPostRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VotingPostDto save(VotingPostDto votingPostDto) {
        return null;
    }

    @Override
    public VotingPostDto update(VotingPostDto votingPostDto) {
        return null;
    }

    @Override
    public VotingPostDto delete(VotingPostDto votingPostDto) {
        return null;
    }

    @Override
    public VotingPostDto getById(Long id){
        VotingPost votingPost = votingPostRepository.findById(id).orElseThrow(()->new IdNotFoundException("Vote with ID: " + id +" not found"));
        return modelMapper.map(votingPost, VotingPostDto.class);
    }

    @Override
    public VotingPostDto getByTitleContains(String title) {
        return null;
    }

    @Override
    public VotingPostDto getByAuthor(String title) {
        return null;
    }


}
