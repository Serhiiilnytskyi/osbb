package com.lits.osbb.repository;

import com.lits.osbb.model.Proposition;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropositionRepository extends CrudRepository<Proposition, Long> {

    List<Proposition> findAll();

    Proposition findOneById(Long id);

    Proposition findOneByTitle(String title);

    Proposition save(Proposition e);
}

