package com.lits.osbb.controller;

import com.lits.osbb.dto.PropositionDto;
import com.lits.osbb.service.PropositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api
@RestController
@RequestMapping(value = "/propositions")
public class PropositionController {

    private PropositionService propositionService;

    public PropositionController(PropositionService propositionService) {
        this.propositionService = propositionService;
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/")
    public ResponseEntity<List<PropositionDto>> findAll() {
        return new ResponseEntity<>(propositionService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?>findOne(@RequestParam(value = "id", defaultValue = "") Long id) {
        return new ResponseEntity<>(propositionService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "save")
    @PostMapping(value = "/")
    public ResponseEntity<?>save(@Valid @RequestBody PropositionDto propositionDto) {
        return new ResponseEntity<>(propositionService.save(propositionDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "/")
    public ResponseEntity<?>update(@RequestParam Long id,@Valid @RequestBody PropositionDto propositionDto) {
        return new ResponseEntity<>(propositionService.update(id, propositionDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?>delete(@RequestParam Long id) {
        propositionService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
