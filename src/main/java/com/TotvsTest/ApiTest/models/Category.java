package com.TotvsTest.ApiTest.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "category"
    )
    private List<Pessoa> pessoa = new ArrayList<>();

//    public Category(String name) {
//        this.name = name;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Pessoa> getItem() {
//        return pessoa;
//    }

    public void setItem(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }
}
