package com.medinastr.spring.crudapp.dao;

import com.medinastr.spring.crudapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    // constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // employees list method
    @Override
    public List<Employee> getEmployeesList() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findSingleEmployee(int id) {
        Employee dbEmployee = entityManager.find(Employee.class, id);
        return dbEmployee;
    }

    @Override
    public Employee save(Employee employee) {  // save and return the dbEmployee
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        Employee dbEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(dbEmployee);
    }
}
