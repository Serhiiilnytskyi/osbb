package com.lits.osbb.controller;

import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.service.VotingPostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/votingposts")
public class VotingPostController {

    private VotingPostService votingPostService;

    public VotingPostController(VotingPostService votingPostService) {
        this.votingPostService = votingPostService;
    }

    @ApiOperation(value = "save")
    @PostMapping(value = "/")
    public ResponseEntity<VotingPostDto> save(@Valid @RequestBody VotingPostDto votingPostDto) {
        return new ResponseEntity<>(votingPostService.save(votingPostDto), HttpStatus.OK);
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<VotingPostDto>> findAll() {
        return new ResponseEntity<>(votingPostService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/getOneById/{id}")
    public ResponseEntity<VotingPostDto> findOne(@RequestParam(value = "id", defaultValue = "") Long id) {
        return new ResponseEntity<>(votingPostService.findOne(id), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByTitle")
    @GetMapping(value = "/getOneByTitle/{title}")
    public ResponseEntity<VotingPostDto> findOneByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        return new ResponseEntity<>(votingPostService.findOneByTitle(title), HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByAuthor")
    @GetMapping(value = "/getOneByAuthor/{author}")
    private ResponseEntity<VotingPostDto> findOneByAuthor(@RequestParam(value = "author", defaultValue = "") String author) {
        return new ResponseEntity<>(votingPostService.findOneByAuthor(author), HttpStatus.OK);
    }

    @ApiOperation(value = "update")
    @PutMapping(value = "/update")
    public ResponseEntity<VotingPostDto> update(@RequestBody VotingPostDto votingPostDto) {
        return new ResponseEntity<>(votingPostService.update(votingPostDto), HttpStatus.OK);

    }

    @ApiOperation(value = "delete")
    @DeleteMapping(value = "/delete/{votingPostDto}")
    public ResponseEntity<VotingPostDto> delete(@RequestParam(value = "votingPostDto") VotingPostDto votingPostDto) {
        return new ResponseEntity<>(votingPostDto, HttpStatus.OK);
    }
}
