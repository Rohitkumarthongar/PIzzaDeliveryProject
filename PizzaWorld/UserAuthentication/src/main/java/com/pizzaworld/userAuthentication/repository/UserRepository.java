package com.pizzaworld.userAuthentication.repository;

import com.pizzaworld.userAuthentication.domain.User;
import com.pizzaworld.userAuthentication.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

     User findByUserEmailIdAndUserPassword(String userEmailId,String userPassword) throws UserNotFoundException;
}
