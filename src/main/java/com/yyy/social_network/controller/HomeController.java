package com.yyy.social_network.controller;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import com.yyy.social_network.service.PostService;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @ModelAttribute("latest5User")
    Page<User> latest5User(){
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
        return userService.find5LatestUser(pageable);
    }

    @ModelAttribute("latest5TrendingPost")
    Page<Post> find5TrendingPost(){
        return postService.find5TrendingPost();
    }



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
    public ModelAndView showSinglePost(@PathVariable long postId,Principal principal){
        ModelAndView modelAndView = new ModelAndView("single-post");
        Post post = postService.findPostById(postId);
        modelAndView.addObject("post",post);
        User user = userService.findUserByUsername(principal.getName());
        modelAndView.addObject("user",user);
        return modelAndView;
    }




}
