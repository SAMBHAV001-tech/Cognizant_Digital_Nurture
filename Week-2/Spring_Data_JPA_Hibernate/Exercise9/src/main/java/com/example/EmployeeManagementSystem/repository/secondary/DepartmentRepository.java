package com.example.EmployeeManagementSystem.repository.secondary;

import com.example.EmployeeManagementSystem.model.secondary.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
