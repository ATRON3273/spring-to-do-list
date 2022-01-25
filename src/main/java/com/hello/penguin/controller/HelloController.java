package com.hello.penguin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{
    // main/resources/templates/hello.html
    @RequestMapping("/hello")
    public String helloMain()
    {
        return "hello";
    }
}
