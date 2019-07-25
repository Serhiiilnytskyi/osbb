package com.lits.osbb.service;

import com.lits.osbb.dto.PropositionDto;

import java.util.List;

public interface PropositionService {

    PropositionDto findOne(Long id);

    PropositionDto findOneByTitle(String title);

    List<PropositionDto> findAll();

    PropositionDto save(PropositionDto propositionDto);

    void delete(Long id);

    Object update(Long id, PropositionDto propositionDto);
}
