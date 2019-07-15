package com.lits.osbb.service.impl;
import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.exception.IdNotFoundException;
import com.lits.osbb.exception.PostNotFoundException;
import com.lits.osbb.model.VotingPost;
import com.lits.osbb.repository.VotingPostRepository;
import com.lits.osbb.service.VotingPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotingPostServiceImpl implements VotingPostService {

    @Autowired
    private VotingPostRepository votingPostRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public VotingPostDto save(VotingPostDto votingPostDto){
        return Optional.ofNullable(votingPostDto)
                .map(e -> modelMapper.map(e, VotingPostDto.class))
                .map(e -> votingPostRepository.save(e))
                .map(e -> modelMapper.map(e, VotingPostDto.class))
                .orElse(new VotingPostDto());
    }
    @Override
    public VotingPostDto update(VotingPostDto votingPostDto){
        return Optional.ofNullable(votingPostDto)
            .map(e -> modelMapper.map(e, VotingPostDto.class))
            .map(e -> votingPostRepository.save(e))
            .map(e -> modelMapper.map(e, VotingPostDto.class))
            .orElseThrow(() -> new PostNotFoundException("No such a post found"));};
    @Override
    public void delete(VotingPostDto votingPostDto){
     //   votingPostRepository.delete(modelMapper.map(votingPostDto, VotingPostDto.class));

    }

    @Override
    public VotingPostDto getById(Long id){
        VotingPost votingPost = votingPostRepository.findById(id)
                .orElseThrow(()->new IdNotFoundException("Vote with ID: " + id +" not found"));

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
