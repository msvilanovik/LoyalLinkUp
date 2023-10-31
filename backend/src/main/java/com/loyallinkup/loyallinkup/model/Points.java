package com.loyallinkup.loyallinkup.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "points")
@Entity
@Data
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long points_id;

    private Integer loyal_points;

    private Integer loyal_awards;

    @OneToOne
    @JoinColumn(name="business_id")
    private Business business;

    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Points(Long points_id, Integer loyal_points, Integer loyal_awards, Client client_id, Business business_id) {
      this.points_id = points_id;
      this.loyal_points = loyal_points;
      this. loyal_awards = loyal_awards;
      this.client = client_id;
      this.business = business_id;
    }

    public Points() {

    }
}
