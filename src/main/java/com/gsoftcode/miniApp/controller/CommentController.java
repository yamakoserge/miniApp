package com.gsoftcode.miniApp.controller;


import com.gsoftcode.miniApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("comments/create")
    public ResponseEntity<?> createComment(@RequestParam Long userId, @RequestParam String postedBy, @RequestBody String content){
        try{
            return ResponseEntity.ok(commentService.createComment(userId,postedBy,content));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @GetMapping("comments{userId}")
    public ResponseEntity<?>getCommentByUserId(@PathVariable Long userId){
        try{
            return ResponseEntity.ok(commentService.getCommentByUserId(userId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong.");
        }
    }
}
