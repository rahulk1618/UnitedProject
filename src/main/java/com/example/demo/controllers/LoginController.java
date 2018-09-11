package com.example.demo.controllers;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login")
    public ModelAndView login() {

        return new ModelAndView("login");

    }
}