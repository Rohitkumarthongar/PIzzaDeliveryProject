package com.pizzaworld.PizzaService.service;

import com.pizzaworld.PizzaService.domain.PizzaDeliveryAddress;
import com.pizzaworld.PizzaService.domain.PizzaDetails;
import com.pizzaworld.PizzaService.domain.User;
import com.pizzaworld.PizzaService.exception.UserAlreadyFoundException;
import com.pizzaworld.PizzaService.exception.UserNotFoundException;
import com.pizzaworld.PizzaService.repository.PizzaServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaUserServiceImpl implements PizzaUserService {

    User user = null;
    PizzaServiceRepository userRepository;

    @Autowired
    public PizzaUserServiceImpl(PizzaServiceRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyFoundException {
        if (userRepository.findById(user.getUserEmailId()).isPresent()) {
            throw new UserAlreadyFoundException();
        }
        return userRepository.save(user);
    }


    @Override
    public User addPizzaToCart(PizzaDetails pizza, String email) throws UserNotFoundException {
    if(userRepository.findById(email).isEmpty())
    {
        throw new UserNotFoundException();
    }
    User user=userRepository.findByUserEmailId(email);
    if(user.getPizzaCart()==null)
    {
        user.setPizzaCart(List.of(pizza));
    }
    else {
        List<PizzaDetails> pizzaDetailsList=user.getPizzaCart();
        pizzaDetailsList.add(pizza);
        user.setPizzaCart(pizzaDetailsList);
    }
        return userRepository.save(user);
    }

    @Override
    public User addAddressToUser(PizzaDeliveryAddress address, String email) throws UserNotFoundException {
        System.out.println("Entered IN Service");
    if(userRepository.findById(email).isEmpty())
    {
        System.out.println("Id Not Found ");
        throw new UserNotFoundException();
    }
        System.out.println("Check user Id ");
    User user=userRepository.findByUserEmailId(email);
        System.out.println("ID Checked ");
    if(user.getUserAddress()==null)
    {
        System.out.println("Check Address List");
        user.setUserAddress(List.of(address));
    }
    else {
        List<PizzaDeliveryAddress> addressList=user.getUserAddress();
        addressList.add(address);
        System.out.println("Added to List");
        user.setUserAddress(addressList);
    }
        System.out.println("save to User ");
        return userRepository.save(user);
    }

    @Override
    public User getData(String email) throws UserNotFoundException {
        System.out.println("Check service");
   if(userRepository.findById(email).isEmpty())
   {
       System.out.println("Exception");
               throw new UserNotFoundException();
    }
        System.out.println("List Is here");
        return (User) userRepository.findAll();
    }
}
