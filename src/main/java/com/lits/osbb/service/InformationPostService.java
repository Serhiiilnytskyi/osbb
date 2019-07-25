package com.lits.osbb.service;

import com.lits.osbb.dto.InformationPostDto;

import java.util.List;

public interface InformationPostService {

    InformationPostDto findOne(Long id);

    List<InformationPostDto> findAll();

    InformationPostDto save(InformationPostDto informationPostDto);

    void delete(Long id);

    InformationPostDto findOneByTitle(String title);

    InformationPostDto findOneByAuthor(String author);

    InformationPostDto update(Long id, InformationPostDto informationPostDto);
}
