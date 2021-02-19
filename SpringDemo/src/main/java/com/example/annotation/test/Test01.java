package com.example.annotation.test;


import com.example.annotation.config.MyConfig;
import com.example.annotation.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean03.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();
    }
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        userDao.add();

    }
}
