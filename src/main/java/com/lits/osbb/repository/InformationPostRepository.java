package com.lits.osbb.repository;

import com.lits.osbb.model.InformationPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationPostRepository extends CrudRepository<InformationPost, Long> {

    InformationPost findOneById (Long Id);
//    InformationPost findOneByDate (Date date);
//    InformationPost findOneByName (String name);

}
