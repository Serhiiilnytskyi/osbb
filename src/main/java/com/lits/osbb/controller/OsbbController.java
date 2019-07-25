package com.lits.osbb.controller;

import com.lits.osbb.dto.OsbbDto;
import com.lits.osbb.service.OsbbService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/osbbs")
public class OsbbController {

    private OsbbService osbbService;

    public OsbbController(OsbbService osbbService) {
        this.osbbService = osbbService;
    }

    @ApiOperation(value = "save")
    @PostMapping(value = "/")
    public OsbbDto save(@Validated @RequestBody OsbbDto osbbDto) {
        return osbbService.save(osbbDto);
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/getAll")
    public List<OsbbDto> findAll() {
        return osbbService.findAll();
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/getOneById/{id}")
    public OsbbDto findOne(@RequestParam(value = "id", defaultValue = "") Long id) {
        return osbbService.findOne(id);
    }

    @ApiOperation(value = "update")
    @PutMapping(value = "/update/{id}")
    public OsbbDto update(@RequestParam Long id, @RequestBody OsbbDto osbbDto) {
        return osbbService.update(id, osbbDto);
    }

    @ApiOperation(value = "delete")
    @DeleteMapping(value = "/delete/{osbbDto}")
    public ResponseEntity<OsbbDto> delete(@RequestParam(value = "osbbDto") OsbbDto osbbDto) {
        return new ResponseEntity<>(osbbDto, HttpStatus.OK);
    }

    @ApiOperation(value = "deleteOneById")
    @DeleteMapping(value = "/deleteOneById/{id}")
    public ResponseEntity<Long> delete(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
