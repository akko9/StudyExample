package com.example.aopdemo.dao.daoImpl;

import com.example.aopdemo.dao.UserDao;
import com.example.aopdemo.entity.User;

public class UserDaoImpl implements UserDao {
    public User login(String name, String password) {
        if ("admin".equals(name)&& "123456".equals(password)){
            User user=new User();
            user.setName("admin");
            user.setId(1);
            user.setRole("管理员");
            return user;
        }else{
            return null;
        }
    }
}
