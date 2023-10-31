package com.loyallinkup.loyallinkup.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "reviews")
@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;

    private LocalDateTime date_time;

    private String comment;

    private Integer grade;

    @ManyToOne
    @JoinColumn(name="business_id")
    private Business business;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    public Review(){

    }
    public Review(LocalDateTime date_time, String comment, Integer grade, Client client, Business business, Event event) {
     this.date_time = date_time;
     this.comment = comment;
     this.grade = grade;
     this.client = client;
     this.business = business;
     this.event = event;
    }

}