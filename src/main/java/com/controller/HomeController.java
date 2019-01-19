package com.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController{

    private static final String PATH = "/home";

    @RequestMapping(value = PATH)
    public String home(){

        return "index";
    }

}
