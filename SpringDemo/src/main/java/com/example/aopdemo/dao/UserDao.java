package com.example.aopdemo.dao;

import com.example.aopdemo.entity.User;
import org.springframework.stereotype.Component;


public interface UserDao {
    public User login(String name,String password);
}
