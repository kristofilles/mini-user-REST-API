package com.codecool.userapi.controller;

import com.codecool.userapi.model.Admin;
import com.codecool.userapi.model.User;
import com.codecool.userapi.service.AdminService;
import com.codecool.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private UserService service;
    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> showAllUsers() {
        return service.findAllUser();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.GET)
    public HttpStatus deleteUser(@PathVariable("id") long id) {
        service.deleteUser(id);
        if (service.findUserById(id) == null) {
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.FORBIDDEN;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        service.addUser(user);
        if (service.findUserByName(user.getUserName()).equals(user)) {
            return service.findUserByName(user.getUserName());
        }
        return null;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public HttpStatus login(@RequestBody Admin adminToLogin) {
        if (adminService.findAdminByName(adminToLogin.getName()) != null) {
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.FORBIDDEN;
    }

}
