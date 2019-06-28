package com.lits.osbb.service;

import com.lits.osbb.dto.AfficheDto;
import com.lits.osbb.dto.PropositionDto;

import java.util.List;

public interface AfficheService {
    AfficheDto findOne(Long id);

    List<AfficheDto> findAll();

    AfficheDto save(AfficheDto afficheDto);

    AfficheDto update(AfficheDto afficheDto);

    void delete(AfficheDto afficheDto);

    void delete(Long id);
}
