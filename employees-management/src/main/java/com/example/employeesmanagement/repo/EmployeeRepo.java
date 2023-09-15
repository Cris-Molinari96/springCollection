package com.example.employeesmanagement.repo;

import com.example.employeesmanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByOrderByLastName(); // ci basta firmare il metodo in questo modo per ottenere una lista di employee ordinata (asc)
// ! per più info consulta --> jpa query methods
}
