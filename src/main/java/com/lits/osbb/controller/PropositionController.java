package com.lits.osbb.controller;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.service.PropositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping(value = "/api/propositions")
public class PropositionController {

    private PropositionService propositionService;

    @Autowired
    public PropositionController(PropositionService propositionService) {
        this.propositionService = propositionService;
    }

    @ApiOperation(value = "save")
    @PostMapping(value = "/")
    public PropositionDto save(@Validated @RequestBody PropositionDto propositionDto){
        return propositionService.save(propositionDto);
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/getAll")
    public List<PropositionDto> findAll(){
        return propositionService.findAll();
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/getOneById/{id}")
    public PropositionDto findOne(@RequestParam(value = "id", defaultValue = "") Long id){
        return propositionService.findOne(id);
    }

    @ApiOperation(value = "getOneByTitle")
    @GetMapping(value = "/getOneByTitle/{title}")
    public PropositionDto findOneByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        return propositionService.findOneByTitle(title);
    }

    @ApiOperation(value = "update")
    @PutMapping(value = "/update")
    public PropositionDto update(@RequestBody PropositionDto propositionDto){
        return propositionService.update(propositionDto);
    }

    @ApiOperation(value = "delete")
    @DeleteMapping(value = "/delete/{propositionDto}")
    public ResponseEntity<PropositionDto> delete(@RequestParam(value = "propositionDto") PropositionDto propositionDto){
        return new ResponseEntity<>(propositionDto, HttpStatus.OK);
    }

    @ApiOperation(value = "deleteOneById")
    @DeleteMapping(value = "/deleteOneById/{id}")
    public ResponseEntity<Long> delete(@RequestParam(value = "id") Long id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
