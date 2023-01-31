package com.ztm_proj.ztm_proj.controller;

import com.ztm_proj.ztm_proj.entity.User;
import com.ztm_proj.ztm_proj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        User foundUser = userService.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            // zwróć odpowiedni status HTTP
            return ResponseEntity.ok().build();
        } else {
            // zwróć odpowiedni status HTTP
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
