package com.cognizant.springlearn;

import com.cognizant.springlearn.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        EmployeeDao.reset();
    }

    @Test
    void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("E001"))
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    void testDeleteEmployeeSuccess() throws Exception {
        mockMvc.perform(delete("/employees/E001"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("E002"));
    }

    @Test
    void testDeleteEmployeeNotFound() throws Exception {
        mockMvc.perform(delete("/employees/E999"))
                .andExpect(status().isNotFound());
    }
}
