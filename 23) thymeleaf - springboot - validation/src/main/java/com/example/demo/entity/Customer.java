package com.example.demo.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;
    // ! questo è molto importante se vogliamo settare un errore, ad esempio se un campo è obbligatorio
    @NotNull(message = "Questo campo è obbligatorio")
    @Size(min = 4, message = "Questo campo è obbligatorio")
    private String lastName = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
