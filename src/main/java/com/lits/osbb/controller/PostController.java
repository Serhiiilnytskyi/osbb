package com.lits.osbb.controller;

import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class PostController {   // - For properly PostController work methods in VotingPostServiceImpl and InformationPostServiceImpl should be the same

    @Autowired
    private CrudRepository crudRepository;

    @GetMapping(value = "")
    ResponseEntity<?> findAll(){
        return ResponseEntity.ok(crudRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<?> findOneById(@PathVariable("id")Long id){
        return ResponseEntity.ok(crudRepository.findOne(id));
    }

    @PostMapping(value = "/{id}")
    void deleteOneById(@PathVariable("id")Long id){
        crudRepository.delete(id);
    }

    @RequestMapping(value = "")
    ResponseEntity<?> saveAffiche(@Validated @RequestBody Post postDto){
        return ResponseEntity.ok(crudRepository.save(postDto));
    }

}