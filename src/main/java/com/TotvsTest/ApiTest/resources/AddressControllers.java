package com.TotvsTest.ApiTest.resources;


import com.TotvsTest.ApiTest.models.Address;
import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.repositories.AddressRepository;
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
    AddressRepository addressRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/address")
    public Iterable<Address> listAddress() {
        return addressRepository.findAll();
    }

    @GetMapping("/address/{id}")
    public Address listOneAddress(@PathVariable(value = "id") long id) {
        return addressRepository.findById(id);
    }

    @PostMapping("/address/{client_id}")
    public ResponseEntity<Object> saveAddress(@PathVariable(value = "client_id") long id, @RequestBody List<Address> address) {

        Client client = clientRepository.findById(id);
        if (client != null) {

            for (int i = 0; i < address.size(); i++) {
                address.get(i).setClient(client);
                addressRepository.save(address.get(i));
             }

        return new ResponseEntity<Object>(address, HttpStatus.OK);
        }
        return new ResponseEntity<>("usuário não encontrado", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Object> deleteAddress(@PathVariable(value = "id") long id) {
        Address address = addressRepository.findById(id);
        if (address != null) {
            addressRepository.delete(address);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/address/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") long id, @RequestBody Address address){
        Address findAddress = addressRepository.findById(id);

        if(findAddress != null){
            System.out.println(findAddress.getId().toString());
            findAddress.setAddressType(address.getAddressType());
            findAddress.setType(address.getType());
            findAddress.setName(address.getName());
            findAddress.setNumber(address.getNumber());
            findAddress.setComplement(address.getComplement());
            findAddress.setNeighborhood(address.getNeighborhood());
            findAddress.setCity(address.getCity());
            findAddress.setState(address.getState());
            findAddress.setCountry(address.getCountry());
            findAddress.setCEP(address.getCEP());

            addressRepository.save(findAddress);
            return new ResponseEntity<Address>(findAddress, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
