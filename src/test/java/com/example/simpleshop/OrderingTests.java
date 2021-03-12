package com.example.simpleshop;


import com.example.simpleshop.controllers.OrderController;

import com.example.simpleshop.models.Comment;
import com.example.simpleshop.models.User;
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
import org.springframework.boot.jackson.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
 * 订单业务测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderingTests {
    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext ctx;

    @Autowired
    protected OrderController controller;


    @Before
    public void setup() throws Exception {
        //TODO: 生成token
        this.mockMvc = standaloneSetup(this.controller)
                .alwaysDo(print())
                .alwaysExpect(status().isOk())
                .build();
    }


    @Test
    @DisplayName("从购物车生成订单")
    public void testMustCheckoutOrder() throws Exception {
        // 先加购
        this.mockMvc.perform(post("/orders/{id}/checkout").param("id", "1"))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.items", hasLength(5)));
        // 查询订单是否存在
    }

    @Test
    @DisplayName("商家发货")
    public void testMustDispatchOrder() throws Exception {
        this.mockMvc.perform(post("/orders/{id}/dispatch").param("id", "1"))
                .andExpect(jsonPath("$.status", is("SHIPPED")));
    }

    @Test
    @DisplayName("获取历史订单列表")
    public void testMustGetOrderHistory() throws Exception {
        this.mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("买家取消订单")
    public void testMustCancelOrder() throws Exception {
        //TODO:创建一张待付款的订单
        this.mockMvc.perform(patch("/orders/{id}/cancel").param("id", "1"))
                .andExpect(jsonPath("$.status", is("CANELLED")));

    }

    @Test
    @DisplayName("取消待支付状态以外的订单将出错")
    public void testCanNotCancelOrdersExceptPending() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("买家签收")
    public void testMustSignedForOrderSuccess() throws Exception {
        //TODO:创建一张待签收的订单
        this.mockMvc.perform(patch("/orders/{id}/signed").param("id", "1"))
                .andExpect(jsonPath("$.status", is("SIGNED")));
    }

    @Test
    @DisplayName("不能签收除代收货以外的订单")
    public void testCanNotSignOrdersExceptWaitForSign() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("买家添加评价")
    public void testMustAddCommentToOrder() throws Exception {
        // TODO: 准备样本数据到 resource内
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("买家申请退款退货")
    public void testMustRefundSuccess() throws Exception {
        throw new NotImplementedException();
    }
}
