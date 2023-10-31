package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.ClientsEvents;
import com.loyallinkup.loyallinkup.model.dto.ClientsEventsDto;

import java.util.List;
import java.util.Optional;

public interface ClientsEventsService {
    List<ClientsEvents> listAll ();
    Optional<ClientsEvents> findById(Long id);

    Boolean deleteById(Long id);

    ClientsEvents editById(Long id, ClientsEventsDto clientsEventsDto);

    ClientsEvents create(ClientsEventsDto clientsEventsDto);

}
