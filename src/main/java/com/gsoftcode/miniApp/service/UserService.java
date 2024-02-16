package com.gsoftcode.miniApp.service;

import com.gsoftcode.miniApp.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(User user);
}
