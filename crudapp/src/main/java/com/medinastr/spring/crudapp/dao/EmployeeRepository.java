package com.medinastr.spring.crudapp.dao;

import com.medinastr.spring.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // now we have to refactor all to use JpaRepository methods
}
