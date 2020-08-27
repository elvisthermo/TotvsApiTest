package com.TotvsTest.ApiTest.models;

import javax.persistence.*;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nickname;
    private String cpfOrCnpj;
    private String profession;
    private String salary;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    public Pessoa(String name, String nickname, String cpfOrCnpj, String profession, String salary, Category category) {
//        this.name = name;
//        this.nickname = nickname;
//        this.cpfOrCnpj = cpfOrCnpj;
//        this.profession = profession;
//        this.salary = salary;
//        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
//
//    public Category getCart() {
//        return category;
//    }

    public void setCart(Category category) {
        this.category = category;
    }
}
