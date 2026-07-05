package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private Department dept;

    @BeforeEach
    void setUp() {
        dept = new Department(null, "Engineering", new ArrayList<>());
        dept = departmentRepository.save(dept);

        employeeRepository.save(new Employee(null, "Alice", "alice@example.com", 60000.0, dept));
        employeeRepository.save(new Employee(null, "Bob", "bob@example.com", 80000.0, dept));
        employeeRepository.save(new Employee(null, "Charlie", "charlie@example.com", 70000.0, dept));
    }

    @Test
    void testPaginationAndSorting() {
        Pageable pageable = PageRequest.of(0, 2, Sort.by("salary").descending());
        Page<Employee> page = employeeRepository.findAll(pageable);

        assertNotNull(page);
        assertEquals(2, page.getContent().size());
        assertEquals("Bob", page.getContent().get(0).getName());
        assertEquals("Charlie", page.getContent().get(1).getName());
        assertEquals(3, page.getTotalElements());
        assertEquals(2, page.getTotalPages());

        Page<Employee> searchPage = employeeRepository.findByNameContaining("li", PageRequest.of(0, 10, Sort.by("name").ascending()));
        assertEquals(2, searchPage.getContent().size());
        assertEquals("Alice", searchPage.getContent().get(0).getName());
        assertEquals("Charlie", searchPage.getContent().get(1).getName());
    }
}
