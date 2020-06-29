package com.cg.springboot1.controller;

import com.cg.springboot1.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    public void testList() throws Exception {
        // 查询用户列表
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/users"));
        // 校验结果
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
        resultActions.andExpect(MockMvcResultMatchers.content().json("[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"username\": \"aaa\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"username\": \"bbb\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"username\": \"ccc\"\n" +
                "    }\n" +
                "]")); // 响应结果


        // <1> 打印结果
        resultActions.andDo(MockMvcResultHandlers.print());

        // <2> 获得 MvcResult ，后续执行各种自定义逻辑
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("拦截器数量：" + Objects.requireNonNull(mvcResult.getInterceptors()).length);
    }


    @Test
    public void testGet() throws Exception {
        // 获得指定用户编号的用户
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/users/1"));
        // 校验结果
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200
        resultActions.andExpect(MockMvcResultMatchers.content().json("{\n" +
                "\"id\": 1,\n" +
                "\"username\": \"user:1\"\n" +
                "}")); // 响应结果
    }
}
