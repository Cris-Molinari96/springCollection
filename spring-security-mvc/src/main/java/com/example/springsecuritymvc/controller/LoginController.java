package com.example.springsecuritymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * 1) Questo metodo gestisce la login page
     * * renderizzato dalla classe config su quest'end-point, e a sua volta lo rimanda alla pagina di login
     */
    @GetMapping("mostra-login")
    public String getLogin() {

//        return "plain-login";
        return "fancy-login";

    }
}
