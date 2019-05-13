package com.skiShopNN.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Ski")
public class Ski {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "length")
    private String length;

    @Column(name = "firm")
    private String firm;

    @Column(name = "price")
    private Integer price;

    public Ski() {
    }

    public Ski(String name, String length, String firm, Integer price) {
        this.name = name;
        this.length = length;
        this.firm = firm;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLength() {
        return length;
    }

    public String getFirm() {
        return firm;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setFirm(String rigidity) {
        this.firm = firm;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
