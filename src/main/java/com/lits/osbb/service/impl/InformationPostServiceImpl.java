package com.lits.osbb.service.impl;

import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.model.InformationPost;
import com.lits.osbb.repository.InformationPostRepository;
import com.lits.osbb.service.InformationPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InformationPostServiceImpl implements InformationPostService {

    @Autowired
    private InformationPostRepository informationPostRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public InformationPostDto findOne(Long id){
        return Optional.ofNullable(informationPostRepository.findOneById(id))
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .orElse(new InformationPostDto());
    }
    @Override
    public List<InformationPostDto> findAll(){
        return StreamSupport.stream(informationPostRepository.findAll().spliterator(), false)
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public InformationPostDto save(InformationPostDto informationPostDto){
        return Optional.ofNullable(informationPostDto)
                .map(e -> modelMapper.map(e, InformationPost.class))
                .map(e -> informationPostRepository.save(e))
                .map(e -> modelMapper.map(e, InformationPostDto.class))
                .orElse(new InformationPostDto());
    }
    @Override
    public InformationPostDto update(InformationPostDto informationPostDto){
        return Optional.ofNullable(informationPostDto)
            .map(e -> modelMapper.map(e, InformationPost.class))
            .map(e -> informationPostRepository.save(e))
            .map(e -> modelMapper.map(e, InformationPostDto.class))
            .orElse(new InformationPostDto());};
    @Override
    public void delete(InformationPostDto informationPostDto){
        informationPostRepository.delete(modelMapper.map(informationPostDto, InformationPost.class));
    }
    @Override
    public void delete(Long id){
        informationPostRepository.delete(id);
    }
}
