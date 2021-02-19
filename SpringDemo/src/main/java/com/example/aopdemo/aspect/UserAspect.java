package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAspect {
    /*
    前置通知
     */
    @Before(value = "execution(* com.example.aopdemo.service.serviceImpl.UserServiceImpl.add(..))")
    public void before(){
        System.out.println("前置通知执行。。。");
    }
}
