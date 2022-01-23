package com.converter.converter;

import com.converter.converter.dto.RequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void convert_test() throws Exception {
        String expected_key = "amount"; // In case of https://exchangeratesapi.io/ works fine
        RequestDTO requestDTO = new RequestDTO("EUR", "TRY", 100);
        mvc.perform( MockMvcRequestBuilders
                .post("/converter/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(expected_key).exists());
    }

    @Test
    public void convert_test_bad_request() throws Exception {
        String expected_key = "message"; // In case of bad request input
        RequestDTO requestDTO = new RequestDTO("EUR", "TRQ", 100);
        mvc.perform( MockMvcRequestBuilders
                        .post("/converter/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDTO))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath(expected_key).exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
