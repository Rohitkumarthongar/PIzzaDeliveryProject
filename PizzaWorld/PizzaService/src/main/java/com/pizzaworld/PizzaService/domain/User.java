package com.pizzaworld.PizzaService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document
public class User {
    @Id
    private String userEmailId;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userContNo;
    private List<PizzaDeliveryAddress> userAddress;
    private List<PizzaDetails> pizzaCart;

}
