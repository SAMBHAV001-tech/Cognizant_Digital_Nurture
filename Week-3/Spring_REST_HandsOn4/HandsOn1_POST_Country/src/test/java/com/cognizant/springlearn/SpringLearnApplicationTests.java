package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCountries() throws Exception {
        mockMvc.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("IN"));
    }

    @Test
    void testGetCountryByCode() throws Exception {
        mockMvc.perform(get("/countries/IN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void testGetCountryByCodeNotFound() throws Exception {
        mockMvc.perform(get("/countries/XX"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testAddCountry() throws Exception {
        mockMvc.perform(post("/countries")
                        .param("code", "FR")
                        .param("name", "France"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("FR"))
                .andExpect(jsonPath("$.name").value("France"));
    }
}
