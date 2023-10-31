package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.Client;
import com.loyallinkup.loyallinkup.model.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> listAll ();
    Optional<Client> findById(Long id);

    Boolean deleteById(Long id);

    Client edit(Long id, ClientDto clientDto);

    Client createClient(ClientDto clientDto);


}
