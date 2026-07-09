package com.cognizant.springlearn;

import com.cognizant.springlearn.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringLearnApplicationTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testEmployeeDaoLoads() {
        List<Employee> list = employeeDao.getAllEmployees();
        assertNotNull(list);
        assertEquals(4, list.size());
        assertEquals("Alice", list.get(0).getName());
        assertEquals("HR", list.get(0).getDepartment().getName());
        assertEquals(1, list.get(0).getSkills().size());
        assertEquals("Java", list.get(0).getSkills().get(0).getName());
    }
}
