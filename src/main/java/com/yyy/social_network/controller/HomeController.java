package com.yyy.social_network.controller;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.service.PostService;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("new-feed");
        List<Post> postList = postService.findAll();
        modelAndView.addObject("postList", postList);
        return modelAndView;
    }


}
