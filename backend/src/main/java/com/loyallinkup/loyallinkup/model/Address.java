package com.loyallinkup.loyallinkup.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "addresses")
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Long id = 0L;

    private String city_name;

    private String street_name;

    private String street_number;


    public Address(){

    }

    public Address(String city_name, String street_name, String street_number) {
        this.city_name = city_name;
        this.street_name = street_name;
        this.street_number = street_number;
    }
}
