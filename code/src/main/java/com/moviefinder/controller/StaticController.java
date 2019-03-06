package com.moviefinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaticController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/about")
    public String about() {
        return "about.html";
    }

    @RequestMapping("/movie")
    public String movieInfo() {
        return "movieInfo.html";
    }
}
