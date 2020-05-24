package com.yyy.social_network.controller;

import com.yyy.social_network.model.User;
import com.yyy.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView showRegister(){
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/login";
    }
}
