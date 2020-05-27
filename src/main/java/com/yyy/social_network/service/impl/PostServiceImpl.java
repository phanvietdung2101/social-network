package com.yyy.social_network.service.impl;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import com.yyy.social_network.repository.PostRepository;
import com.yyy.social_network.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void create(Post post) {
        long currentTime = System.currentTimeMillis();
        Date currentDate = new Date(currentTime);
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

    @Override
    public Post findPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }
        throw new RuntimeException("this post is not found");
    }

    @Override
    public List<Post> findAllByUser(User user) {
        return postRepository.findAllByUser(user);
    }

    @Override
    public Page<Post> find5TrendingPost(){
        Pageable pageable = PageRequest.of(0,5 , Sort.Direction.DESC, "id");
        return postRepository.findAll(pageable);
    }
}
