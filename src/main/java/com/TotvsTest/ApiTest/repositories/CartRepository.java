package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Category,Long>{

}
