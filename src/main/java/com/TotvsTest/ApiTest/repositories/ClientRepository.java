package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findById(long id);

}
