package com.medinastr.spring.crudapp.service;

import com.medinastr.spring.crudapp.dao.EmployeeDAO;
import com.medinastr.spring.crudapp.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    // constructor injection for DAO
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getEmployeesList() {
        return employeeDAO.getEmployeesList();
    }

    @Override
    public Employee findSingleEmployee(int id) {
        return employeeDAO.findSingleEmployee(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
