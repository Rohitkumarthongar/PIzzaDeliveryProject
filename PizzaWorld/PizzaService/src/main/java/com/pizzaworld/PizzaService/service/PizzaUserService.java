package com.pizzaworld.PizzaService.service;
import com.pizzaworld.PizzaService.domain.PizzaDeliveryAddress;
import com.pizzaworld.PizzaService.domain.PizzaDetails;
import com.pizzaworld.PizzaService.domain.User;
import com.pizzaworld.PizzaService.exception.UserAlreadyFoundException;
import com.pizzaworld.PizzaService.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface PizzaUserService {

    User registerUser(User user) throws UserAlreadyFoundException;
 User addPizzaToCart(PizzaDetails pizza, String email) throws UserNotFoundException;
  User addAddressToUser(PizzaDeliveryAddress address,String email) throws UserNotFoundException;
  User getData(String email) throws UserNotFoundException;

}
