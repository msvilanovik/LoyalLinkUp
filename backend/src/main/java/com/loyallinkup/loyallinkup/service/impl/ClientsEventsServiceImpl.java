package com.loyallinkup.loyallinkup.service.impl;

import com.loyallinkup.loyallinkup.model.ClientsEvents;
import com.loyallinkup.loyallinkup.model.dto.ClientsEventsDto;
import com.loyallinkup.loyallinkup.service.ClientsEventsService;
import org.springframework.stereotype.Service;
import com.loyallinkup.loyallinkup.repo.ClientRepo;
import com.loyallinkup.loyallinkup.repo.ClientsEventsRepo;
import com.loyallinkup.loyallinkup.repo.EventRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsEventsServiceImpl implements ClientsEventsService {

    private final ClientRepo clientRepo;

    private final EventRepo eventRepo;

    private final ClientsEventsRepo clientsEventsRepo;

    public ClientsEventsServiceImpl(ClientRepo clientRepo, EventRepo eventRepo, ClientsEventsRepo clientsEventsRepo) {
        this.clientRepo = clientRepo;
        this.eventRepo = eventRepo;
        this.clientsEventsRepo = clientsEventsRepo;
    }

    @Override
    public List<ClientsEvents> listAll() {
        return clientsEventsRepo.findAll();
    }

    @Override
    public Optional<ClientsEvents> findById(Long id) {
        return this.clientsEventsRepo.findById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if(this.clientsEventsRepo.findById(id).isPresent()){
            clientsEventsRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public ClientsEvents editById(Long id, ClientsEventsDto clientsEventsDto) {
        if(clientsEventsRepo.findById(id).isPresent()){
            ClientsEvents clientsEvents = this.clientsEventsRepo.findById(id).get();

            clientsEvents.setClient(this.clientRepo.findById(clientsEventsDto.getClient_id()).get());
            clientsEvents.setEvent(this.eventRepo.findById(clientsEventsDto.getEvent_id()).get());

            return this.clientsEventsRepo.save(clientsEvents);
        }
        return new ClientsEvents();
    }

    @Override
    public ClientsEvents create(ClientsEventsDto clientsEventsDto) {
        return this.clientsEventsRepo.save(new ClientsEvents(this.eventRepo.findById(clientsEventsDto.getEvent_id()).get(),this.clientRepo.findById(clientsEventsDto.getClient_id()).get()));

    }
}
