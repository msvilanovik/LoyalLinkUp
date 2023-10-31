package com.loyallinkup.loyallinkup.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "clients_events")
@Entity
@Data
public class ClientsEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @OneToOne
    @JoinColumn(name="event_id")
    private Event event;

    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

    public ClientsEvents(Event event, Client client) {
        this.event = event;
        this.client = client;
    }

    public ClientsEvents() {

    }
}
