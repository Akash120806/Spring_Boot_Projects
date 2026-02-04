package com.example.AuthSystem.service;

import com.example.AuthSystem.model.Client;
import com.example.AuthSystem.repository.ClientRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClientService {
    private ClientRepo repo;
    private PasswordEncoder passwordEncoder;

    public ClientService(ClientRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;

    }


    public Client register(Client client) {
        if (repo.findByUsername(client.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }
        String pass = passwordEncoder.encode(client.getPassword());
        client.setPassword(pass);
        return repo.save(client);
    }

    public Client login(String username, String password) {
        Optional<Client> client = repo.findByUsername(username);
        if (client.isEmpty()) {
            throw new RuntimeException("/Wrong username");
        }
        Client cli = client.get();
        if (!passwordEncoder.matches(password, cli.getPassword())) {
            throw new RuntimeException("/Wrong password");

        }
        return cli;
    }
}



