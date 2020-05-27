package com.yyy.social_network.controller;


import com.yyy.social_network.model.Comment;
import com.yyy.social_network.model.Like;
import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import com.yyy.social_network.service.CommentService;
import com.yyy.social_network.service.LikeService;
import com.yyy.social_network.service.PostService;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    LikeService likeService;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @PostMapping(value = "/api/like/{postId}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Post updateLike(Principal principal,@PathVariable long postId){
        Post post = postService.findPostById(postId);
        String username = principal.getName();
        User user = userService.findUserByUsername(username);

        Like like = null;
        for(Like each : post.getLikeList())
        {
            boolean isLiked = each.getUser().getUsername().equals(username);
            if(isLiked){
                like = each;
            }
        }
        if(like == null){
            like = new Like();
            like.setUser(user);
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

    @PutMapping(value = "/api/comment/{postId}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> comment(@PathVariable long postId, @RequestBody Comment comment,Principal principal){
        User user = userService.findUserByUsername(principal.getName());
        comment.setUser(user);

        commentService.save(comment);
        Post post = postService.findPostById(postId);
        post.getCommentList().add(comment);
        postService.save(post);
        return post.getCommentList();
    }

    @GetMapping(value = "/api/postDetail/{postId}",produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView postDetail(@PathVariable long postId, Principal principal){
        User user = userService.findUserByUsername(principal.getName());
        Post post = postService.findPostById(postId);
        ModelAndView modelAndView = new ModelAndView("component/modal");


        Date input = post.getCreatedDate();
        LocalDateTime createdTime = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(createdTime,now);
        Long minute = duration.toMinutes();

        modelAndView.addObject("minute",minute);
        modelAndView.addObject("post",post);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @PutMapping(value = "/api/follow/{targetId}")
    public void follow(@PathVariable Long targetId, Principal principal){
        try {
            User user = userService.findUserByUsername(principal.getName());
            User targetUser = userService.findUserByUserId(targetId);

            List<User> followingList = user.getFollowingList();

            if (!followingList.contains(targetUser) && (user.getId() != targetUser.getId())) {
                followingList.add(targetUser);
                targetUser.getFollowersList().add(user);
            }

            userService.save(user);
            userService.save(targetUser);
        } catch (Exception e){
            System.out.println("Loi");;
        }
    }
}
