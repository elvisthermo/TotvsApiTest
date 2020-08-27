package com.TotvsTest.ApiTest.resources;


import com.TotvsTest.ApiTest.models.Address;
import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.repositories.AdressRepository;
import com.TotvsTest.ApiTest.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AddressControllers {

    @Autowired
    AdressRepository addressRepository;

    @GetMapping("/address")
    public Iterable<Address> listClient(){
        return  addressRepository.findAll();
    }

    @GetMapping("/address/{id}")
    public Address listOneClient(@PathVariable(value = "id")long id){
        return  addressRepository.findById(id);
    }

    @PostMapping("/address")
    public Address saveClient(@RequestBody Address address){
        return addressRepository.save(address);

    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id")long id){
        Address address =  addressRepository.findById(id);
        if(address !=null){
            addressRepository.delete(address);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    @PutMapping("/client/{id}")
//    public ResponseEntity<Address> updateClient(@PathVariable(value = "id") long id, @RequestBody Address address){
//        Address findClient = addressRepository.findById(id);
//
//        if(findClient != null){
//            findClient.setName(client.getName());
//            findClient.setCpfOrCnpj(client.getCpfOrCnpj());
//            findClient.setNickname(client.getNickname());
//            findClient.setProfession(client.getProfession());
//            findClient.setSalary(client.getSalary());
//            findClient.setDateOfBirth(client.getDateOfBirth());
//
//
//            addressRepository.save(findClient);
//            return new ResponseEntity<Client>(client, HttpStatus.OK);
//
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

}
