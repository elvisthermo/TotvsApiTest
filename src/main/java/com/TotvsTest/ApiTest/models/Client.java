package com.TotvsTest.ApiTest.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Address> address = new ArrayList<>();

    @OneToMany(
            mappedBy = "dependents",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Dependent> dependents = new ArrayList<>();

    @OneToMany(
            mappedBy = "telephone",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Telephone> telephone = new ArrayList<>();

    private String nickname;
    private String cpfOrCnpj;
    private String profession;
    private String salary;


    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    public void setAddress(List<Address> addresses){
        this.address = addresses;
    }

    public List<Address> getAddress() {
        return address;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public List<Telephone> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<Telephone> telephone) {
        this.telephone = telephone;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
