package com.kry.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * Handles the user authentication
 */
public class LoginController {

    @GetMapping("/")
    public String index() {

        return "redirect:/services/";
    }
}
