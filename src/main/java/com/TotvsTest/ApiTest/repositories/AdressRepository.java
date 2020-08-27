package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Address;
import com.TotvsTest.ApiTest.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends CrudRepository<Address,Long>{
    Address findById(long id);


}
