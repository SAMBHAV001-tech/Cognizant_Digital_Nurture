package com.cognizant.springlearn;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCountriesWithValidJwt() throws Exception {
        MvcResult authResult = mockMvc.perform(get("/authenticate")
                        .header("Authorization", "Basic dXNlcjp1c2VycGFzcw=="))
                .andExpect(status().isOk())
                .andReturn();

        String responseString = authResult.getResponse().getContentAsString();
        Map<?, ?> map = new ObjectMapper().readValue(responseString, Map.class);
        String token = (String) map.get("token");

        mockMvc.perform(get("/countries")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("IN"));
    }

    @Test
    void testGetCountriesWithAdminForbiddenJwt() throws Exception {
        MvcResult authResult = mockMvc.perform(get("/authenticate")
                        .header("Authorization", "Basic YWRtaW46YWRtaW5wYXNz"))
                .andExpect(status().isOk())
                .andReturn();

        String responseString = authResult.getResponse().getContentAsString();
        Map<?, ?> map = new ObjectMapper().readValue(responseString, Map.class);
        String token = (String) map.get("token");

        mockMvc.perform(get("/countries")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isForbidden());
    }

    @Test
    void testGetCountriesWithInvalidJwt() throws Exception {
        mockMvc.perform(get("/countries")
                        .header("Authorization", "Bearer invalidtokenhere"))
                .andExpect(status().isForbidden());
    }

    @Test
    void testGetCountriesMissingHeader() throws Exception {
        mockMvc.perform(get("/countries"))
                .andExpect(status().isForbidden());
    }
}
