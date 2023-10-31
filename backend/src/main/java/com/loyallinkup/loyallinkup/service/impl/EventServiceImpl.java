package com.loyallinkup.loyallinkup.service.impl;

import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.Enum.TypeOfEvent;
import com.loyallinkup.loyallinkup.model.Event;
import com.loyallinkup.loyallinkup.model.dto.EventDto;
import com.loyallinkup.loyallinkup.service.BusinessService;
import com.loyallinkup.loyallinkup.service.EventService;
import org.springframework.stereotype.Service;
import com.loyallinkup.loyallinkup.repo.EventRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final BusinessService businessService;

    public EventServiceImpl(EventRepo eventRepo, BusinessService businessService) {
        this.eventRepo = eventRepo;
        this.businessService = businessService;
    }

    @Override
    public List<Event> listAll() {
        return this.eventRepo.findAll();
    }

    @Override
    public Event findById(Long event_id) {
        return this.eventRepo.findById(event_id).get();
    }

    @Override
    public Event create(EventDto eventDto) {
        Business business = this.businessService.findById(eventDto.getBusiness_id());
        Event event1 = new Event(eventDto.getName(), eventDto.getDate_time(), eventDto.getType_of_event(),
                eventDto.getCapacity(), business);

        return eventRepo.save(event1);
    }

    @Override
    public Event edit(Long event_id, EventDto eventDto) {

        Event event = this.eventRepo.findById(event_id).get();
        Business business = this.businessService.findById(eventDto.getBusiness_id());

        event.setId(event_id);
        event.setName(event.getName());
        event.setDate_time(event.getDate_time());
        event.setType_of_event(event.getType_of_event());
        event.setCapacity(event.getCapacity());
        event.setBusiness(business);

        return this.eventRepo.save(event);
    }

    @Override
    public Boolean delete(Long id) {
        if(this.eventRepo.findById(id).isPresent()){
            this.eventRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public List<Event> listAllEventsByBusinessId(Long id) {
        return this.eventRepo.findAllByBusiness_Id(id);

    }

    @Override
    public List<Event> listAllByTypeOfEvent(String type_of_event) {
        return eventRepo.findAllByType(TypeOfEvent.valueOf(type_of_event));
    }

    @Override
    public List<Event> listAllEventsByCityAndType(String city_name, String event_type) {

        List<Business> businessesFiltered = this.businessService.findByCity(city_name);

        List<Event> eventsFilteredByType = this.listAllByTypeOfEvent(event_type);

        List<Event> finalEvents = eventsFilteredByType.stream()
                .filter(event -> businessesFiltered.stream()
                        .anyMatch(business -> business.equals(event.getBusiness())))
                .collect(Collectors.toList());


        return finalEvents;
    }
}
