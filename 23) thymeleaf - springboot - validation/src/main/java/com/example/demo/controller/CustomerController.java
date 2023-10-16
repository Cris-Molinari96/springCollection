package com.example.demo.controller;

import com.example.demo.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "fuckcustomer"; // spring boot si auto-configurerà da solo perché nel file callPath viene aggiunto thyme e si comporterà di conseguenza andando a cercare un template di nome "fuckcustomer"
    }

    // è possibile quindi aggiungere al model più attributi e richiamarli nella pagina html, ma in un metodo possiamo passare solo 1 attributo

    @GetMapping("/date")
    public String showData(Model model) {
        model.addAttribute("date", new java.util.Date());
        return "date"; // spring boot si auto-configurerà da solo perché nel file callPath viene aggiunto thyme e si comporterà di conseguenza andando a cercare un template di nome "fuckcustomer"
    }


    // ! Il modelAttribute è quello che si porta dietro i dati inseriti nel form, ed è tramite quest'oggetto che passiamo i dati dalla vista
    // ! al metodo /processForm
    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult // ! --> Quest'oggetto è responsabile di catturare tutti gli errori
            //! che vengono generati per quanto riguarda l'obj customer, vedi screenUtili
    ) {
//        System.out.println("BindingResult.toString() | " +bindingResult.toString() + "|"); // --> questo ci permette di verificare se si sono generati degli errori e quanti stampando il numero
//        System.out.println("Catch the error | "+bindingResult + " |"); // questo stampa il tipo di errore generato dai campi d'input
        if (bindingResult.hasErrors()) {
            return "fuckcustomer";
        } else {
            return "customerok"; // ! e se non sono stati registrati degli errori, allora andremo al customerok.html, ricordiamo che stiamo utilizzando
            // ! ModelAttribute e ci permette di passare in questo caso l'oggetto customer al template
        }
    }

    // ! quello che faremo è aggiungere la notazione @InitBinder responsabile della conversione dei dati inviati da una richiesta http
    // ! il quale stringTrimmerEditor rimuoverà ogni spazio bianchi dalla stringa che edita(LastName)
    // ! questo controllo viene applicata all'intera classe!
    @InitBinder
    public void initBinder(WebDataBinder binder){ // il webData si porta con se i valori provenienti dalla richiesta http
        // il binder trasforma quel valore in oggetto java
        StringTrimmerEditor strEditor = new StringTrimmerEditor(true); // * il true indica che l'obj str.. deve tagliare tutti gli spazi bianchi dai valori di stringa che edita
        binder.registerCustomEditor(String.class, strEditor);
    }



}
