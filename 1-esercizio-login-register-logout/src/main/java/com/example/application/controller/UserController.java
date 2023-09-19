package com.example.application.controller;

import com.example.application.dto.UserDto;
import com.example.application.model.User;
import com.example.application.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * ! utilizzo Model per passare l'oggetto utente alla vista
     * ! Principal rappresenta l'utente autenticato
     */
    @GetMapping("/home")
    public String getHome(Model model, Principal principal) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetails", userDetails);
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("userDto", userDto);
        return "login";
    }

    @PostMapping("/register")
    public String registerSave(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult,Model model) {

        if (bindingResult.hasErrors()) {
            return "/register";
        } else {
            User user = userService.findByUsername(userDto.getUsername());
            if (user != null) {
                model.addAttribute("userexists",user);
                return"/register";
            } else {
                // in questo modo stiamo passando un attributo alla pagina di login in modo da visualizzare in caso di register success
                String strSucces = "Registrazione effettuata";
                model.addAttribute("registerSuccess",strSucces);
                userService.save(userDto);
                return "login";
            }

//! con la redirect abilitiamo il messaggio di avvenuta registrazione, in quanto stiamo rimandando indietro il from con un parametro di success,
//! il quale verrà catturato da th:param in register.html
        }
    }

    @PostMapping("/process-form-login")
    public String login(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {

        // qui abbiamo aggiunto valid modelAttribute
        if (bindingResult.hasErrors()) {
            return "redirect:/login?error";
        }

        return null; // prima c'era "register"
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor strEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, strEditor);
    }
}
