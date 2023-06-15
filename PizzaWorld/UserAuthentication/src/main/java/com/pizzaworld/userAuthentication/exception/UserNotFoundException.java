package com.pizzaworld.userAuthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Saved In DataBase")
public class UserNotFoundException extends Exception {
}
