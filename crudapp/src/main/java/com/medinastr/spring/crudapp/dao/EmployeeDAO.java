package com.medinastr.spring.crudapp.dao;

import com.medinastr.spring.crudapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployeesList();
}
