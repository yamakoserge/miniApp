package com.gsoftcode.miniApp.service;

import com.gsoftcode.miniApp.entity.User;
import com.gsoftcode.miniApp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setViewCount(user.getViewCount() + 1);
            return userRepository.save(user);
        }else {
            throw new EntityNotFoundException("User not found");
        }
    }

    public void likeUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setLikeCount(user.getLikeCount() + 1);
            userRepository.save(user);
        }else {
            throw new EntityNotFoundException("User not found with id" + userId);
        }
    }

    public List<User> searchByName(String name){

        return userRepository.findAllByNameContaining(name);
    }
}
