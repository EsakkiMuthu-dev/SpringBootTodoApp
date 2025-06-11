package com.firstwebapp.SpringTodo.controller;

import com.firstwebapp.SpringTodo.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService)
    {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        logger.info("User tries to Login: ");
        return "Login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public  String goToWelcome(@RequestParam String name , @RequestParam String password, ModelMap modelMap)
    {
        modelMap.put("name",name);
        if(this.authenticationService.authenticate(name,password))
        {
            return "Welcome";
        }
        modelMap.put("errorMsg","Your credentials is invalid");
        return "Login";
    }

}
