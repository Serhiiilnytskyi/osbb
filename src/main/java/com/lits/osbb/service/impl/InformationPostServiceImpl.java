package com.lits.osbb.service.impl;

import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.exception.NotFoundException;
import com.lits.osbb.model.InformationPost;
import com.lits.osbb.repository.InformationPostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InformationPostServiceImpl implements com.lits.osbb.service.InformationPostService {

    @Autowired
    private InformationPostRepository informationPostRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public InformationPostDto findOne(Long id) {
        return informationPostRepository.findById(id)
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .orElseThrow(() -> new NotFoundException("Did not find " + id + " post "));
    }

    @Override
    public List<InformationPostDto> findAll() {
        return StreamSupport.stream(informationPostRepository.findAll().spliterator(), false)
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InformationPostDto save(InformationPostDto informationPostDto) {
        return Optional.ofNullable(informationPostDto)
                .map(e -> modelMapper.map(e, InformationPost.class))
                .map(e -> informationPostRepository.save(e))
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .orElseThrow(() -> new NotFoundException("Did not save " + informationPostDto + " post "));
    }

    @Override
    public InformationPostDto update(Long id, InformationPostDto informationPostDto) {
        InformationPost informationPost = Optional.of(informationPostDto)
                .map(e -> modelMapper.map(e, InformationPost.class))
                .orElseThrow(() -> new NotFoundException("InformationPostDto  Object is null. Nothing to update"));

        return Optional.of(informationPost)
                .map(e -> informationPostRepository.save(e))
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .orElseThrow(() -> new NotFoundException("Did not update " + informationPostDto + " post "));
    }

    @Override
    public void delete(Long id) {
        informationPostRepository.delete(modelMapper.map(informationPostRepository, InformationPost.class));
    }

    @Override
    public InformationPostDto findOneByTitle(String title) {
        return null;
    }

    @Override
    public InformationPostDto findOneByAuthor(String author) {
        return null;
    }


}
