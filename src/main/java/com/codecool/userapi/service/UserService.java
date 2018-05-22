package com.codecool.userapi.service;

import com.codecool.userapi.model.User;
import com.codecool.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public HttpStatus addUser(User user) {
        repository.save(user);
        return HttpStatus.ACCEPTED;
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }

    public User findUserById(long id) {
        return repository.findUserById(id);
    }

    public List<User> findAllUser() {
        return repository.findAll();
    }

    public User findUserByName(String name) {return repository.findUserByUserName(name);}

}
