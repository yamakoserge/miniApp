package com.gsoftcode.miniApp.controller;


import com.gsoftcode.miniApp.entity.User;
import com.gsoftcode.miniApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/posts")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User createdUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}
