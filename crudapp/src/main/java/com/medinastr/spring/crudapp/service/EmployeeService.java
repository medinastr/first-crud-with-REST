package com.medinastr.spring.crudapp.service;

import com.medinastr.spring.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeesList();
}
