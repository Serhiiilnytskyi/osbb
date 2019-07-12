package com.lits.osbb.repository;

import com.lits.osbb.model.Affiche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AfficheRepository extends CrudRepository<Affiche, Long> {

    Affiche findOneById (Long Id);

}
