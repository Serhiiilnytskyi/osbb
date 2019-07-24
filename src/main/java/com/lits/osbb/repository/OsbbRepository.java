package com.lits.osbb.repository;

import com.lits.osbb.model.Osbb;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OsbbRepository extends CrudRepository<Osbb, Long> {

    Optional<Osbb> findById(Long id);

    List<Osbb> findAll();

}