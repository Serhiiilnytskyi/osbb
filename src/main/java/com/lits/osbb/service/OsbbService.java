package com.lits.osbb.service;

import com.lits.osbb.dto.OsbbDto;

import java.util.List;

public interface OsbbService {

    OsbbDto findOne(Long id);

    List<OsbbDto> findAll();

    OsbbDto save(OsbbDto osbbDto);

    OsbbDto update(Long id, OsbbDto osbbDto);

    void delete(Long id);

}
