package com.cr26code.springboot.cruddemo.service;

import com.cr26code.springboot.cruddemo.dao.EmployeeDAO;
import com.cr26code.springboot.cruddemo.entity.Employee;
import com.cr26code.springboot.cruddemo.exception.TestGlobalException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// ! QUESTA CLASSE è RESPONSABILE DELLA LOGICA DELL'APPLICAZIONE, SI FRAPPONE AL CENTRO TRA CONTROLLER E DAO

/* * Quello che facciamo nei service è, delegare le chiamate al DAO.
!Spring grazie alla notazione registra automaticamente questo componente */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // * inject dao, il quale riferimento sarà utile per richiamare i metodi definiti della classe, per le operazioni CRUD
    private EmployeeDAO employeeDAO;
    // ? constrct
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee getEmployee(int id) {
        boolean empolyeeFound = false;
        for (Employee employee : employeeDAO.getListEmployees()) {
            if (employee.getId() == id) {
                empolyeeFound = true;
                break;
            }
        }
        if (!empolyeeFound || id < 0) {
            throw new TestGlobalException("Utente non trovato");
        }
        Employee em = employeeDAO.getEmployee(id);
        return em;
    }

    @Override
    public List<Employee> getListEmployees() {
        return employeeDAO.getListEmployees();
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public Employee deleteEmployee(int id) {
        Employee employee = employeeDAO.deleteEmployee(id);
        return employee;
    }


}
