package com.lits.osbb.controller;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.service.PropositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<PropositionDto> save(@Valid @RequestBody PropositionDto propositionDto){
        return new ResponseEntity<>(propositionService.save(propositionDto), HttpStatus.OK);
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<PropositionDto>> findAll(){
        return new ResponseEntity<>(propositionService.findAll(),HttpStatus.OK);
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/getOneById/{id}")
    public ResponseEntity<PropositionDto> findOne(@RequestParam(value = "id", defaultValue = "") Long id){
        return new ResponseEntity<>(propositionService.findOne(id),HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByTitle")
    @GetMapping(value = "/getOneByTitle/{title}")
    public ResponseEntity<PropositionDto> findOneByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        return new ResponseEntity<>(propositionService.findOneByTitle(title), HttpStatus.OK);
    }

    @ApiOperation(value = "update")
    @PutMapping(value = "/update")
    public ResponseEntity<PropositionDto> update(@RequestBody PropositionDto propositionDto){
        return new ResponseEntity<>(propositionService.update(propositionDto), HttpStatus.OK);

    }

    @ApiOperation(value = "delete")
    @DeleteMapping(value = "/delete/{propositionDto}")
    public ResponseEntity<PropositionDto> delete(@RequestParam(value = "propositionDto") PropositionDto propositionDto){
        return new ResponseEntity<>(propositionDto, HttpStatus.OK);
    }

}
