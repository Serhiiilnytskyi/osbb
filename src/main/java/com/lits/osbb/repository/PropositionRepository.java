package com.lits.osbb.repository;

import com.lits.osbb.model.Proposition;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropositionRepository extends CrudRepository<Proposition, Long> {

    List<Proposition> findAll();

    Proposition findOneById(Long id);

    Proposition findOneByTitle(String title);

    Proposition save(Proposition e);

    void delete(Proposition e);
}

