package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testAuditing() {
        Employee emp = new Employee(null, "Alice", "alice@example.com", 60000.0, null);
        Employee saved = employeeRepository.saveAndFlush(emp);

        assertNotNull(saved.getCreatedDate());
        assertNotNull(saved.getLastModifiedDate());
        assertEquals("admin", saved.getCreatedBy());
        assertEquals("admin", saved.getLastModifiedBy());
    }
}
