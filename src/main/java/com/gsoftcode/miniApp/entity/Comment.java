package com.gsoftcode.miniApp.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String content;

    private Date createdAt;


    private String postedBy;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
