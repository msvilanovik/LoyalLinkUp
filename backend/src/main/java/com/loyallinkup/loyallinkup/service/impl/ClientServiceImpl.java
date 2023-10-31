package com.loyallinkup.loyallinkup.service.impl;

import com.loyallinkup.loyallinkup.model.Client;
import com.loyallinkup.loyallinkup.model.dto.ClientDto;
import org.springframework.stereotype.Service;
import com.loyallinkup.loyallinkup.repo.ClientRepo;
import com.loyallinkup.loyallinkup.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Client> listAll() {
        return this.clientRepo.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepo.findById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        if(clientRepo.findById(id).isPresent()){
            clientRepo.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public Client edit(Long id, ClientDto clientDto) {
        if(clientRepo.findById(id).isPresent()){
            Client client = this.clientRepo.findById(id).get();

            client.setName(clientDto.getName());
            client.setSurname(clientDto.getSurname());
            client.setPhone_number(clientDto.getPhone_number());

            return this.clientRepo.save(client);
        }
        return new Client();
    }

    @Override
    public Client createClient(ClientDto clientDto) {
        return this.clientRepo.save(new Client(clientDto.getName(),clientDto.getSurname(),clientDto.getPhone_number()));
    }
}
