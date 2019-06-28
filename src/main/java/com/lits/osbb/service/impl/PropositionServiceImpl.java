package com.lits.osbb.service.impl;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.model.Proposition;
import com.lits.osbb.repository.PropositionRepositoty;
import com.lits.osbb.service.PropositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropositionServiceImpl implements PropositionService {

    @Autowired
    PropositionRepositoty propositionRepositoty;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PropositionDto findOne(Long id) {
        return Optional.ofNullable(propositionRepositoty.findOneById(id))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElse(new PropositionDto());
    }

    @Override
    public List<PropositionDto> findAll() {
        return propositionRepositoty.findAll().stream()
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropositionDto save(PropositionDto propositionDto) {
        return Optional.ofNullable(propositionDto)
                .map(e -> modelMapper.map(e, Proposition.class))
                .map(e -> propositionRepositoty.save(e))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElse(new PropositionDto());
    }

    @Override
    public PropositionDto update(PropositionDto propositionDto) {
        return Optional.ofNullable(propositionDto)
                .map(e -> modelMapper.map(e, Proposition.class))
                .map(e -> propositionRepositoty.save(e))
                .map(e -> modelMapper.map(e, PropositionDto.class))
                .orElse(new PropositionDto());
    }

    @Override
    public void delete(PropositionDto propositionDto) {
        propositionRepositoty.delete(modelMapper.map(propositionDto, Proposition.class));
    }
    
    @Override
    public void delete(Long id) {
        propositionRepositoty.delete(id);
    }
}
