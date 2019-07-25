package com.lits.osbb.repository;

import com.lits.osbb.model.Osbb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OsbbRepository extends CrudRepository<Osbb, Long> {

    Optional<Osbb> findById(Long id);

    List<Osbb> findAll();

}
