package com.lits.osbb.repository;

import com.lits.osbb.model.Osbb;
import org.springframework.data.repository.CrudRepository;

public interface OsbbRepository extends CrudRepository<Osbb, Long> {
    Osbb findByEmail(String login);
}
