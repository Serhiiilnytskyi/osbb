package com.lits.osbb.service;

import com.lits.osbb.dto.PropositionDto;

import java.util.List;

public interface PropositionService {

    PropositionDto findOne(Long id);

    List<PropositionDto> findAll();

    PropositionDto save(PropositionDto propositionDto);

    PropositionDto update(PropositionDto propositionDto);

    void delete(PropositionDto propositionDto);

    void delete(Long id);
}
