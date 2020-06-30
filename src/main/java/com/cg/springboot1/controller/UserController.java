package com.cg.springboot1.controller;

import com.cg.springboot1.constants.ResultCode;
import com.cg.springboot1.entity.User;
import com.cg.springboot1.exception.ServiceException;
import com.cg.springboot1.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(getClass());



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



    @GetMapping("/exception1")
    public User exception1() {
        throw new NullPointerException("error");
    }


    @GetMapping("/exception2")
    public User exception2() {
        throw new ServiceException(ResultCode.PARAM_IS_BLANK);
    }


    @GetMapping("/do_something")
    public void doSomething() {
        logger.info("[doSomething]");
    }

    @GetMapping("/current_user")
    public User currentUser() {
        logger.info("[currentUser]");
        return new User().setId(10).setUsername(UUID.randomUUID().toString());
    }


}
