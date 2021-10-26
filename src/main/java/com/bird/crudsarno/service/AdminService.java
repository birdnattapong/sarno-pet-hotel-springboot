package com.bird.crudsarno.service;

import com.bird.crudsarno.entity.Admin;
import com.bird.crudsarno.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }

    public Admin login(Admin admin) {
        return repository.findByUsername(admin.getUsername());
    }
}
