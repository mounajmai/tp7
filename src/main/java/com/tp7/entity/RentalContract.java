package com.tp7.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="RentalContract")

public class RentalContract {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @ManyToOne
        @JoinColumn(name = "property_id") // Nom de la colonne faisant référence à la clé primaire de la table Property
        private Property property;
        @ManyToOne
        @JoinColumn(name = "owner_id") // Nom de la colonne faisant référence à la clé primaire de la table Owner
        private Owner owner;
        @Column(name = "tenant")
        private String tenant;
        @Column(name = "monthlyRent")
        private double monthlyRent;



        public RentalContract(long id, Property property, Owner owner, String tenant, double monthlyRent) {
                this.id = id;
                this.property = property;
                this.owner = owner;
                this.tenant = tenant;
                this.monthlyRent = monthlyRent;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public Property getProperty() {
                return property;
        }

        public void setProperty(Property property) {
                this.property = property;
        }

        public Owner getOwner() {
                return owner;
        }

        public void setOwner(Owner owner) {
                this.owner = owner;
        }

        public String getTenant() {
                return tenant;
        }

        public void setTenant(String tenant) {
                this.tenant = tenant;
        }

        public double getMonthlyRent() {
                return monthlyRent;
        }

        public void setMonthlyRent(double monthlyRent) {
                this.monthlyRent = monthlyRent;
        }
}
