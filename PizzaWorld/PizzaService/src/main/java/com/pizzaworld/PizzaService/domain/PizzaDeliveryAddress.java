package com.pizzaworld.PizzaService.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PizzaDeliveryAddress {
    private String landMark;
    private String city;
    private String state;
    private String pinCode;
}
