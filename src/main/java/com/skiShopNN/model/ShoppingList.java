package com.skiShopNN.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "id",nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ski_id")
    private Ski ski;

    @Column(name = "count")
    private Integer count;

    @Column(name = "purchase_day")
    private String purchaseDay;

    @Column(name = "total_price")
    private Integer totalPrace;

    public ShoppingList() {
    }

    public ShoppingList(Customer customer, Ski ski, Integer count, String purchaseDay, Integer totalPrace) {
        this.customer = customer;
        this.ski = ski;
        this.count = count;
        this.purchaseDay = purchaseDay;
        this.totalPrace = totalPrace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ski getSki() {
        return ski;
    }

    public void setSki(Ski ski) {
        this.ski = ski;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPurchaseDay() {
        return purchaseDay;
    }

    public void setPurchaseDay(String purchaseDay) {
        this.purchaseDay = purchaseDay;
    }

    public Integer getTotalPrace() {
        return totalPrace;
    }

    public void setTotalPrace(Integer totalPrace) {
        this.totalPrace = totalPrace;
    }
}
