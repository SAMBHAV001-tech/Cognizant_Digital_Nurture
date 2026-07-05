package com.example.EmployeeManagementSystem.repository.primary;

import com.example.EmployeeManagementSystem.model.primary.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
