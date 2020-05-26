package com.yyy.social_network.controller;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import com.yyy.social_network.service.PostService;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UploadController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/upload")
    public ModelAndView showUpload(){
        ModelAndView modelAndView = new ModelAndView("photo_upload");
        modelAndView.addObject("post",new Post());
        return modelAndView;
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute Post post, Principal principal) throws Exception {
        String username = principal.getName();
        User user =  userService.findUserByUsername(username);
        if(user == null){
            return "redirect:/login";
        }
        post.setUser(user);
        postService.create(post);
        return "redirect:/";
    }

}
