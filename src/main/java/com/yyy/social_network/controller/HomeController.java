package com.yyy.social_network.controller;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import com.yyy.social_network.service.PostService;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;



    @GetMapping(value = {"/","/home"})
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("new-feed");
        List<Post> postList = postService.findAll();
        modelAndView.addObject("postList", postList);
        return modelAndView;
    }

    @GetMapping("/profile")
    public String showProfile(Principal principal){
        String username = principal.getName();

        return "redirect:/profile/" + username;
    }

    @GetMapping("/profile/{username}")
    public ModelAndView showProfile(@PathVariable String username){
        ModelAndView modelAndView = new ModelAndView("profile");

        User user = userService.findUserByUsername(username);
        modelAndView.addObject("user",user);

        List<Post> userPostList = postService.findAllByUser(user);
        modelAndView.addObject("userPostList",userPostList);
        return modelAndView;
    }

    @GetMapping("/post/{postId}")
    public ModelAndView showSinglePost(@PathVariable long postId){
        ModelAndView modelAndView = new ModelAndView("single-post");
        Post post = postService.findPostById(postId);
        modelAndView.addObject("post",post);
        return modelAndView;
    }




}
