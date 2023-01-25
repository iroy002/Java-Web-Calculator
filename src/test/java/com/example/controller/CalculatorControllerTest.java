package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.controller.CalculatorController;

class CalculatorControllerTest {

    @Test
    void testCalculate() throws Exception {
        CalculatorController controller = new CalculatorController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                .param("firstNumber", "10")
                .param("secondNumber", "5")
                .param("operator", "add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("result", 15.0))
                .andExpect(MockMvcResultMatchers.view().name("calculator"));
    }
}
