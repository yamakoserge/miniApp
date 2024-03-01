package com.gsoftcode.miniApp.service;


import com.gsoftcode.miniApp.entity.Comment;

public interface CommentService {


    Comment createComment(Long userId, String postedBy, String content);
}
