package com.medinastr.spring.crudapp.rest;

import com.medinastr.spring.crudapp.dao.EmployeeDAO;
import com.medinastr.spring.crudapp.entity.Employee;
import com.medinastr.spring.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
