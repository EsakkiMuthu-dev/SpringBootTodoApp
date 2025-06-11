package com.firstwebapp.SpringTodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello()
    {
        return " Hello ! How are you?";
    }

    @ResponseBody
    @RequestMapping("/say-htmlhello")
    public String sayHelloViaHTMl()
    {
        return """
                <html><head><title>First Spring Webapp</title></head>
                <body>
                <marquee><h1> Hello Guys!!!!!!!</marquee>
                </body>
                </html>
                """;
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp()
    {
        return "SayHello";
    }
}
