package com.yyy.social_network.controller;


import com.yyy.social_network.model.Like;
import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import com.yyy.social_network.service.LikeService;
import com.yyy.social_network.service.PostService;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class ApiController {
    @Autowired
    LikeService likeService;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @PostMapping(value = "/api/like/{postId}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Post updateLike(Principal principal,@PathVariable long postId, @RequestBody User user){
        Post post = postService.findPostById(postId);
        User currentUser = userService.findUserByUsername(principal.getName());

        Like like = null;
        try {
            like = likeService.findLikeByUser(currentUser);
        } catch (Exception e){
            System.out.println(e);
        }
        if(like == null){
            like = new Like();
            like.setUser(currentUser);
            likeService.save(like);
            post.getLikeList().add(like);
        } else {
            post.getLikeList().remove(like);
            likeService.delete(like);
        }
        postService.save(post);
        return post;
    }

    @GetMapping(value = "/api/post/{postId}")
    public Post getPostById(@PathVariable long postId){
        Post post = postService.findPostById(postId);
        return post;
    }
}
