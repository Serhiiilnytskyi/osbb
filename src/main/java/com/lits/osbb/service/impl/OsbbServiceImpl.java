package com.lits.osbb.service.impl;

import com.lits.osbb.dto.OsbbDto;
<<<<<<< HEAD
import com.lits.osbb.exception.OsbbNotFoundException;
=======
import com.lits.osbb.exception.NotFoundException;
>>>>>>> 1f0493ff60cb6ac98d04b50e4fdca82cd5eef719
import com.lits.osbb.model.Osbb;
import com.lits.osbb.repository.OsbbRepository;
import com.lits.osbb.service.OsbbService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service(value = "osbbService")
public class OsbbServiceImpl implements OsbbService {

    private OsbbRepository osbbRepository;

    private ModelMapper modelMapper;

    @Autowired
    public OsbbServiceImpl(OsbbRepository osbbRepository, ModelMapper modelMapper) {
        this.osbbRepository = osbbRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OsbbDto findOne(Long id) {
        return osbbRepository.findById(id)
                .map(e -> modelMapper.map(e, OsbbDto.class))
<<<<<<< HEAD
                .orElseThrow(() -> new OsbbNotFoundException("Osbb with id: " + id + " not found"));
=======
                .orElseThrow(() -> new NotFoundException("Osbb with id: " + id + " not found"));
>>>>>>> 1f0493ff60cb6ac98d04b50e4fdca82cd5eef719
    }

    @Override
    public List<OsbbDto> findAll() {
        return osbbRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, OsbbDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OsbbDto save(OsbbDto osbbDto) {
        return Optional.of(osbbDto)
                .map(e -> modelMapper.map(e, Osbb.class))
                .map(e -> osbbRepository.save(e))
                .map(e -> modelMapper.map(e, OsbbDto.class))
<<<<<<< HEAD
                .orElseThrow(() -> new OsbbNotFoundException("OsbbDto Object is null. Nothing to save"));
=======
                .orElseThrow(() -> new NotFoundException("OsbbDto Object is null. Nothing to save"));
>>>>>>> 1f0493ff60cb6ac98d04b50e4fdca82cd5eef719
    }

    @Override
    public OsbbDto update(Long id, OsbbDto osbbDto) {
        Osbb osbb = Optional.of(osbbDto)
                .map(e -> modelMapper.map(e, Osbb.class))
<<<<<<< HEAD
                .orElseThrow(() -> new OsbbNotFoundException("OsbbDto Object is null. Nothing to update"));
=======
                .orElseThrow(() -> new NotFoundException("OsbbDto Object is null. Nothing to update"));
>>>>>>> 1f0493ff60cb6ac98d04b50e4fdca82cd5eef719
        osbb.setId(id);

        return Optional.of(osbbRepository.save(osbb))
                .map(e -> modelMapper.map(e, OsbbDto.class))
<<<<<<< HEAD
                .orElseThrow(() -> new OsbbNotFoundException("Osbb not saved"));
=======
                .orElseThrow(() -> new NotFoundException("Osbb not saved"));
>>>>>>> 1f0493ff60cb6ac98d04b50e4fdca82cd5eef719
    }

    @Override
    public void delete(Long id) {
        osbbRepository.deleteById(id);
    }

}
