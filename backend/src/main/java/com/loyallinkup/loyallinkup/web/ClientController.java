package com.loyallinkup.loyallinkup.web;
import com.loyallinkup.loyallinkup.model.Client;
import com.loyallinkup.loyallinkup.model.dto.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.loyallinkup.loyallinkup.service.ClientService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/client")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        System.out.println("called");
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.createClient(clientDto);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        Client client = clientService.edit(id, clientDto);
        if (client.getId() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(client);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        boolean deleted = clientService.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

