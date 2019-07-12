package com.lits.osbb.repository;

import com.lits.osbb.model.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropositionRepository extends JpaRepository<Proposition, Long> {

    Proposition findOneById(Long id);

    Proposition findOneByTitle(String title);

    Proposition save(Proposition e);

    void delete(Proposition e);
}

