package com.lits.osbb.service.impl;

import com.lits.osbb.dto.OsbbDto;
import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.exception.NotFoundException;
import com.lits.osbb.model.Osbb;
import com.lits.osbb.model.VotingPost;
import com.lits.osbb.model.VotingPost;
import com.lits.osbb.repository.VotingPostRepository;
import com.lits.osbb.service.VotingPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public VotingPostDto findOne(Long id) {
        return Optional.ofNullable(votingPostRepository.findById(id))
                .map(e -> modelMapper.map(e,VotingPostDto.class))
                .orElseThrow(()->new NotFoundException("VotingPost with ID: "+id+" not found"));
    }

    @Override
    public VotingPostDto findOneByTitle(String title) {
        return Optional.ofNullable(votingPostRepository.findOneByTitle(title))
                .map(e->modelMapper.map(e,VotingPostDto.class))
                .orElseThrow(()->new NotFoundException("VotingPost with title: "+title+" not found"));
    }

    @Override
    public VotingPostDto findOneByAuthor(String author) {
        return Optional.ofNullable(votingPostRepository.findOneByAuthor(author))
                .map(e->modelMapper.map(e,VotingPostDto.class))
                .orElseThrow(()->new NotFoundException("VotingPost with author: "+author+" not found"));
    }


    @Override
    public VotingPostDto getById(Long id){
        VotingPost votingPost = votingPostRepository.findById(id).orElseThrow(()->new NotFoundException("Vote with ID: " + id +" not found"));
        return modelMapper.map(votingPost, VotingPostDto.class);

    }

    @Override
    public VotingPostDto save(VotingPostDto votingPostDto) {
        return Optional.of(votingPostDto)
                .map(e -> modelMapper.map(e, VotingPost.class))
                .map(e -> votingPostRepository.save(e))
                .map(e -> modelMapper.map(e, VotingPostDto.class))
                .orElseThrow(() -> new NotFoundException("VotingPost could not be saved"));
    }

    @Override
    public VotingPostDto update(Long id, VotingPostDto votingPostDto) {
        VotingPost votingPost = Optional.of(votingPostDto)
                .map(e -> modelMapper.map(e, VotingPost.class))
                .orElseThrow(() -> new NotFoundException("VotingPostDto Object is null. Nothing to update"));
        votingPost.setId(id);

        return Optional.of(votingPostRepository.save(votingPost))
                .map(e -> modelMapper.map(e, VotingPostDto.class))
                .orElseThrow(() -> new NotFoundException("VotingPost not saved"));
    }

    @Override
    public void delete(Long id) {
        votingPostRepository.deleteById(id);
    }


    @Override
    public List<VotingPostDto> findAll(){
        return votingPostRepository.findAll().stream()
                .map(e->modelMapper.map(e,VotingPostDto.class))
                .collect(Collectors.toList());
    }

}

