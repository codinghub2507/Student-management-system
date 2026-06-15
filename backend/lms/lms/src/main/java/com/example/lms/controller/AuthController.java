package com.example.lms.controller;

import com.example.lms.dto.LoginRequestDTO;
import com.example.lms.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:5173")
public class AuthController {

    @Autowired
    private JwtService jwtService;
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
    
	   if(dto.getUsername().equals("admin") && dto.getPassword().equals("admin"))         {
            return jwtService.generateJwtToken(dto.getUsername());
        }

        return "Invalid Credentials";
    }
}