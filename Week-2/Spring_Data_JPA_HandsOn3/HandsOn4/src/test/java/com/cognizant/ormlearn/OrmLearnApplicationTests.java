package com.cognizant.ormlearn;

import com.cognizant.ormlearn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetAverageSalaryByDept() {
        Double avg1 = employeeService.getAverageSalaryByDept(1);
        assertNotNull(avg1);
        assertEquals(60000.00, avg1, 0.01);

        Double avg2 = employeeService.getAverageSalaryByDept(2);
        assertNotNull(avg2);
        assertEquals(80000.00, avg2, 0.01);
    }
}
