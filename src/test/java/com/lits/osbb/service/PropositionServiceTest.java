package com.lits.osbb.service;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.model.Proposition;
import com.lits.osbb.repository.PropositionRepository;
import com.lits.osbb.service.impl.PropositionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropositionServiceTest {

    @Mock
    private PropositionRepository propositionRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PropositionServiceImpl propositionService;

    @Test
    public void shouldFindOne(){
        Proposition proposition = new Proposition();
        PropositionDto propositionDto = new PropositionDto();

        when(propositionRepository.findOneById(1L)).thenReturn(proposition);
        when(modelMapper.map(proposition, PropositionDto.class)).thenReturn(propositionDto);

        assertEquals(propositionDto,propositionService.findOne(1L));
        assertNotNull(propositionDto);
    }

    @Test
    public void shouldFindOneByTitle(){
        Proposition proposition = new Proposition();
        PropositionDto propositionDto = new PropositionDto();

        when(propositionRepository.findOneByTitle("Title")).thenReturn(proposition);
        when(modelMapper.map(proposition,PropositionDto.class)).thenReturn(propositionDto);

        assertEquals(propositionDto,propositionService.findOneByTitle("Title"));
        assertNotNull(propositionDto);
    }

    @Test
    public void shouldFindAll(){
        Proposition proposition = new Proposition();
        PropositionDto propositionDto = new PropositionDto();

        List<Proposition> propositions = new ArrayList<>();
        List<PropositionDto> propositionDtos = new ArrayList<>();

        propositions.add(proposition);
        propositionDtos.add(propositionDto);

        when(propositionRepository.findAll()).thenReturn(propositions);
        when(modelMapper.map(proposition,PropositionDto.class)).thenReturn(propositionDto);

        assertEquals(propositionDtos,propositionService.findAll());
        assertNotNull(propositions);
    }

    @Test
    public void shouldSave(){
        Proposition proposition = new Proposition();
        PropositionDto propositionDto = new PropositionDto();

        when(modelMapper.map(propositionDto,Proposition.class)).thenReturn(proposition);
        when(propositionRepository.save(proposition)).thenReturn(proposition);
        when(modelMapper.map(proposition,PropositionDto.class)).thenReturn(propositionDto);

        assertEquals(propositionDto,propositionService.save(propositionDto));
        assertNotNull(proposition);
    }

    @Test
    public void shouldUpdate(){
        Proposition proposition = new Proposition();
        PropositionDto propositionDto = new PropositionDto();

        when(modelMapper.map(propositionDto,Proposition.class)).thenReturn(proposition);
        when(propositionRepository.save(proposition)).thenReturn(proposition);
        when(modelMapper.map(proposition,PropositionDto.class)).thenReturn(propositionDto);

        assertEquals(propositionDto,propositionService.update(1L, propositionDto));
        assertNotNull(propositionDto);
    }
}
