package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testBatchInsert() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(new Employee(null, "Emp" + i, "emp" + i + "@example.com", 50000.0, null));
        }

        employeeService.saveAllInBatch(list);
        assertEquals(50, employeeRepository.count());
    }
}
