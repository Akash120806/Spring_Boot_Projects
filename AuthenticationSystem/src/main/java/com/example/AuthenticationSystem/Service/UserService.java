package com.example.AuthenticationSystem.Service;

import com.example.AuthenticationSystem.Model.User;
import com.example.AuthenticationSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Register user
    public void register(User user) {
        repo.save(user);
    }

    // Login user
    public User login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}
