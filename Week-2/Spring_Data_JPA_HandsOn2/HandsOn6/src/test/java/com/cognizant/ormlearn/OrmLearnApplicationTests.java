package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    @Test
    void testAddSkillToEmployee() {
        Employee employee = employeeService.get(1);
        assertNotNull(employee);
        assertEquals(1, employee.getSkillList().size());

        Skill skill = skillService.get(1);
        assertNotNull(skill);

        employee.getSkillList().add(skill);
        employeeService.save(employee);

        Employee updatedEmployee = employeeService.get(1);
        assertNotNull(updatedEmployee);
        assertEquals(2, updatedEmployee.getSkillList().size());
        assertTrue(updatedEmployee.getSkillList().stream().anyMatch(s -> s.getName().equals("Java")));
        assertTrue(updatedEmployee.getSkillList().stream().anyMatch(s -> s.getName().equals("SQL")));
    }
}
