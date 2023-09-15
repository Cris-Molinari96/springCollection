package com.example.employeesmanagement.service.impl;

import com.example.employeesmanagement.entities.Employee;
import com.example.employeesmanagement.repo.EmployeeRepo;
import com.example.employeesmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    // Vediamo se non serve che inietto la dipendenza employeeRepo
    @Autowired
    EmployeeServiceImpl(EmployeeRepo theEmployeeRepo){
        this.employeeRepo = theEmployeeRepo;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Integer theId) {
        return employeeRepo.findById(theId).get();
    }

    @Override
    public void save(Employee theEmployee) {
        employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(Integer theId) {
    employeeRepo.deleteById(theId);
    }

    @Override
    public List<Employee> findAllByOrderByLastName() {
        return employeeRepo.findAllByOrderByLastName();
    }
}
