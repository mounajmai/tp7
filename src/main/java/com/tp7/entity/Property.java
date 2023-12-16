package com.tp7.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "id")
    private long id;
    @Column(name = "address")
    private String address;
    @Column(name = "price")
    private double price;

    public Property(long id, String address, double price) {
        this.id = id;
        this.address = address;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

