package com.medinastr.spring.crudapp.rest;

import com.medinastr.spring.crudapp.dao.EmployeeDAO;
import com.medinastr.spring.crudapp.entity.Employee;
import com.medinastr.spring.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployeesList() {
        return employeeService.getEmployeesList();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findSingleEmployee(id);
        if(employee == null) {   // employee not found
            throw new RuntimeException("Employee id not found.");
        }
        return employee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) { // receive the data from json
//        employee = new Employee("Pedro", "Medina", "pedro2024m@medinastr.com");
        employee.setId(0); // force the spring to insert new employee
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }
}
