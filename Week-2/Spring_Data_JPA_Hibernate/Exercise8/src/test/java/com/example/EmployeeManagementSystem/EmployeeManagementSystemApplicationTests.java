package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeClassProjection;
import com.example.EmployeeManagementSystem.projection.EmployeeInterfaceProjection;
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

    @BeforeEach
    void setUp() {
        dept = new Department(null, "Engineering", new ArrayList<>());
        dept = departmentRepository.save(dept);

        Employee emp = new Employee(null, "Alice Smith", "alice@example.com", 60000.0, dept);
        employeeRepository.save(emp);
    }

    @Test
    void testProjections() {
        List<EmployeeInterfaceProjection> interfaces = employeeRepository.findInterfaceProjectionsByDepartmentId(dept.getId());
        assertNotNull(interfaces);
        assertEquals(1, interfaces.size());
        assertEquals("Alice Smith", interfaces.get(0).getName());
        assertEquals("Alice Smith (Engineering)", interfaces.get(0).getFullNameWithDept());

        List<EmployeeClassProjection> classes = employeeRepository.findClassProjectionsByDepartmentId(dept.getId());
        assertNotNull(classes);
        assertEquals(1, classes.size());
        assertEquals("Alice Smith", classes.get(0).getName());
        assertEquals("alice@example.com", classes.get(0).getEmail());
    }
}
