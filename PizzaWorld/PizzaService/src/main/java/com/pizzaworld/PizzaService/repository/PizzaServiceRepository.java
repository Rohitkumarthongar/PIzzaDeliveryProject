package com.pizzaworld.PizzaService.repository;

import com.pizzaworld.PizzaService.domain.User;
import com.pizzaworld.PizzaService.exception.UserNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaServiceRepository extends MongoRepository<User,String> {
    User findByUserEmailId(String userEmail) throws UserNotFoundException;

}
