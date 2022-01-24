package com.example.todoapp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

// Single sign on
@Controller
public class SsoController {

    @GetMapping("/logout")
    String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "index";
    }
}
