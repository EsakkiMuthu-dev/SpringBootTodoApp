package com.firstwebapp.SpringTodo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String userName,String password)
    {
        boolean isUserNameValid = userName.equalsIgnoreCase("bharathi");
        boolean isPasswordValid = password.equalsIgnoreCase("bharu");
        return  isPasswordValid && isUserNameValid;
    }
}
