package com.skiShopNN.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "wholesaler")
public class Company {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "сompany_name" )
    private String companyName;

    @Column(name = "country")
    private String country;

    @Column(name = "number_of_employees")
    private String numberOfEmployees;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public Company() {
    }

    public Company(String companyName, String country, String numberOfEmployees, String address, String phone) {
        this.companyName = companyName;
        this.country = country;
        this.numberOfEmployees = numberOfEmployees;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
