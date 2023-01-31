package com.ztm_proj.ztm_proj.service;

import com.ztm_proj.ztm_proj.entity.User;
import com.ztm_proj.ztm_proj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}