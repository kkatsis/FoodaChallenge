package com.fooda.challenge;


import com.fooda.challenge.controller.CustomerController;
import com.fooda.challenge.model.CustomerRequest;
import com.fooda.challenge.model.Events;
import com.fooda.challenge.repository.CustomerRepository;
import com.fooda.challenge.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CustomerServiceTest {

    @Mock
    CustomerRepository repository;

    @MockBean
    CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReadAndOutput() throws Exception {
        String input = "{\"events\":[{\"action\":\"new_customer\",\"name\":\"Jessica\",\"timestamp\":\"2020-07-01T00:00:00-05:00\"},{\"action\":\"new_customer\",\"name\":\"Will\",\"timestamp\":\"2020-07-01T01:00:00-05:00\"},{\"action\":\"new_customer\",\"name\":\"Elizabeth\",\"timestamp\":\"2020-07-01T12:00:00-05:00\"},{\"action\":\"new_order\",\"customer\":\"Jessica\",\"amount\":12.50,\"timestamp\":\"2020-07-01T12:15:57-05:00\"},{\"action\":\"new_order\",\"customer\":\"Jessica\",\"amount\":16.50,\"timestamp\":\"2020-07-01T10:01:00-05:00\"},{\"action\":\"new_order\",\"customer\":\"Will\",\"amount\":8.90,\"timestamp\":\"2020-07-01T12:20:00-05:00\"},{\"action\":\"new_order\",\"customer\":\"Will\",\"amount\":1.50,\"timestamp\":\"2020-07-01T12:21:00-05:00\"}]}";
        mockMvc.perform(
                post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input)
        )
                .andExpect(status().isOk());
    }
}
