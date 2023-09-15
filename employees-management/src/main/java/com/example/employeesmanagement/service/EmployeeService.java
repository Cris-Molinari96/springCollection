package com.example.employeesmanagement.service;

import com.example.employeesmanagement.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer theId);

    void save(Employee theEmployee);

    void deleteById(Integer theId);

    List<Employee> findAllByOrderByLastName();
}
