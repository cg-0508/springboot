package com.cg.springboot1.service;

import com.cg.springboot1.entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    public User get(Integer id){
        return new User().setId(id).setUsername("test service");
    }
}
