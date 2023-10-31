package com.loyallinkup.loyallinkup.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "clients")
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id = 0L;

    private String name;
    private String surname;
    private String phone_number;

    public Client(String name, String surname, String phone_number) {
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
    }

    public Client() {

    }
}
