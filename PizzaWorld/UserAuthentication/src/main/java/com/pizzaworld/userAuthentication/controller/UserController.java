package com.pizzaworld.userAuthentication.controller;

import com.pizzaworld.userAuthentication.domain.User;
import com.pizzaworld.userAuthentication.exception.UserAlreadyFoundException;
import com.pizzaworld.userAuthentication.exception.UserNotFoundException;
import com.pizzaworld.userAuthentication.service.SecurityTokenGenrator;
import com.pizzaworld.userAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/pizza/Auth")
public class UserController {
    ResponseEntity responseEntity;
    UserService userService;
    SecurityTokenGenrator securityTokenGenrator;
@Autowired
    public UserController(UserService userService, SecurityTokenGenrator securityTokenGenrator) {
        this.userService = userService;
        this.securityTokenGenrator = securityTokenGenrator;
    }
    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUserDetailsToDataBase(@RequestBody User user) throws UserAlreadyFoundException {
try{
    responseEntity=new ResponseEntity(userService.saveUserDetailsToDataBase(user), HttpStatus.CREATED);
} catch (UserAlreadyFoundException e) {
    throw new RuntimeException(e);
}catch (Exception e)
{
    responseEntity =new ResponseEntity("Internal server Error",HttpStatus.INTERNAL_SERVER_ERROR);
}
   return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException
    {
        System.out.println("Im In Login User");
        Map<String,String> map=null;
        try{
            System.out.println("Ohk Fine Try Block Is Wokkring ");
            User userObj=userService.findByUserEmailIdAndUserPassword(user.getUserEmailId(),user.getUserPassword());
            System.out.println("These are User  ");
            if(userObj.getUserEmailId().equals(user.getUserEmailId()) && userObj.getUserPassword().equals(user.getUserPassword())){

                System.out.println("Mow i m in Try Block of Login");
                map=securityTokenGenrator.generateToken(user);
                System.out.println("After map");
            }
            responseEntity=new ResponseEntity(map,HttpStatus.OK);
            System.out.println("After map again checked");
        }catch (UserNotFoundException e)
        {
            System.out.println("Check Exception");
            throw new UserNotFoundException();
        } catch (Exception e)
        {
            System.out.println("Server out");
            responseEntity =new ResponseEntity("Server Down pls Take Some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
