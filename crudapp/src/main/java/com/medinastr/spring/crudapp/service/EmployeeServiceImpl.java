package com.medinastr.spring.crudapp.service;

import com.medinastr.spring.crudapp.dao.EmployeeRepository;
import com.medinastr.spring.crudapp.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // now we don't need @Transactional for methods

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        // optional for don't give null result
        Optional<Employee> temp = employeeRepository.findById(id);
        Employee employee = null;

        if(temp.isPresent()) {
            employee = temp.get();
        } else {
            throw new RuntimeException("Employee not found.");
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
