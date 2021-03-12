package com.example.simpleshop;


import com.example.simpleshop.controllers.SearchController;
import com.example.simpleshop.models.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * 浏览与搜索测试
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BrowseAndSearchTests {
    MockMvc mockMvc;
    @Autowired
    protected SearchController controller;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }

    @Test
    @DisplayName("获取一二级类目")
    public void testMustGet2LevelCategories() throws Exception {
//        mockMvc.perform(get("/categories/").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(array(Category));
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("获取推荐商品并能正常分页")
    public void testMustGetRecommandsProducts() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("通过商品名模糊查询商品")
    public void testMustSearchProductsByName() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("在指定类目下搜索商品")
    public void testMustSearchProductsByNameAndCategory() throws Exception {
        throw new NotImplementedException();
    }


}
