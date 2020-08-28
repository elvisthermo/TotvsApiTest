package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.models.Telephone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends CrudRepository<Telephone,Long> {
    Telephone findById(long id);


    @Query("FROM Client WHERE number =?1")
    Client findByNumber(String name);
}
