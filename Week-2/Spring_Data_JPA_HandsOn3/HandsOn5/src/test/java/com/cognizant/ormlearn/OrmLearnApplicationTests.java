package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetAllEmployeesNative() {
        List<Employee> list = employeeService.getAllEmployeesNative();
        assertNotNull(list);
        assertEquals(2, list.size());
        assertEquals("Alice", list.get(0).getName());
        assertEquals("Bob", list.get(1).getName());
    }
}
