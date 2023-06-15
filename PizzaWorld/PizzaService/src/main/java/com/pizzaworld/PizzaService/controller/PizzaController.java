package com.pizzaworld.PizzaService.controller;

import com.pizzaworld.PizzaService.domain.PizzaDeliveryAddress;
import com.pizzaworld.PizzaService.domain.PizzaDetails;
import com.pizzaworld.PizzaService.domain.User;
import com.pizzaworld.PizzaService.exception.UserAlreadyFoundException;
import com.pizzaworld.PizzaService.exception.UserNotFoundException;
import com.pizzaworld.PizzaService.service.PizzaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza/service")
public class PizzaController {

    PizzaUserService pizzaUserService;
    ResponseEntity responseEntity;

    @Autowired
    public PizzaController(PizzaUserService pizzaUserService) {
        this.pizzaUserService = pizzaUserService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyFoundException {
        try {
            System.out.println("User Registered");
            responseEntity = new ResponseEntity<>(pizzaUserService.registerUser(user), HttpStatus.CREATED);
        } catch (UserAlreadyFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error!....Server issue", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/{userEmailId}/pizza")
    public ResponseEntity<?> addPizzaToCart(@PathVariable String userEmailId,@RequestBody PizzaDetails pizzaDetails) throws UserNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(pizzaUserService.addPizzaToCart(pizzaDetails, userEmailId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

    @PostMapping("/{userEmailId}/address")
    public ResponseEntity<?> addAddressToUser(@PathVariable String userEmailId,@RequestBody PizzaDeliveryAddress address) throws UserNotFoundException {
        System.out.println("Entered ");
        try {
            System.out.println("Try");
            responseEntity = new ResponseEntity<>(pizzaUserService.addAddressToUser(address, userEmailId), HttpStatus.OK);
            System.out.println("Saved");
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }

@GetMapping("/{userEmailId}")
public ResponseEntity<?> getData (@PathVariable String userEmailId)throws UserNotFoundException{
    System.out.println("Check Controller");
    try {
        System.out.println("Check ");
        responseEntity = new ResponseEntity<>(pizzaUserService.getData(userEmailId), HttpStatus.OK);
        System.out.println(" Working");
    } catch (UserNotFoundException e) {
        throw new UserNotFoundException();
    }
    return responseEntity;
}
}


