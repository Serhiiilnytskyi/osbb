package com.lits.osbb.controller;

import com.lits.osbb.model.InformationPost;
import com.lits.osbb.model.Post;
import com.lits.osbb.model.VotingPost;
import com.lits.osbb.repository.VotingPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class VotingPostController {

    @Autowired
    private VotingPostRepository votingPostRepository;

    @GetMapping(value = "")
    ResponseEntity<?> findAll(){
        return ResponseEntity.ok(votingPostRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> findOneById(@PathVariable("id")Long id){
        return ResponseEntity.ok(votingPostRepository.findOne(id));
    }

    @PostMapping(value = "/{id}")
    void deleteOneById(@PathVariable("id")Long id){
        votingPostRepository.delete(id);
    }

    @RequestMapping(value = "")
    ResponseEntity<?> saveAffiche(@Validated @RequestBody Post postDto){
        return ResponseEntity.ok(votingPostRepository.save((VotingPost) postDto));
    }



}