package com.gsoftcode.miniApp.service;


import com.gsoftcode.miniApp.entity.Comment;

import java.util.List;

public interface CommentService {


    Comment createComment(Long userId, String postedBy, String content);

    List<Comment> getCommentByUserId(long userId);

}
