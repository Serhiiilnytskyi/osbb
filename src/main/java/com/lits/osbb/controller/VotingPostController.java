package com.lits.osbb.controller;

import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.service.VotingPostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/votingposts")
public class VotingPostController {

    private VotingPostService votingPostService;

    public VotingPostController(VotingPostService votingPostService) {
        this.votingPostService = votingPostService;
    }

    @ApiOperation(value = "save")
    @PostMapping(value = "/")
    public ResponseEntity<?> save(@Valid @RequestBody VotingPostDto votingPostDto) {
        return new ResponseEntity<>(votingPostService.save(votingPostDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(votingPostService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@RequestParam(value = "id", defaultValue = "") Long id) {
        return new ResponseEntity<>(votingPostService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByTitle")
    @GetMapping(value = "/getOneByTitle/{title}")
    public ResponseEntity<?> findOneByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        return new ResponseEntity<>(votingPostService.findOneByTitle(title), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByAuthor")
    @GetMapping(value = "/getOneByAuthor/{author}")
    private ResponseEntity<?> findOneByAuthor(@RequestParam(value = "author", defaultValue = "") String author) {
        return new ResponseEntity<>(votingPostService.findOneByAuthor(author), HttpStatus.OK);
    }

    @ApiOperation(value = "update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(value = "/")
    public ResponseEntity<?> update(@RequestParam Long id, @Valid @RequestBody VotingPostDto votingPostDto) {
        return new ResponseEntity<>(votingPostService.update(id, votingPostDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        votingPostService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
