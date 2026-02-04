package com.example.AuthSystem.repository;

import com.example.AuthSystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
        Optional <Client>  findByUsername(String username);
        public Client findById(int id);
}
