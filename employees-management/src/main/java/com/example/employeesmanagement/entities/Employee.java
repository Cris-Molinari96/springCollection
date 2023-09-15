package com.example.employeesmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    @NotNull(message = "Campo obbligatorio")
    @Pattern(regexp ="^[^0-9]+$",message = "Non inserire numeri")
    private String firstName;

    @Column(name="last_name")
    @NotNull(message = "Campo obbligatorio")
    @Pattern(regexp ="^[^0-9]+$",message = "Non inserire numeri")
    private String lastName;

    @Column(name="email")
    @NotNull(message = "Campo obbligatorio")
    private String email;


    public Employee(Integer id, String name, String surname, String mail){
        this.id = id;
        this.firstName = name;
        this.lastName= surname;
        this.email = mail;
    }

    public Employee(String name, String surname, String mail){
        this.firstName = name;
        this.lastName= surname;
        this.email = mail;
    }

    public Employee() {}

    // get & set
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id.toString() + " " + firstName + " " + lastName + " " + email;
    }

}
