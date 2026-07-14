package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCountriesWithUser() throws Exception {
        mockMvc.perform(get("/countries")
                        .header("Authorization", "Basic dXNlcjp1c2VycGFzcw=="))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("IN"));
    }

    @Test
    void testGetCountriesWithAdminForbidden() throws Exception {
        mockMvc.perform(get("/countries")
                        .header("Authorization", "Basic YWRtaW46YWRtaW5wYXNz"))
                .andExpect(status().isForbidden());
    }

    @Test
    void testGetCountriesWithInvalidCredentials() throws Exception {
        mockMvc.perform(get("/countries")
                        .header("Authorization", "Basic dXNlcjp3cm9uZw=="))
                .andExpect(status().isUnauthorized());
    }
}
