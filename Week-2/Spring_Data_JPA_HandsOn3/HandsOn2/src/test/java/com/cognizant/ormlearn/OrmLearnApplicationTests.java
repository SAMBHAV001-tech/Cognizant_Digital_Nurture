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
    void testGetAllPermanentEmployees() {
        List<Employee> list = employeeService.getAllPermanentEmployees();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        for (Employee e : list) {
            assertTrue(e.isPermanent());
            assertNotNull(e.getDepartment());
            assertNotNull(e.getSkillList());
            assertFalse(e.getSkillList().isEmpty());
        }
    }
}
