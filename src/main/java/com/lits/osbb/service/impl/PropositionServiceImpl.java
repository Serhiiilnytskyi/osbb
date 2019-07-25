package com.lits.osbb.service.impl;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.exception.NotFoundException;
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

    private PropositionRepository propositionRepository;

    private ModelMapper modelMapper;

    @Autowired
    public PropositionServiceImpl(PropositionRepository propositionRepository, ModelMapper modelMapper) {
        this.propositionRepository = propositionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PropositionDto findOne(Long id) {
        return Optional.ofNullable(propositionRepository.findOneById(id))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElseThrow(()-> new NotFoundException("PropositionDto with ID: "+id+" not found"));
    }

    @Override
    public PropositionDto findOneByTitle(String title) {
        return Optional.ofNullable(propositionRepository.findOneByTitle(title))
                .map(e->modelMapper.map(e,PropositionDto.class))
                .orElseThrow(()->new NotFoundException("PropositionDto with title "+title+" not found"));
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
                .orElseThrow(()->new NotFoundException("PropositionDto could not be saved"));
    }

    @Override
    public PropositionDto update(Long id, PropositionDto propositionDto) {
        Proposition proposition = Optional.of(propositionDto)
                .map(e -> modelMapper.map(e, Proposition.class))
                .orElseThrow(() -> new NotFoundException("PropositionDto Object is null. Nothing to update"));
        proposition.setId(id);

        return Optional.of(propositionRepository.save(proposition))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElseThrow(() -> new NotFoundException("Proposition not saved"));
    }

    @Override
    public void delete(Long id) {
        propositionRepository.deleteById(id);
    }
}
