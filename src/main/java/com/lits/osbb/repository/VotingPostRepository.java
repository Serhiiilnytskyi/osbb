package com.lits.osbb.repository;

import com.lits.osbb.model.VotingPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VotingPostRepository extends CrudRepository<VotingPost, Long> {

    VotingPost findOneByTitle(String title);

    VotingPost findOneByAuthor(String author);

    List<VotingPost> findAll ();

    VotingPost save(VotingPost votingPost);

    void delete(VotingPost votingPost);

}
