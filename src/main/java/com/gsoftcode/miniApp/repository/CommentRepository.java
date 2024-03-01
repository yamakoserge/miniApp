package com.gsoftcode.miniApp.repository;

import com.gsoftcode.miniApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Long > {
}
