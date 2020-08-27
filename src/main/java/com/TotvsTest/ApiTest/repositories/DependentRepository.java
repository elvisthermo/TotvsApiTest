package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Dependent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository extends CrudRepository<Dependent,Long> {
    Dependent findById(long id);

}
