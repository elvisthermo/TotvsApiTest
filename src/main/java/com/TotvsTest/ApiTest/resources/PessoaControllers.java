package com.TotvsTest.ApiTest.resources;

import com.TotvsTest.ApiTest.models.Category;
import com.TotvsTest.ApiTest.models.Pessoa;
import com.TotvsTest.ApiTest.repositories.CartRepository;
import com.TotvsTest.ApiTest.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PessoaControllers {
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/pessoa")
    public Iterable<Pessoa> listClient(){
        return  itemRepository.findAll();
    }
}
