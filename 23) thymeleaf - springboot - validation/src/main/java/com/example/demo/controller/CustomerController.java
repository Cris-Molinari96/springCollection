package com.example.demo.controller;

import com.example.demo.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "fuckcustomer";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult ){
        System.out.println(bindingResult); // --> questo ci permette di verificare se si sono generati degli errori
    if(bindingResult.hasErrors()){
        return "fuckcustomer";
    }else{
        return "customerok";
    }
    }

}
