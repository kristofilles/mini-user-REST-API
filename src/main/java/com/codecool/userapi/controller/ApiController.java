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
    public HttpStatus registerUser(@RequestParam("name") String name, @RequestParam("email") String email,
                                   @RequestParam("password") String password) {
        User user = new User(name, email, password);
        return service.addUser(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public HttpStatus login(@RequestBody Admin adminToLogin) {
        Admin adminInDatabase = adminService.findAdminByName(adminToLogin.getName());
        if (adminToLogin.getPassword().equals(adminInDatabase.getPassword())) {
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.FORBIDDEN;
    }

}