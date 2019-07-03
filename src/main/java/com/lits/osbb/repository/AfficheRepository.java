package com.lits.osbb.repository;

import com.lits.osbb.model.Affiche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfficheRepository extends JpaRepository<Affiche, Long> {

    Affiche findOneById (Long Id);

}
