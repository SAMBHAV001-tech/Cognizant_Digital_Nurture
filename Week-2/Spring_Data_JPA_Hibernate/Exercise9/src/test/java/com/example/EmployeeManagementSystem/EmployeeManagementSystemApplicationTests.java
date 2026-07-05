package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.model.secondary.Department;
import com.example.EmployeeManagementSystem.repository.primary.EmployeeRepository;
import com.example.EmployeeManagementSystem.repository.secondary.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testMultipleDataSources() {
        Employee emp = new Employee(null, "Alice Primary", "primary@example.com", 55000.0);
        Employee savedEmp = employeeRepository.save(emp);
        assertNotNull(savedEmp.getId());
        assertEquals("Alice Primary", employeeRepository.findById(savedEmp.getId()).get().getName());

        Department dept = new Department(null, "Sales Secondary");
        Department savedDept = departmentRepository.save(dept);
        assertNotNull(savedDept.getId());
        assertEquals("Sales Secondary", departmentRepository.findById(savedDept.getId()).get().getName());
    }
}
