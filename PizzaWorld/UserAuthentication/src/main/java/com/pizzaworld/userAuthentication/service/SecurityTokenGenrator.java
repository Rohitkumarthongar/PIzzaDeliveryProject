package com.pizzaworld.userAuthentication.service;

import com.pizzaworld.userAuthentication.domain.User;

import java.util.Map;

public interface SecurityTokenGenrator {

        Map<String,String> generateToken(User user);
    }
