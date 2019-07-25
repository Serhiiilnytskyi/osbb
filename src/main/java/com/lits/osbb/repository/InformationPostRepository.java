package com.lits.osbb.repository;

import com.lits.osbb.dto.InformationPostDto;
import com.lits.osbb.model.InformationPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformationPostRepository extends CrudRepository<InformationPost, Long> {

    Optional<InformationPost> findById (Long Id);

    ResponseEntity<?> save(InformationPostDto informasionPostDto);

    void delete(InformationPost e);

    InformationPost findOneByTitle(String title);

    InformationPost findOneByAuthor(String author);

}
