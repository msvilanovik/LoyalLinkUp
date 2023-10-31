package com.loyallinkup.loyallinkup.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "favorites")
@Entity
@Data
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favorites_id;

    @OneToOne
    @JoinColumn(name="business_id")
    private Business business;

    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Favorites(Business business, Client client) {
        this.business= business;
        this.client = client;
    }
    public Favorites(){

    }
}
