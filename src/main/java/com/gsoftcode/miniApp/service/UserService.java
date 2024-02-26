package com.gsoftcode.miniApp.service;

import com.gsoftcode.miniApp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    void likeUser(Long userId);
}
