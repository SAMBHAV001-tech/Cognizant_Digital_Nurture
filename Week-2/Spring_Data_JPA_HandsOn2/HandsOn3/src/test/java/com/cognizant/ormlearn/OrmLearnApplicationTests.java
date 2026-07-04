package com.cognizant.ormlearn;

import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Test
    void testEntitiesLoaded() {
        assertEquals(2, departmentRepository.count());
        assertEquals(2, employeeRepository.count());
        assertEquals(2, skillRepository.count());
    }
}
