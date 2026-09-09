package com.example.AuthenticationSystem.Service;

import com.example.AuthenticationSystem.Model.User;
import com.example.AuthenticationSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Register user
    public User register(User user) {
        return repo.save(user);
    }

    // Login user
    public User login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }

    //find all user
     public  List<User >findall(){
        return repo.findAll();
    }
    public User findid(int id){
        return repo.findById(id);
    }

}
