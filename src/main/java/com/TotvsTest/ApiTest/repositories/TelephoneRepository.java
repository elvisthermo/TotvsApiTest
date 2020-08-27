package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Dependent;
import com.TotvsTest.ApiTest.models.Telephone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends CrudRepository<Telephone,Long> {
    Telephone findById(long id);

}
