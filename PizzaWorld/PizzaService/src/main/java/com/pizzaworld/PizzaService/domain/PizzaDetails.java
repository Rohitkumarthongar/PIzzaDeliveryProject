package com.pizzaworld.PizzaService.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PizzaDetails {
    private String Pizza_Title;
      private String Pizza_Size;
    private int Pizza_Price;
}
