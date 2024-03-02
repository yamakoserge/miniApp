package com.gsoftcode.miniApp.repository;

import com.gsoftcode.miniApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Long > {

    List<Comment> findByUserId(Long userId);
}
