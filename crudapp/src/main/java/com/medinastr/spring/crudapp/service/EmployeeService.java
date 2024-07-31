package com.medinastr.spring.crudapp.service;

import com.medinastr.spring.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeesList();

    Employee findSingleEmployee(int id);

    Employee save(Employee employee);

    void delete(int id);
}
