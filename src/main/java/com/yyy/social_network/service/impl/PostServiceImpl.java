package com.yyy.social_network.service.impl;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.repository.PostRepository;
import com.yyy.social_network.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void create(Post post) {
        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
        post.setCommentQuantity(0L);
        post.setLikeQuantity(0L);
        post.setCreatedDate(currentDate);
        post.setLastModifiedDate(currentDate);
        postRepository.save(post);
    }

    @Override
    public void save(Post post) {
        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
        post.setLastModifiedDate(currentDate);
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }
}
