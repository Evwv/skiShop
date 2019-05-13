package com.skiShopNN.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
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

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "final_date")
    private String finalDate;

    @Column(name = "count")
    private String count;

    public Reservation() {
    }

    public Reservation(Customer customer, Ski ski, String startDate, String finalDate, String count) {
        this.customer = customer;
        this.ski = ski;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.count = count;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
