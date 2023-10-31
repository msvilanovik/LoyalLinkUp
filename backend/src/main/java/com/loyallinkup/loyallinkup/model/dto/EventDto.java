package com.loyallinkup.loyallinkup.model.dto;

import lombok.Data;
import com.loyallinkup.loyallinkup.model.Enum.TypeOfEvent;

import java.time.LocalDateTime;

@Data
public class EventDto {

    private String name;

    private LocalDateTime date_time;

    private TypeOfEvent type_of_event;

    private Integer capacity;

    private Long business_id;

}
