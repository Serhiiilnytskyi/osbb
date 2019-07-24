package com.lits.osbb.repository;

import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.model.InformationPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

public interface InformationPostService extends CrudRepository<InformationPost, Long> {

    InformationPost findOneById (Long Id);

    ResponseEntity<?> save(InformationPostDto informasionPostDto);

    void delete(InformationPost e);

    InformationPost findOneByTitle(String title);

    InformationPost findOneByAuthor(String author);
}
