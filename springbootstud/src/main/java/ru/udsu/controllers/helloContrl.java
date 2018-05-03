package ru.udsu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloContrl {
    @RequestMapping("/")
    public String helloCon(){
        return "hello-world";
    }
}
