package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.Event;
import com.loyallinkup.loyallinkup.model.dto.EventDto;

import java.util.List;

public interface EventService {

        List<Event> listAll();

        Event findById (Long event_id);

        Event create (EventDto eventDto);

        Event edit (Long event_id, EventDto eventDto);

        Boolean delete (Long id);

        List<Event> listAllEventsByBusinessId(Long id);

        List<Event> listAllByTypeOfEvent(String type_of_event);

        List<Event> listAllEventsByCityAndType(String city_name, String event_type);
}
