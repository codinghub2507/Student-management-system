package com.example.lms.controller;

import com.example.lms.dto.LoginRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:5173")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
    
	   if(dto.getUsername().equals("admin") && dto.getPassword().equals("admin"))         {
            return "JWT_TOKEN";
        }

        return "Invalid Credentials";
    }
}