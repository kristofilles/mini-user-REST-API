package com.codecool.userapi.controller;

import com.codecool.userapi.model.User;
import com.codecool.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> showAllUsers() {
        return service.findAllUser();
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public User showOneUser(@PathVariable("id") long id) {
        return service.findUserById(id);
    }

    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        service.deleteUser(id);
        return "deleted";
    }

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam("name") String name, @RequestParam("email") String email) {
        User user = new User(name, email);
        service.addUser(user);
        return "user saved";
    }

}
