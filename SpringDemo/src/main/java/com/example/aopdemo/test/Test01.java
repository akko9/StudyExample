package com.example.aopdemo.test;



import com.example.aopdemo.dao.daoImpl.UserDaoImpl;
import com.example.aopdemo.dao.UserDao;
import com.example.aopdemo.entity.User;
import com.example.aopdemo.proxy.DynamicProxy;
import com.example.aopdemo.service.UserService;
import com.example.aopdemo.service.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test1(){
        DynamicProxy proxy=new DynamicProxy(new UserDaoImpl());
        UserDao proxyInstance = (UserDao) proxy.getProxyInstance();
        User admin = proxyInstance.login("admin", "123456");
        System.out.println(admin.getRole());
    }
    //设置proxy-target-class为true即使用cglib的方式代理对象。
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean04.xml");
        UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.add();
    }
}
