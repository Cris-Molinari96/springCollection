package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// * l'interfaccia ConstraintValidator, ha bisogno di un <Annotazione e un TipoOggetto> per applicare la logica di validazione

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    // questo rappresenta il nostro Oggetto
    private String strValidate;


    @Override
    public void initialize(CourseCode courseCode) {
        strValidate = courseCode.value(); // il metodo accede al valore e lo salviamo nel nostro campo
    }

//! Controlla se qualcosa è valido!
// * qui inseriremo la nostra logica di validazione, questo metodo restituirà true o false in base a ciò che gli viene passato
    // ? il primo parametro del metodo è il codice, testo effettivo che l'utente inserisce nell'html,
    // ? il secondo parametro possiamo usarlo per fornire messaggi di errore se ne abbiamo bisogno

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (theCode != null) {
            result = theCode.startsWith(strValidate);
            System.out.println(strValidate.startsWith(strValidate));
        }else{
            result = true;
        }
        return result;
    }
}
