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

@RestController
public class ApiController {
    @Autowired
    LikeService likeService;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @PostMapping(value = "/api/like/{postId}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLike(@PathVariable long postId, @RequestBody User user){
        Post post = postService.findPostById(postId);
        User currentUser = userService.findUserByUsername(user.getUsername());

        Like like = new Like();
        like.setUser(currentUser);
        likeService.save(like);

        post.getLikeList().add(like);
        postService.save(post);
    }
}
