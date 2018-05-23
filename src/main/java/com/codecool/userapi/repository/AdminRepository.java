package com.codecool.userapi.repository;

import com.codecool.userapi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByName(String name);

}
