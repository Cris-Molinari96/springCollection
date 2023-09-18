package com.example.springsecuritymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }


    // * aggiunta get mapping per /leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }
    // * aggiunta get mapping per /systems
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
    // * aggiunta get mapping per /accesso-negato
    @GetMapping("/accesso-negato")
    public String showAccessDenied(){
        return "access-denied";
    }




    // * register form
    @GetMapping("/register")
    public String showFormRegister(){
        return "register";
    }

    /** ! Test
    @PostMapping("/new-user")
    public String insertNewUser(){
    return "redirect:fancy-login";
    }
*/
}
