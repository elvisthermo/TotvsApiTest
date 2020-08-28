package com.TotvsTest.ApiTest.repositories;

import com.TotvsTest.ApiTest.models.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findById(long id);

    @Query("FROM Client WHERE cpf_or_cnpj =?1")
    Client findByCpf(String cpf_or_cnpj);

}
