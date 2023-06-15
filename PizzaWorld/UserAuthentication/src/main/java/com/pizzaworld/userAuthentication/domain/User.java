package com.pizzaworld.userAuthentication.domain;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
     @Id
     private String userEmailId;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String userContNo;
}
