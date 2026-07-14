package com.cognizant.springlearn;

import com.cognizant.springlearn.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
    void testUpdateEmployeeSuccess() throws Exception {
        String updatedEmployeeJson = "{"
                + "\"id\":\"E001\","
                + "\"name\":\"Alice Updated\","
                + "\"salary\":75000.0,"
                + "\"department\":{\"id\":1,\"name\":\"HR\"},"
                + "\"skills\":[{\"id\":1,\"name\":\"Java\"}]"
                + "}";

        mockMvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedEmployeeJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("E001"))
                .andExpect(jsonPath("$[0].name").value("Alice Updated"))
                .andExpect(jsonPath("$[0].salary").value(75000.0));
    }

    @Test
    void testUpdateEmployeeNotFound() throws Exception {
        String nonExistentEmployeeJson = "{"
                + "\"id\":\"E999\","
                + "\"name\":\"Unknown\","
                + "\"salary\":50000.0,"
                + "\"department\":{\"id\":1,\"name\":\"HR\"},"
                + "\"skills\":[]"
                + "}";

        mockMvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(nonExistentEmployeeJson))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateEmployeeValidationError() throws Exception {
        String invalidEmployeeJson = "{"
                + "\"id\":\"E001\","
                + "\"name\":\"\","
                + "\"salary\":-1000.0,"
                + "\"department\":{\"id\":1,\"name\":\"HR\"},"
                + "\"skills\":[]"
                + "}";

        mockMvc.perform(put("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidEmployeeJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.errors").exists());
    }
}
