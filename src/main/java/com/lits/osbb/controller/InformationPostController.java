package com.lits.osbb.controller;

import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.repository.InformationPostRepository;
import com.lits.osbb.service.InformationPostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/informationPosts")
public class InformationPostController {

    private InformationPostService informationPostService;

    public InformationPostController(InformationPostService informationPostService) {
        this.informationPostService = informationPostService;
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(informationPostService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/{id}")
    ResponseEntity<?> findOne(@RequestParam(value = "id", defaultValue = "") Long id) {
        return new ResponseEntity<>(informationPostService.findOne(id), HttpStatus.OK);
    }


    @ApiOperation(value = "getOneByTitle")
    @GetMapping(value = "/getOneByTitle/{title}")
    public ResponseEntity<?> findOneByTitle(@RequestParam(value = "title") String title) {
        return new ResponseEntity<>(informationPostService.findOneByTitle(title), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByAuthor")
    @GetMapping(value = "/getOneByAuthor/{author}")
    private ResponseEntity<?> findOneByAuthor(@Valid @RequestParam(value = "author") String author) {
        return new ResponseEntity<>(informationPostService.findOneByAuthor(author), HttpStatus.OK);
    }


    @ApiOperation(value = "save")
    @PostMapping(value = "/")
    ResponseEntity<?> save(@Valid @RequestBody InformationPostDto informationPostDto) {
        return new ResponseEntity<>(informationPostService.save(informationPostDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    ResponseEntity<?> update( @RequestParam Long id, @Valid @RequestBody InformationPostDto informationPostDto) {
        return new ResponseEntity<>(informationPostService.update(id, informationPostDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id) {
        informationPostService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
