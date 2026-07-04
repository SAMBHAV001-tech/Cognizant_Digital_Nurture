package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Test
    void testGetEmployee() {
        Employee employee = employeeService.get(1);
        assertNotNull(employee);
        assertEquals("Alice", employee.getName());
        assertNotNull(employee.getDepartment());
        assertEquals("Human Resources", employee.getDepartment().getName());
    }

    @Test
    void testAddEmployee() {
        Department dept = departmentService.get(2);
        assertNotNull(dept);

        Employee newEmp = new Employee("Charlie", 75000.00, true, LocalDate.of(1995, 12, 10), dept);
        employeeService.save(newEmp);

        Employee retrieved = employeeService.get(newEmp.getId());
        assertNotNull(retrieved);
        assertEquals("Charlie", retrieved.getName());
        assertEquals("Engineering", retrieved.getDepartment().getName());
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = employeeService.get(2);
        assertNotNull(employee);

        Department targetDept = departmentService.get(1);
        assertNotNull(targetDept);

        employee.setDepartment(targetDept);
        employeeService.save(employee);

        Employee retrieved = employeeService.get(2);
        assertEquals("Human Resources", retrieved.getDepartment().getName());
    }
}
