package com.TotvsTest.ApiTest.resources;


import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.models.Dependent;
import com.TotvsTest.ApiTest.models.Telephone;
import com.TotvsTest.ApiTest.repositories.ClientRepository;
import com.TotvsTest.ApiTest.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TelephoneControllers {
    @Autowired
    TelephoneRepository telephoneRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/telephone")
    public Iterable<Telephone> listTelephone() {
        return telephoneRepository.findAll();
    }

    @GetMapping("/telephone/{id}")
    public Telephone listOneTelephone(@PathVariable(value = "id") long id) {
        return telephoneRepository.findById(id);
    }

    @PostMapping("/telephone/{client_id}")
    public ResponseEntity<Object> saveTelephone(@PathVariable(value = "client_id") long id, @RequestBody List<Telephone> telephone) {

        Client client = clientRepository.findById(id);
        if (client != null) {

            for (int i = 0; i < telephone.size(); i++) {
                telephone.get(i).setTelephone(client);
                telephoneRepository.save(telephone.get(i));
            }

            return new ResponseEntity<Object>(telephone, HttpStatus.OK);
        }
        return new ResponseEntity<>("usuário não encontrado", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/telephone/{id}")
    public ResponseEntity<Object> deleteTelephone(@PathVariable(value = "id") long id) {
        Telephone telephone = telephoneRepository.findById(id);
        if (telephone != null) {
            telephoneRepository.delete(telephone);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/telephone/{id}")
    public ResponseEntity<Telephone> updateTelephone(@PathVariable(value = "id") long id, @RequestBody Telephone telephone){
        Telephone findTelephone = telephoneRepository.findById(id);

        if(findTelephone != null){
            findTelephone.setType(telephone.getType());
            findTelephone.setCode(telephone.getCode());
            findTelephone.setDdd(telephone.getDdd());
            findTelephone.setNumber(telephone.getNumber());

            telephoneRepository.save(findTelephone);
            return new ResponseEntity<Telephone>(findTelephone, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
