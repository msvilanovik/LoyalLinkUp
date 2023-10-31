package com.loyallinkup.loyallinkup.model.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PointsDto {

    private Integer loyal_points;

    private Integer loyal_awards;

    private Long business_id;

    private Long client_id;

}
