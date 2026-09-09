package com.example.AuthenticationSystem.repository;

import com.example.AuthenticationSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

     public User findByUsernameAndPassword(String username, String password);
     public User findById(int id);
}
