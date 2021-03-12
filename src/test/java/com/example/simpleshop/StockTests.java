package com.example.simpleshop;

import com.example.simpleshop.controllers.admin.StockController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StockTests {
    MockMvc mockMvc;

    @Autowired
    protected StockController controller;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }


    @Test
    @DisplayName("进仓")
    public void testMustTransInStock() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("出仓")
    public void testMustTransOutFromStock() throws Exception {
        throw new NotImplementedException();
    }


    @Test
    @DisplayName("转仓")
    public void testMustTransToOtherWarehouse() throws Exception {
        throw new NotImplementedException();
    }
}
