package com.lits.osbb.repository;

import com.lits.osbb.dto.VotingPostDto;
import com.lits.osbb.model.VotingPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface VotingPostRepository extends CrudRepository<VotingPost, Long> {

    Optional<VotingPost> findById(Long id);

    VotingPost findByTitleContains(String title);

    VotingPost findByAuthor(String title);

    ResponseEntity<?> save(VotingPostDto votingPostDto);

    void delete(VotingPost e);

}
