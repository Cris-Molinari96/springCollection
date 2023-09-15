package com.example.employeesmanagement.rest;

import com.example.employeesmanagement.entities.Employee;
import com.example.employeesmanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeRest {

    private EmployeeService es;

    @Autowired
    EmployeeRest(EmployeeService employeeService) {
        this.es = employeeService;
    }

    @GetMapping("/list")
    public String getListEmployees(Model theModel) {
        List<Employee> listEmployees = es.findAllByOrderByLastName();
        theModel.addAttribute("employees", listEmployees);
        return "employees/list-employee";
    }

    // quest'uri viene attivata dal template list-employee, se si vuole aggiungere un employee, mostra un form(show-form.html)
    @GetMapping("/get-form")
    public String getForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/show-form";
    }

    // quest'end-point riceve il form
    @PostMapping("/validate-form")
    public String validateForm(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employees/show-form";
        } else {
            // * redirect
            es.save(employee);
            return "redirect:/api/employees/list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) { // il webData si porta con se i valori provenienti dalla richiesta http
        // il binder trasforma quel valore in oggetto java
        StringTrimmerEditor strEditor = new StringTrimmerEditor(true); // * il true indica che l'obj str.. deve tagliare tutti gli spazi bianchi dai valori di stringa che edita
        binder.registerCustomEditor(String.class, strEditor);
    }

    @GetMapping("show-form-update")
    public String showFormUpdate(@RequestParam("idEmpl") Integer idEmpl, Model model) {

        Employee employee = es.findById(idEmpl);

        model.addAttribute("empl", employee);

        return "employees/update-form";
    }

    @PostMapping("/update-validate-form")
    public String validateUpdateForm(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employees/update-form";
        } else {
            // * redirect
            es.save(employee);
            return "redirect:/api/employees/list";
        }
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("idEmpl") Integer idEmpl) {
        System.out.println("Sono stato chiamato");
        es.deleteById(idEmpl);
        return "redirect:/api/employees/list";
    }
}
