package com.example.simpleshop;


import com.example.simpleshop.controllers.admin.RoleController;
import com.example.simpleshop.controllers.admin.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SecurityManagementTests {
    MockMvc mockMvc;

    UserController userController;
    RoleController roleController;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.userController, roleController).build();
    }

    @Test
    @DisplayName("向角色批量添加用户")
    public void testAddUsersToRole() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("向用户添加角色")
    public void testAddRoleToUser() throws Exception {
        throw new NotImplementedException();
    }

    @Test
    @DisplayName("获取控制台菜单")
    public void testGetDashboardMenu() throws Exception {
        throw new NotImplementedException();
    }

}
