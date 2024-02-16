package com.gsoftcode.miniApp.service;

import com.gsoftcode.miniApp.entity.User;
import com.gsoftcode.miniApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        user.setLikeCount(0);
        user.setViewCount(0);
        user.setDate(new Date());

        return userRepository.save(user);
    }
}
