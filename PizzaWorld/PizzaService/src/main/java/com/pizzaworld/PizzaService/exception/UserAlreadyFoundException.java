package com.pizzaworld.PizzaService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User Already Registered in Database")
public class UserAlreadyFoundException extends Exception{
}
