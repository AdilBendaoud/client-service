package com.example.client.controllers;

import com.example.client.entities.Client;
import com.example.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Client client) {
        service.addClient(client);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("this is test for trigger");
    }
}