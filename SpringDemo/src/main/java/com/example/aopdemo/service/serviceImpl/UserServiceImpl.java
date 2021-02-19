package com.example.aopdemo.service.serviceImpl;

import com.example.aopdemo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("添加操作");
    }

    public void update() {
        System.out.println("修改操作");
    }
}
