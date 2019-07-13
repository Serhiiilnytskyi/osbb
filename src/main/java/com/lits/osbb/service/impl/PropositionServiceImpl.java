package com.lits.osbb.service.impl;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.exception.PropositionNotFoundException;
import com.lits.osbb.model.Proposition;
import com.lits.osbb.repository.PropositionRepository;
import com.lits.osbb.service.PropositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropositionServiceImpl implements PropositionService {

    @Autowired
    private PropositionRepository propositionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PropositionDto findOne(Long id) {
        return Optional.ofNullable(propositionRepository.findOneById(id))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElseThrow(()-> new PropositionNotFoundException("PropositionDto with id "+id+" not found"));
    }

    @Override
    public PropositionDto findOneByTitle(String title) {
        return Optional.ofNullable(propositionRepository.findOneByTitle(title))
                .map(e->modelMapper.map(e,PropositionDto.class))
                .orElseThrow(()->new PropositionNotFoundException("PropositionDto with title "+title+" not found"));
    }

    @Override
    public List<PropositionDto> findAll() {
        return propositionRepository.findAll().stream()
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropositionDto save(PropositionDto propositionDto) {
        return Optional.ofNullable(propositionDto)
                .map(e -> modelMapper.map(e, Proposition.class))
                .map(e -> propositionRepository.save(e))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElseThrow(()->new PropositionNotFoundException("PropositionDto could not be saved"));
    }

    @Override
    public PropositionDto update(PropositionDto propositionDto) {
        return Optional.ofNullable(propositionDto)
                .map(e -> modelMapper.map(e, Proposition.class))
                .map(e -> propositionRepository.save(e))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElseThrow(()->new PropositionNotFoundException("PropositionDto could not be update"));
    }

    @Override
    public void delete(PropositionDto propositionDto) {
        propositionRepository.delete(modelMapper.map(propositionDto, Proposition.class));
    }
    
    @Override
    public void delete(Long id) {
        propositionRepository.delete(id);
    }
}
