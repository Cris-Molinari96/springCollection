package com.cr26code.springboot.cruddemo.rest;

import com.cr26code.springboot.cruddemo.dao.EmployeeDAO;
import com.cr26code.springboot.cruddemo.entity.Employee;
import com.cr26code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ! QUESTA CLASSE è RESPONSABILE DELLE RICHIESTE HTTP

@RestController
@RequestMapping("/test")
public class EmployeeRestController {

/* ! NOT inject DAO interface (use constructor injection)
! questa soluzione di creare un riferimento al dao, è una soluzione poco accetta, in quanto dobbiamo passare tramite i service
! private EmployeeDAO employeeDAO;

Soluziuone non accetta --> public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
*/

    /* * Quello che dobbiamo fare, è fare riferimento al servizio */
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ! expose the end-point

    // read method --> GET
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getListEmployees();
    }

    // save method --> POST
// ! questo metodo si aspetta che quando arriva la richiesta, arrivi anche un tipo dato json che sarà convertito in un oggetto java
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        Employee dbEmpl = employeeService.saveEmployee(employee);
        return dbEmpl;
    }

    // ! update method --> PUT
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbemployee = employeeService.saveEmployee(employee);
        return dbemployee;
    }

    // ! delete method --> DELETE
    @DeleteMapping("/employee/{id}")
    public Employee removeEmployee(@PathVariable int id) {
        Employee empoloyee = employeeService.deleteEmployee(id);
        return empoloyee;
    }
}
