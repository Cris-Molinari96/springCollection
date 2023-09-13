package com.cr26code.springboot.cruddemo.dao;

import com.cr26code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// ! Questa classe viene considerata come una repository in quanto estende la classe JpaRepo..
@RepositoryRestResource(path = "fucking-employees")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // ! in questo modo stiamo ereditando tutti i metodi CRUD senza scrivere alcun codice
}
