package com.codecool.userapi.service;

import com.codecool.userapi.model.Admin;
import com.codecool.userapi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private AdminRepository repository;

    @Autowired
    public void setRepository(AdminRepository repository) {
        this.repository = repository;
    }

    public Admin findAdminByName(String name) {
        return repository.findAdminByName(name);
    }
}
