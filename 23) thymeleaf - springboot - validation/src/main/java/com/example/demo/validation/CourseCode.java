package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
 @Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
// se l'untente non inserisce un valore il valore di default sarà CR
public String value() default "CR";

// se non viene inserito un messaggio sarà preso il valore di default di questo metodo
public String message() default "deve iniziare con CR";

public Class<?>[] groups()default {};
public Class<?extends Payload>[] payload()default {};
}
