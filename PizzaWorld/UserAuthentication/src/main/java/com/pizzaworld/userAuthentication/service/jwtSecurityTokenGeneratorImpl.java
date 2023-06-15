package com.pizzaworld.userAuthentication.service;

import com.pizzaworld.userAuthentication.domain.User;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class jwtSecurityTokenGeneratorImpl implements SecurityTokenGenrator {

    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken;
        jwtToken= Jwts.builder()
                .setSubject(user.getUserFirstName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretKey")
                .compact();
        Map<String,String> map=new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User Get Login");
        return map;
    }
}
