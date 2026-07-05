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
    void testSearchEmployees() {
        List<Employee> listName = employeeService.searchEmployees("Alice", null, null, null);
        assertNotNull(listName);
        assertEquals(1, listName.size());
        assertEquals("Alice", listName.get(0).getName());

        List<Employee> listSalary = employeeService.searchEmployees(null, 70000.0, null, null);
        assertNotNull(listSalary);
        assertEquals(1, listSalary.size());
        assertEquals("Bob", listSalary.get(0).getName());

        List<Employee> listPerm = employeeService.searchEmployees(null, null, null, true);
        assertNotNull(listPerm);
        assertEquals(2, listPerm.size());
    }
}
