package com.pizzaworld.userAuthentication.service;

import com.pizzaworld.userAuthentication.domain.User;
import com.pizzaworld.userAuthentication.exception.UserAlreadyFoundException;
import com.pizzaworld.userAuthentication.exception.UserNotFoundException;
import com.pizzaworld.userAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserDetailsToDataBase(User user) throws UserAlreadyFoundException {
if(userRepository.findById(user.getUserEmailId()).isPresent())
{
    throw new UserAlreadyFoundException();
}
        return userRepository.save(user);
    }
    @Override
    public User findByUserEmailIdAndUserPassword(String userEmailId, String userPassword) throws UserNotFoundException {

        System.out.println("User Service Check");
        User user=userRepository.findByUserEmailIdAndUserPassword(userEmailId,userPassword);
        System.out.println("NOt Working ");
        if(user==null)
        {
            System.out.println("LIst Null");
         throw new UserNotFoundException();
        }
        return user;
    }
}
