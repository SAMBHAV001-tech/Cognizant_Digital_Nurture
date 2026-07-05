package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
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

    private Department dept;
    private Employee emp1;
    private Employee emp2;

    @BeforeEach
    void setUp() {
        dept = new Department(null, "Engineering", new ArrayList<>());
        dept = departmentRepository.save(dept);

        emp1 = new Employee(null, "Alice", "alice@example.com", 60000.0, dept);
        emp2 = new Employee(null, "Bob", "bob@example.com", 80000.0, dept);
        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
    }

    @Test
    void testCustomQueries() {
        List<Employee> listCustom = employeeRepository.findByDepartmentNameCustom("Engineering");
        assertEquals(2, listCustom.size());

        List<Employee> listNative = employeeRepository.findBySalaryGreaterNative(70000.0);
        assertEquals(1, listNative.size());
        assertEquals("Bob", listNative.get(0).getName());
    }

    @Test
    void testNamedQueries() {
        Employee foundNamed = employeeRepository.findByNameNamed("Alice");
        assertNotNull(foundNamed);
        assertEquals("Alice", foundNamed.getName());

        List<Employee> listSalaryGreater = employeeRepository.findBySalaryGreaterNamed(70000.0);
        assertEquals(1, listSalaryGreater.size());
        assertEquals("Bob", listSalaryGreater.get(0).getName());
    }
}
