package com.example.simpleshop;


import com.example.simpleshop.controllers.CartController;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


import java.rmi.server.ExportException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 购物车测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShoppingTests {
    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext ctx;

    @Autowired
    protected CartController controller;


    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }


    @Test
    @DisplayName("加入购物车")
    public void testMustAddToCart() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("更改购物车中产品数量与价格")
    public void testMustChangedItemQuantity() throws Exception {
        throw new NotImplementedException();
    }


    @Test
    @DisplayName("删除购物车中的产品项")
    public void testMustRemoveItems() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("清空购物车")
    public void testMustCleanCart() throws Exception {
        throw new NotImplementedException();
    }

}
