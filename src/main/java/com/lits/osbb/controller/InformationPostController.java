package com.lits.osbb.controller;
import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.model.InformationPost;
import com.lits.osbb.model.Post;
import com.lits.osbb.repository.InformationPostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/informationPost")
public class InformationPostController {


    private InformationPostService informationPostService;

    @Autowired
    public InformationPostController(InformationPostService informationPostRepository) {
        this.informationPostService = informationPostRepository;
    }

    @ApiOperation(value = "getAll")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<?>> findAll(){
        return new ResponseEntity(informationPostService.findAll(), HttpStatus.OK);
    }
    @ApiOperation(value = "getOneById")
    @GetMapping(value = "/{id}")
    ResponseEntity<?> findOne(@RequestParam (value = "id",defaultValue = "") Long id){
        return new ResponseEntity(informationPostService.findOne(id), HttpStatus.OK);
    }
    @ApiOperation(value = "delete")
    @PostMapping(value = "/delete/{id}")
    void deleteOneById(@PathVariable("id")Long id){
        informationPostService.delete(id);
    }

    @ApiOperation(value = "save")
    @RequestMapping(value = "/save/{id}")
    ResponseEntity<?> saveAffiche(@RequestParam(value = "informationPostDto")InformationPostDto informationPostDto){
        return new ResponseEntity(informationPostService.save(informationPostDto),HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByTitle")
    @GetMapping(value = "/getOneByTitle/{title}")
    public ResponseEntity<?> findOneByTitle(@RequestParam (value = "title",defaultValue = "") String title){
        return new ResponseEntity(informationPostService.findOneByTitle(title),HttpStatus.OK);
    }

    @ApiOperation(value = "getOneByAuthor")
    @GetMapping(value = "/getOneByAuthor/{author}")
    private ResponseEntity<?> findOneByAuthor(@RequestParam (value = "author",defaultValue = "") String author){
        return new ResponseEntity(informationPostService.findOneByAuthor(author),HttpStatus.OK);
    }



}