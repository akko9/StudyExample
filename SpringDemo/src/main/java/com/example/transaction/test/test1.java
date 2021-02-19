package com.example.transaction.test;

import com.example.transaction.service.MoneyService;
import com.example.transaction.service.impl.MoneyServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class test1 {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean06.xml");
        MoneyService moneyService = context.getBean("moneyServiceImpl", MoneyServiceImpl.class);
        moneyService.MoneyOperation("张三","李四",100.0);

    }
}
