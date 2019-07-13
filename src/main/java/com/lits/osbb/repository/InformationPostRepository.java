package com.lits.osbb.repository;

import com.lits.osbb.model.InformationPost;
import org.springframework.data.repository.CrudRepository;

public interface InformationPostRepository extends CrudRepository<InformationPost, Long> {

    InformationPost findOneById (Long Id);

}
