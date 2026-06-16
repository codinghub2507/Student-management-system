package com.example.lms.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.example.lms.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Component
public class JwtFilter extends OncePerRequestFilter{
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterchain)throws ServletException,IOException{
        String header=request.getHeader("Authorization");

        if(header!=null && header.startsWith("Bearer ")){
            String token = header.substring(7);

            if(jwtService.isValid(token)){
                String username = jwtService.getUsername(token);
            

            UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(username,null,Collections.emptyList());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }
    filterchain.doFilter(request,response);
}
}