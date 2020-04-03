package com.example.work_05_zadanie_03_currency.controller;

import com.example.work_05_zadanie_03_currency.service.ServiceCurrency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@WebMvcTest
public class ApiCurrencyTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceCurrency serviceCurrency;


    @Test
    public void verifiesHomePageLoads() throws Exception {



        mockMvc.perform(MockMvcRequestBuilders.get("/check?usdInput=4.4"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.model().hasNoErrors())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());

    }

}