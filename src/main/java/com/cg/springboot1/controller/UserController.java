package com.cg.springboot1.controller;

import com.cg.springboot1.entity.User;
import com.cg.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @return 用户列表
     */
    @GetMapping("")
    public List<User> List() {
        List<User> result = new ArrayList<>();
        result.add(new User().setId(1).setUsername("aaa"));
        result.add(new User().setId(2).setUsername("bbb"));
        result.add(new User().setId(3).setUsername("ccc"));
        return result;
    }

    /**
     * 获得指定用户编号的用户
     * @param id Integer
     * @return User
     */
    @RequestMapping("/{id}")
    public User get(@PathVariable("id") Integer id){
        return new User().setId(id).setUsername("user:"+id);
    }



    /**
     * 获得指定用户编号的用户
     * @param id Integer
     * @return User
     */
    @RequestMapping("/v2/{id}")
    public User get2(@PathVariable("id") Integer id){
        return userService.get(id);
    }


}
