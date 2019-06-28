package com.lits.osbb.service.impl;
import com.lits.osbb.dto.AfficheDto;
import com.lits.osbb.model.Affiche;
import com.lits.osbb.repository.AfficheRepository;
import com.lits.osbb.service.AfficheService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AfficheServiceImpl implements AfficheService {

    @Autowired
    AfficheRepository afficheRepository;
    @Autowired
    ModelMapper modelMapper;



    public AfficheDto findOne(Long id){
        return Optional.ofNullable(afficheRepository.findOneById(id))
                .map(e -> modelMapper.map(e, AfficheDto.class))
                .orElse(new AfficheDto());
    }

    public List<AfficheDto> findAll(){
        return afficheRepository.findAll().stream()
                .map(e -> modelMapper.map(e, AfficheDto.class))
                .collect(Collectors.toList());
    }

    public AfficheDto save(AfficheDto afficheDto){
        return Optional.ofNullable(afficheDto)
                .map(e -> modelMapper.map(e, Affiche.class))
                .map(e -> afficheRepository.save(e))
                .map(e -> modelMapper.map(e, AfficheDto.class))
                .orElse(new AfficheDto());
    }

    public AfficheDto update(AfficheDto afficheDto){return Optional.ofNullable(afficheDto)
            .map(e -> modelMapper.map(e, Affiche.class))
            .map(e -> afficheRepository.save(e))
            .map(e -> modelMapper.map(e, AfficheDto.class))
            .orElse(new AfficheDto());};

    public void delete(AfficheDto afficheDto){
        afficheRepository.delete(modelMapper.map(afficheDto, Affiche.class));
    }

    public void delete(Long id){
        afficheRepository.delete(id);
    };

}
