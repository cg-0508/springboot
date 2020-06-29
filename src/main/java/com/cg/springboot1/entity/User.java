package com.cg.springboot1.entity;

public class User {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
