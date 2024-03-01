package com.gsoftcode.miniApp.service;

import com.gsoftcode.miniApp.entity.Comment;
import com.gsoftcode.miniApp.entity.User;
import com.gsoftcode.miniApp.repository.CommentRepository;
import com.gsoftcode.miniApp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    public Comment createComment(Long userId, String postedBy, String content) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Comment comment = new Comment();
            comment.setUser(optionalUser.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());
            return commentRepository.save(comment);
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }

}
