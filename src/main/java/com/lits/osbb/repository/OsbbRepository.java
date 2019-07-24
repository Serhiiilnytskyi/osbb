package com.lits.osbb.repository;

import com.lits.osbb.model.Osbb;
import com.lits.osbb.model.Osbb;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OsbbRepository extends CrudRepository<Osbb, Long> {

    Optional<Osbb> findById(Long id);

    List<Osbb> findAll();

<<<<<<< HEAD
}
=======
}
>>>>>>> 1f0493ff60cb6ac98d04b50e4fdca82cd5eef719
