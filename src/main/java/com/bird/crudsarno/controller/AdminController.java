package com.bird.crudsarno.controller;

import com.bird.crudsarno.entity.Admin;
import com.bird.crudsarno.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        admin.setPassword(getEncodedPassword(admin.getPassword()));
        return service.saveAdmin(admin);
    }

    private String getEncodedPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        Admin existAdmin = service.login(admin);

        if (existAdmin == null) {
            HashMap<String, String> map = new HashMap<>();
            map.put("notfound", "Username หรือ Password ไม่ถูกต้อง กรุณาลองใหม่อีกครั้ง");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            String decryptedPassword = getDecodedPassword(existAdmin.getPassword());

            if (decryptedPassword.equals(admin.getPassword())) {
                return new ResponseEntity<>(existAdmin, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    private String getDecodedPassword(String encryptedPassword) {
        return new String(Base64.getMimeDecoder().decode(encryptedPassword));
    }
}
