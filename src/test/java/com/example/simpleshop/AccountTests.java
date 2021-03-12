package com.example.simpleshop;

import com.example.simpleshop.controllers.AccountController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
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
public class AccountTests {
    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext ctx;

    @Autowired
    protected AccountController controller;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }

    @Test
    @DisplayName("更新别名")
    public void testRename() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("获取我的收藏夹")
    public void testGetFav() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("获取个人信息")
    public void testGetUserInfo() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("获取个人地址列表")
    public void testGetShippingAddresses() throws Exception {
    }

    @Test
    @DisplayName("设置默认地址")
    public void testGetDefaultAddress() throws Exception {

    }

}
