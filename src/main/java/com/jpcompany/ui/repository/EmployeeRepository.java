package com.jpcompany.ui.repository;

import com.jpcompany.ui.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
