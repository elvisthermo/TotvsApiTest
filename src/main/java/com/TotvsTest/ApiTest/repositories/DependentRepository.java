package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.models.Dependent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepository extends CrudRepository<Dependent,Long> {
    Dependent findById(long id);

    @Query("FROM Client WHERE name =?1")
    Client findByName(String name);

}
