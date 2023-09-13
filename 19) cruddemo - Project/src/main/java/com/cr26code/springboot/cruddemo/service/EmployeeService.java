package com.cr26code.springboot.cruddemo.service;

import com.cr26code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // READ
    Employee getEmployee(int id);
    List<Employee> getListEmployees();
    // SAVE
    Employee saveEmployee(Employee employee);
    // DELETE
    Employee deleteEmployee(int id);


}
