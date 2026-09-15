package com.example.AuthenticationSystem.repository;

import com.example.AuthenticationSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

     public User findByUsernameAndPassword(String username, String password);
     public User findById(int id);
     public Optional<String> deleteByIdAndUsernameAndPassword(int id, String username, String password);

}
