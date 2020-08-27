package com.TotvsTest.ApiTest.models;

import javax.persistence.*;

@Entity
@Table(name = "Dependent")
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client dependents;

    private String type;//Esposa, Filho, Pai, Mãe
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDependent(Client dependent) {
        this.dependents = dependent;
    }
}
