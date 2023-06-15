package com.pizzaworld.userAuthentication.service;

import com.pizzaworld.userAuthentication.domain.User;
import com.pizzaworld.userAuthentication.exception.UserAlreadyFoundException;
import com.pizzaworld.userAuthentication.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User saveUserDetailsToDataBase(User user) throws UserAlreadyFoundException;
    public User findByUserEmailIdAndUserPassword(String userEmailId,String userPassword) throws UserNotFoundException;

}
