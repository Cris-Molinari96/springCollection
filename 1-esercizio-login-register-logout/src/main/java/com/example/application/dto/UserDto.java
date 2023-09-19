package com.example.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/** ? Possiamo considerare la classe DTO come una classe d'appoggio
 * Le classi dto servono per rappresentare un oggetto di dati
 * Useremo questa classe per ricevere le informazioni sugli Utenti
 * Non comunica con il database
 * Quello che faremo è ricevere le info degli utenti e passarli dalla vista al inserimento nel database */
public class UserDto {

    @NotNull(message = "Campo richiesto!")
    private String username;

    @NotNull(message = "Campo richiesto!")
    private String password;


    @NotNull(message = "Campo richiesto!")
    private String fullname;

    public UserDto() {
    }

    public UserDto(String username, String password,String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
