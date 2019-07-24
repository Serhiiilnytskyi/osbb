package com.lits.osbb.service.impl;

import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.exception.NotFoundException;
import com.lits.osbb.model.VotingPost;
import com.lits.osbb.repository.VotingPostRepository;
import com.lits.osbb.service.VotingPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotingPostServiceImpl implements VotingPostService {

    private VotingPostRepository votingPostRepository;

    private ModelMapper modelMapper;

    @Autowired
    public VotingPostServiceImpl(VotingPostRepository votingPostRepository, ModelMapper modelMapper) {
        this.votingPostRepository = votingPostRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VotingPostDto save(VotingPostDto votingPostDto) {
       return Optional.of(votingPostDto)
                .map(e -> modelMapper.map(e, VotingPost.class))
                .map(e -> votingPostRepository.save(e))
                .map(e -> modelMapper.map(e, VotingPostDto.class))
                .orElseThrow(() -> new NotFoundException("????????????????? Nothing to save"));
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
        VotingPost votingPost = votingPostRepository.findById(id).orElseThrow(()->new NotFoundException("Vote with ID: " + id +" not found"));
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
