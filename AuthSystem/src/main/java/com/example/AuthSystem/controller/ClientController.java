package com.example.AuthSystem.controller;
import com.example.AuthSystem.model.Client;
import  com.example.AuthSystem.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/register")
    public String clientRegister(@Valid @RequestBody Client client) {
         clientService.register(client);
         return "success";

    }
    @PostMapping("/login")
    public Client login(@RequestParam String username, @RequestParam String password) {
        return clientService.login(username, password);
    }

}
