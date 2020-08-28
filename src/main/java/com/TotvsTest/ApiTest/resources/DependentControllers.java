package com.TotvsTest.ApiTest.resources;

import com.TotvsTest.ApiTest.models.Client;
import com.TotvsTest.ApiTest.models.Dependent;
import com.TotvsTest.ApiTest.repositories.ClientRepository;
import com.TotvsTest.ApiTest.repositories.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DependentControllers {

    @Autowired
    DependentRepository dependentRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/dependents")
    public Iterable<Dependent> listDependents() {
        return dependentRepository.findAll();
    }

    @GetMapping("/dependent/{id}")
    public Dependent listOneDependents(@PathVariable(value = "id") long id) {
        return dependentRepository.findById(id);
    }

    @PostMapping("/dependent/{client_id}")
    public ResponseEntity<Object> saveDependent(@PathVariable(value = "client_id") long id, @RequestBody List<Dependent> dependent) {

        Client client = clientRepository.findById(id);
        if (client != null) {

            for (int i = 0; i < dependent.size(); i++) {
                dependent.get(i).setDependent(client);
                dependentRepository.save(dependent.get(i));
            }

            return new ResponseEntity<Object>(dependent, HttpStatus.OK);
        }
        return new ResponseEntity<>("usuário não encontrado", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/dependent/{id}")
    public ResponseEntity<Object> deleteDependent(@PathVariable(value = "id") long id) {
        Dependent dependent = dependentRepository.findById(id);
        if (dependent != null) {
            dependentRepository.delete(dependent);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/dependent/{id}")
    public ResponseEntity<Dependent> updateDependent(@PathVariable(value = "id") long id, @RequestBody Dependent dependent){
        Dependent findDependent = dependentRepository.findById(id);

        if(findDependent != null){
            findDependent.setName(dependent.getName());
            findDependent.setType(dependent.getType());

            dependentRepository.save(findDependent);
            return new ResponseEntity<Dependent>(findDependent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
