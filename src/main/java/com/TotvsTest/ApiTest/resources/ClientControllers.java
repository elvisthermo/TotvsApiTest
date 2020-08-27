package com.TotvsTest.ApiTest.resources;


import com.TotvsTest.ApiTest.models.Address;
import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.models.Dependent;
import com.TotvsTest.ApiTest.models.Telephone;
import com.TotvsTest.ApiTest.repositories.AdressRepository;
import com.TotvsTest.ApiTest.repositories.ClientRepository;
import com.TotvsTest.ApiTest.repositories.DependentRepository;
import com.TotvsTest.ApiTest.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClientControllers {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AdressRepository addressRepository;

    @Autowired
    DependentRepository dependentRepository;

    @Autowired
    TelephoneRepository telephoneRepository;

    @GetMapping("/clients")
    public Iterable<Client> listClient(){
        return  clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client listOneClient(@PathVariable(value = "id")long id){
        return  clientRepository.findById(id);
    }

    @PostMapping("/client")
    public Client saveClient(@RequestBody Client client){
        List<Address> address  = client.getAddress();
        List<Dependent>dependents = client.getDependents();
        List<Telephone>telephones = client.getTelephone();


        for(int i=0;i<address.size();i++){
            address.get(i).setClient(client);
            addressRepository.save(address.get(i));
        }
        for(int i=0;i<dependents.size();i++){
            dependents.get(i).setDependent(client);
            dependentRepository.save(dependents.get(i));
        }

        for(int i=0;i<telephones.size();i++){
            telephones.get(i).setTelephone(client);
            telephoneRepository.save(telephones.get(i));
        }
        return clientRepository.save(client);

    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id")long id){
        Client client =  clientRepository.findById(id);
        if(client !=null){
            clientRepository.delete(client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "id") long id, @RequestBody Client client){
        Client findClient = clientRepository.findById(id);

        if(findClient != null){
            findClient.setName(client.getName());
            findClient.setCpfOrCnpj(client.getCpfOrCnpj());
            findClient.setNickname(client.getNickname());
            findClient.setProfession(client.getProfession());
            findClient.setSalary(client.getSalary());
            findClient.setDateOfBirth(client.getDateOfBirth());


            clientRepository.save(findClient);
            return new ResponseEntity<Client>(client, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
