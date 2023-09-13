package com.cr26code.springboot.cruddemo.dao;

import com.cr26code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    // READ
    Employee getEmployee(int id);
    List<Employee> getListEmployees();
    // SAVE & UPDATE
    Employee saveEmployee(Employee employee);

    // DELETE
    Employee deleteEmployee(int id);
}
