package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testDerivedQueries() {
        Department dept = new Department(null, "Engineering", new ArrayList<>());
        dept = departmentRepository.save(dept);

        Employee emp1 = new Employee(null, "Alice Smith", "alice@example.com", 75000.0, dept);
        Employee emp2 = new Employee(null, "Bob Jones", "bob@example.com", 80000.0, dept);
        employeeRepository.save(emp1);
        employeeRepository.save(emp2);

        List<Employee> listDept = employeeRepository.findByDepartmentId(dept.getId());
        assertEquals(2, listDept.size());

        Employee foundEmail = employeeRepository.findByEmail("alice@example.com");
        assertNotNull(foundEmail);
        assertEquals("Alice Smith", foundEmail.getName());

        List<Employee> listName = employeeRepository.findByNameContaining("Jones");
        assertEquals(1, listName.size());
        assertEquals("Bob Jones", listName.get(0).getName());

        Department foundDept = departmentRepository.findByName("Engineering");
        assertNotNull(foundDept);
    }
}
