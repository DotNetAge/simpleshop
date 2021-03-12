package com.example.simpleshop;

import com.example.simpleshop.controllers.CartController;
import com.example.simpleshop.controllers.auth.AuthController;
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
public class AuthTests {
    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext ctx;

    @Autowired
    protected AuthController controller;


    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }

    @Test
    @DisplayName("获取登录地址")
    public void testAuthorize() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("通过验证码登录获取临时授权码")
    public void testLoginWithMobile() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("用临时授权码交换访问令牌")
    public void testExchangeAccessToken() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("登出并吊销令牌")
    public void testSignOutAndRevokeToken() throws Exception {
        throw new NotImplementedException();
    }
}
