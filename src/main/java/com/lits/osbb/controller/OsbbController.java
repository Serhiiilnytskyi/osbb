package com.lits.osbb.controller;

import com.lits.osbb.dto.OsbbDto;
import com.lits.osbb.service.OsbbService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/osbbs")
public class OsbbController {

    private OsbbService osbbService;

    public OsbbController(OsbbService osbbService) {
        this.osbbService = osbbService;
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(osbbService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@RequestParam Long id) {
        return new ResponseEntity<>(osbbService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "save")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/")
    public ResponseEntity<?> save(@Valid @RequestBody OsbbDto osbbDto) {
        return new ResponseEntity<>(osbbService.save(osbbDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestParam Long id, @Valid @RequestBody OsbbDto osbbDto) {
        return new ResponseEntity<>(osbbService.update(id, osbbDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        osbbService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
