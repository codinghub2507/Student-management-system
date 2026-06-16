package com.example.lms.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;
import java.util.Date;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String key;
    public String generateJwtToken(String username){
        String token= 

        Jwts.builder()
        .setSubject(username) //payload
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
        .signWith(Keys.hmacShaKeyFor(key.getBytes()))
        .compact();

        return token;
    }

    public boolean isValid(String token){
        try{
            Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(key.getBytes()))
            .build()
            .parseSignedClaims(token);

            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String getUsername(String token){
        return Jwts.parser()
        .verifyWith(Keys.hmacShaKeyFor(key.getBytes()))
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    } 
}
