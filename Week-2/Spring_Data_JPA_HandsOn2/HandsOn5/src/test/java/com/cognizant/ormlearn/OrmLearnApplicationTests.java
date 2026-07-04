package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private DepartmentService departmentService;

    @Test
    void testGetDepartment() {
        Department dept = departmentService.get(1);
        assertNotNull(dept);
        assertEquals("Human Resources", dept.getName());

        List<Employee> list = dept.getEmployeeList();
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals("Alice", list.get(0).getName());
    }
}
