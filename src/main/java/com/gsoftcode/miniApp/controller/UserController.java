package com.gsoftcode.miniApp.controller;


import com.gsoftcode.miniApp.entity.User;
import com.gsoftcode.miniApp.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User createdUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
     try{
         User user = userService.getUserById(userId);
         return ResponseEntity.ok(user);
     }catch(EntityNotFoundException e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }
    }

    @PutMapping("/{userId}/like")
    public ResponseEntity<?> likeUser(@PathVariable Long userId){
        try{
            return ResponseEntity.ok(new String[]{"User like successfully."});
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
@GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.searchByName(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
