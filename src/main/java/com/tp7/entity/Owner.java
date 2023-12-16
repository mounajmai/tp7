package com.tp7.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")

    private String name;
    @Column(name = "contactInformation")
    private String contactInformation;

    public Owner(){

    }
    public Owner(long id,String name,String contactInformation){
        this.id=id;
        this.name=name;
        this.contactInformation=contactInformation;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }


}