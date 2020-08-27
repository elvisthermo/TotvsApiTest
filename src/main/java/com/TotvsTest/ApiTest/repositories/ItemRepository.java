package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Pessoa,Long>{

}
