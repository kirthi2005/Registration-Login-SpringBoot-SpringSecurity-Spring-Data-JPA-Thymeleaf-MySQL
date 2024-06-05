package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.web.dto.UserRegistrationDto;

public interface UserService {
    public User save(UserRegistrationDto registrationDto);
}
