package com.codecool.userapi.service;

import com.codecool.userapi.model.User;
import com.codecool.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    void addUser(User user) {
        repository.save(user);
    }

    void deleteUser(long id) {
        repository.deleteById(id);
    }

    User findUserById(long id) {
        return repository.findUserById(id);
    }

    List<User> findAllUser() {
        return repository.findAll();
    }

}
