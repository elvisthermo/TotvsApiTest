package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long>{
    Address findById(long id);

}
