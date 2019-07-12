package com.lits.osbb.service;

import com.lits.osbb.dto.InformationPostDto;

import java.util.List;

public interface AfficheService {
    InformationPostDto findOne(Long id);

    List<InformationPostDto> findAll();

    InformationPostDto save(InformationPostDto informationPostDto);

    InformationPostDto update(InformationPostDto informationPostDto);

    void delete(InformationPostDto informationPostDto);

    void delete(Long id);
}
