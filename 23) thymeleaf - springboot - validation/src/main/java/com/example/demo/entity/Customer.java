package com.example.demo.entity;

import com.example.demo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "Richiesto!")
    // notation personalizzata
    @CourseCode
    private String courseCode;

    private String firstName;
    // ! questo è molto importante se vogliamo settare un errore, ad esempio se un campo è obbligatorio
    @NotNull(message = "Questo campo è obbligatorio") // Ci da modo poi di mandarlo in vista il messaggio
    @Size(min = 3, message = "Questo campo richiede almeno 3 caratteri")
    @Pattern(regexp = "^[a-zA-Z]", message = "Hai numeri nel tuo cognome?")
    private String lastName = "";

    @NotNull(message = "è richiesto!")
    @Min(value=0)
    @Max(value = 10,message = "Il massimo consentito è 10")
    private Integer freePasses; // Possiamo richiedere una proprietà numerica solo utilizzando Integer, quando verrà compilato il from questa sarà convertita

    //  nelle regex specifico ciò che non è consentito in questo caso sto facendo una negazione! ^
    @Pattern(regexp = "^[0-9]{5}",message = "Solo 5 caratteri numerici consentiti!")
    @NotNull(message = "Campo richiesto!")
    private String postalCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

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
