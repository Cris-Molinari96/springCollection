package com.cr26code.springboot.cruddemo.dao;

import com.cr26code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// ! QUESTA CLASSE è RESPONSABILE DELLE OPERAZIONI CRUD, non gestierà più le transazioni

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    // ! define entity-manager --> esiste solo nelle classi dao
    private EntityManager entityManager;

    // ! define constr
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // ! define READ method
    @Override
    public Employee getEmployee(int id) {
        // * otteniamo l'employee dal metodo find
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    /* questo metodo restituisce tramite il linguaggio JPQL una lista di emplouee*/
    @Override
    public List<Employee> getListEmployees() {

        // ! create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        // ! cattura il risultato della query
        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    // ! define SAVE method
    @Override
    public Employee saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    // ! define UPDATE method
        // * l'update viene gestito dal metodo save, secondo la logica,
        // * per aggiornare un id abbiamo bisogno del campo id, altrimenti sarà un salvataggio
    // ! define DELETE method
    @Override
    public Employee deleteEmployee(int id) {
        // * first - find the employee by id
        Employee employee = entityManager.find(Employee.class,id);

        // * and - remove employee
        entityManager.remove(employee);
        return  employee;
    }
}
