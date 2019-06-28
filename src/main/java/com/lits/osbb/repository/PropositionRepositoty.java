package com.lits.osbb.repository;

import com.lits.osbb.model.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropositionRepositoty extends JpaRepository<Proposition, Long> {

    Proposition findOneById(Long id);

    Proposition save(Proposition e);

    void delete(Proposition e);
}

