package com.yyy.social_network.service.impl;

import com.yyy.social_network.model.Comment;
import com.yyy.social_network.repository.CommentRepository;
import com.yyy.social_network.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
